package me.jems;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    // List<Cards> findByTitleContainingOrContentContaining(String text, String textAgain);
    List<Users> findByUserNameEquals(String username);
}