package ru.knappia.bars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knappia.bars.repository.LegalEntity;
import ru.knappia.bars.repository.LegalEntityRepository;
import ru.knappia.bars.service.BarService;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class BarServiceImpl implements BarService {
    @Autowired
    LegalEntityRepository barEntityRepository;

    @Override
    public List<LegalEntity> getAllBars() {
        return barEntityRepository.findAll();
    }

    @Override
    public Long getCount() {
        return barEntityRepository.count();
    }

    @Override
    public List<LegalEntity> findBarByName(String name) {
        return barEntityRepository.findAllByName(name);
    }

    @Override
    public List<LegalEntity> searchByName(String name) {
        final String namePattern = makeSearchPattern(name);
        return barEntityRepository.searchByName(namePattern);
    }

    @Override
    public List<LegalEntity> searchByAddress(String address) {
        final String addressPattern = makeSearchPattern(address);
        return barEntityRepository.searchByAddress(addressPattern);
    }

    @Override
    public List<LegalEntity> searchByDistrict(String district) {
        final String districtPattern = makeSearchPattern(district);
        return barEntityRepository.searchByDistrict(districtPattern);
    }
    @NotNull
    private String makeSearchPattern(String string){
        return string
                .replaceAll("[^a-zA-Z0-9a-яА-Я]", " ")
                .replaceAll("\\s+", " ")
                .trim()
                .replaceAll("\\s", " <-> ");
    }
}
