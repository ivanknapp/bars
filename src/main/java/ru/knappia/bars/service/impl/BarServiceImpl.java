package ru.knappia.bars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knappia.bars.repository.Bar;
import ru.knappia.bars.repository.BarRepository;
import ru.knappia.bars.service.BarService;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class BarServiceImpl implements BarService {
    @Autowired
    BarRepository barRepository;

    @Override
    public List<Bar> getAllBars() {
        return barRepository.findAll();
    }

    @Override
    public Long getCount() {
        return barRepository.count();
    }

    @Override
    public List<Bar> findBarByName(String name) {
        return barRepository.findAllByName(name);
    }

    @Override
    public List<Bar> searchByName(String name) {
        final String namePattern = makeSearchPattern(name);
        return barRepository.searchByName(namePattern);
    }

    @Override
    public List<Bar> searchByAddress(String address) {
        final String addressPattern = makeSearchPattern(address);
        return barRepository.searchByAddress(addressPattern);
    }

    @Override
    public List<Bar> searchByAddress(String address, Integer limit) {
        final String addressPattern = makeSearchPattern(address);
        return barRepository.searchByAddressAndLimit(addressPattern, limit);
    }

    @Override
    public List<Bar> searchByDistrict(String district) {
        final String districtPattern = makeSearchPattern(district);
        return barRepository.searchByDistrict(districtPattern);
    }

    @Override
    public Optional<Bar> findBarById(Integer id) {
        return barRepository.findById(id);
    }

    @NotNull
    private String makeSearchPattern(String string){
        return string
                .replaceAll("[^a-zA-Z0-9a-яА-Я]", " ")
                .replaceAll("\\s+", " ")
                .trim()
                .replaceAll("\\s", " <-> ");
    }

    @Override
    public List<Bar> findBarByType(String type) {
        return barRepository.findAllByType(type);
    }
}
