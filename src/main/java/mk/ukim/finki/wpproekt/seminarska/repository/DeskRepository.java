package mk.ukim.finki.wpproekt.seminarska.repository;

import mk.ukim.finki.wpproekt.seminarska.model.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeskRepository extends JpaRepository<Desk,Long> {

}
