
package com.portfolio.proyecto.Security.Repository;

import com.portfolio.proyecto.Security.Entity.Rol;
import com.portfolio.proyecto.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolName(RolNombre rolName);
}
