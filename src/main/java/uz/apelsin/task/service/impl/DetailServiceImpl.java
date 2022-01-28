package uz.apelsin.task.service.impl;

import org.springframework.stereotype.Service;
import uz.apelsin.task.model.Detail;
import uz.apelsin.task.repository.DetailRepository;
import uz.apelsin.task.service.DetailService;

@Service
public class DetailServiceImpl implements DetailService {

    private final DetailRepository detailRepository;

    public DetailServiceImpl(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Override
    public Detail save(Detail detail) {
        return detailRepository.save(detail);
    }
}
