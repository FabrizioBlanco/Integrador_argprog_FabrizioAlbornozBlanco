
package com.portfolio.proyecto.Security.Repository;

import com.portfolio.proyecto.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUserRepository extends JpaRepository<User, Integer>{
    Optional<User> findbyUserName(String userName);
    boolean existByUserName(String UserName);
    boolean existByEmail(String email);
}
