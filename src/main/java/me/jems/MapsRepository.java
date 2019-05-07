package me.jems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MapsRepository extends JpaRepository<Maps, Integer> {

    // List<Cards> findByTitleContainingOrContentContaining(String text, String textAgain);
    List<Maps> findStoreByCity(String city);
}