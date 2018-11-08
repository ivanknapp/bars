package ru.knappia.bars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knappia.bars.repository.BarEntity;
import ru.knappia.bars.repository.BarEntityRepository;
import ru.knappia.bars.service.BarService;

import java.util.List;

@Service
public class BarServiceImpl implements BarService {
    @Autowired
    BarEntityRepository barEntityRepository;

    @Override
    public List<BarEntity> getAllBars() {
        return barEntityRepository.findAll();
    }

    @Override
    public Long getCount() {
        return barEntityRepository.count();
    }

    @Override
    public List<BarEntity> findBarByName(String name) {
        return barEntityRepository.findAllByName(name);
    }
}
