
package com.portfolio.proyecto.Security.Service;

import com.portfolio.proyecto.Security.Entity.MainUser;
import com.portfolio.proyecto.Security.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    UserService userService;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = userService.getByUserName(username).get();
        
        return MainUser.build(user);
        
    }
    
}
