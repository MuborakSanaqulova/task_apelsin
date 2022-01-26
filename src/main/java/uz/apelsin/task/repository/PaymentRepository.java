package uz.apelsin.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.apelsin.task.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
