package mk.ukim.finki.wpproekt.seminarska.repository;

import mk.ukim.finki.wpproekt.seminarska.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt,Long> {
}
