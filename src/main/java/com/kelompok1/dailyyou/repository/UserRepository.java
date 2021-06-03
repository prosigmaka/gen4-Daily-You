package com.kelompok1.dailyyou.repository;


import com.kelompok1.dailyyou.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    //retrieve a user object from the database by username
    User findByEmailUser(String email);

    @Query(value = "SELECT u.id FROM User u WHERE u.username = ?1", nativeQuery = false)
    Long findIdByUserName(String userName);

//	LoginDto saveLoginDto (User user);
}
