package me.jems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Cards, Integer> {

   // List<Cards> findByTitleContainingOrContentContaining(String text, String textAgain);
   List<Cards> findByUsernameContaining(String text);
   Cards findByCard_id(String text);
}