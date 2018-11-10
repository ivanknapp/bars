package ru.knappia.bars.service;

import ru.knappia.bars.repository.BarEntity;

import java.util.List;

public interface BarService {
    List<BarEntity> getAllBars();

    Long getCount();

    List<BarEntity> findBarByName(String name);

    List<BarEntity> searchByName(String name);

    List<BarEntity> searchByAddress(String address);

    List<BarEntity> searchByDistrict(String district);
}
