package me.jems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Integer> {

   List<Cards> findByUsernameContaining(String text);

}