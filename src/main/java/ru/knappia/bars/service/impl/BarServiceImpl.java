package ru.knappia.bars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knappia.bars.repository.LegalEntity;
import ru.knappia.bars.repository.LegalEntityRepository;
import ru.knappia.bars.service.BarService;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class BarServiceImpl implements BarService {
    @Autowired
    LegalEntityRepository legalEntityRepository;

    @Override
    public List<LegalEntity> getAllBars() {
        return legalEntityRepository.findAll();
    }

    @Override
    public Long getCount() {
        return legalEntityRepository.count();
    }

    @Override
    public List<LegalEntity> findBarByName(String name) {
        return legalEntityRepository.findAllByName(name);
    }

    @Override
    public List<LegalEntity> searchByName(String name) {
        final String namePattern = makeSearchPattern(name);
        return legalEntityRepository.searchByName(namePattern);
    }

    @Override
    public List<LegalEntity> searchByAddress(String address) {
        final String addressPattern = makeSearchPattern(address);
        return legalEntityRepository.searchByAddress(addressPattern);
    }

    @Override
    public List<LegalEntity> searchByDistrict(String district) {
        final String districtPattern = makeSearchPattern(district);
        return legalEntityRepository.searchByDistrict(districtPattern);
    }

    @Override
    public Optional<LegalEntity> findBarById(Integer id) {
        return legalEntityRepository.findById(id);
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
