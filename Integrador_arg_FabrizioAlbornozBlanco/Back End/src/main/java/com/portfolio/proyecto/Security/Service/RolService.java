
package com.portfolio.proyecto.Security.Service;

import com.portfolio.proyecto.Security.Entity.Rol;
import com.portfolio.proyecto.Security.Enums.RolNombre;
import com.portfolio.proyecto.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //tener lo mismo que en la base de datos. O sea, se encarga de que tengamos los mismos datos acá y en la base de datos. Esto se llama PERSISTENCIA.
public class RolService {
    @Autowired
    iRolRepository iRolRepository;
    
    public Optional<Rol> getByRolName(RolNombre rolNombre){
        return iRolRepository.findByRolName(rolNombre);
    }
    public void save(Rol rol){
        iRolRepository.save(rol);
    }
}
