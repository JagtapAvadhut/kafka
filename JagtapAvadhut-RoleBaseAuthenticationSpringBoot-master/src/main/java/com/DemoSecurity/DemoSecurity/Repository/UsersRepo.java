package com.DemoSecurity.DemoSecurity.Repository;

//import com.DemoSecurity.DemoSecurity.Entites.Users;
import com.DemoSecurity.DemoSecurity.Entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);

    Optional<Users> findByEmail(String email);


    @Query("SELECT u.userRole FROM Users u WHERE u.username = :username")
    String findUserRoleByUsername(String username);

}
