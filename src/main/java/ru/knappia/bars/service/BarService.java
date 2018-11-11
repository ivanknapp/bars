package ru.knappia.bars.service;

import ru.knappia.bars.repository.LegalEntity;

import java.util.List;

public interface BarService {
    List<LegalEntity> getAllBars();

    Long getCount();

    List<LegalEntity> findBarByName(String name);

    List<LegalEntity> searchByName(String name);

    List<LegalEntity> searchByAddress(String address);

    List<LegalEntity> searchByDistrict(String district);
}
