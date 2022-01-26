package uz.apelsin.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.apelsin.task.model.Detail;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {
}
