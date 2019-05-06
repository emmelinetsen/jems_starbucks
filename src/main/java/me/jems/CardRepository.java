package me.jems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Cards, Integer> {

   // List<Cards> findByTitleContainingOrContentContaining(String text, String textAgain);
}