
package com.portfolio.proyecto.Security.Controller;

import com.portfolio.proyecto.Security.Entity.Rol;
import com.portfolio.proyecto.Security.Entity.User;
import com.portfolio.proyecto.Security.Enums.RolNombre;
import com.portfolio.proyecto.Security.Service.RolService;
import com.portfolio.proyecto.Security.Service.UserService;
import com.portfolio.proyecto.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/auth") //desde donde lo llamamos
@CrossOrigin
public class AuthController {
    //inyectamos dependencias a usar
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
    
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Messages("campos mal puestos"), HttpStatus.BAD_REQUEST);
        }
        if(userService.getByUserName(userName.getUserName())){
            return new ResponseEntity(new Messages("El nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(userService.getByEmail(userName.getEmail())){
            return new ResponseEntity(new Messages("El Email ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        User user =  new User(newUser.getNombre(), newUser.getUsuario(), newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));
       
        //asignamos los roles
        Set<Rol> roles =  new HashSet<>();
        roles.add(rolService.getByRolName(RolNombre.RULE_USER).get());
        
        if(newUser.getRoles().contains("admin")){
            roles.add(rolService.getByRolName(RolNombre.RULE_ADMIN).get());
        }
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new Messages("usuario guardado"), HttpStatus.CREATED);
        
    }

    
    @PostMapping("/login")
    public ResponseEntity <JwtDTC> login (@Valid @RequestBody LogInUser logInUser, BindingResult bindingResult){
    
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Messages("campos mal puestos"), HttpStatus.BAD_REQUEST);
        }
        
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        logInUser.getUserName(),
                        logInUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt =  jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new jwtDto(jwt,userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);        
    }
}
