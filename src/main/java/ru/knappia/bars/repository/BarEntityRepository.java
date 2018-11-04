package ru.knappia.bars.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BarEntityRepository extends CrudRepository<BarEntity,Integer> {
    List<BarEntity> findAll();
}
