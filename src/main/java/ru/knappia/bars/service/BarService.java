package ru.knappia.bars.service;

import ru.knappia.bars.repository.Bar;

import java.util.List;
import java.util.Optional;

public interface BarService {
    List<Bar> getAllBars();

    Long getCount();

    List<Bar> findBarByName(String name);

    List<Bar> searchByName(String name);

    List<Bar> searchByAddress(String address);

    List<Bar> searchByAddress(String address, Integer limit);

    List<Bar> searchByDistrict(String district);

    Optional<Bar> findBarById(Integer id);

    List<Bar> findBarByType(String type);
}
