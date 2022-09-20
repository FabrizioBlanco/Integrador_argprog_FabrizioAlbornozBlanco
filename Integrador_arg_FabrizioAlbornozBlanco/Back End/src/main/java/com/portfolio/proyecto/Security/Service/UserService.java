
package com.portfolio.proyecto.Security.Service;

import com.portfolio.proyecto.Security.Entity.User;
import com.portfolio.proyecto.Security.Repository.iUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    iUserRepository iuserRepository;
    
    public Optional<User> getByUserName(String userName){
        return iuserRepository.findbyUserName(userName);
    }
    //verificamos si existen el nombre de usuario y el email
    public boolean existByUserName(String UserName){
        return iuserRepository.existByUserName(UserName);
    }
    public boolean existByEmail(String email){
        return iuserRepository.existByEmail(email);
    }
    //guardamos al usuario
    public void save(User user){
        iuserRepository.save(user);
    }
}
