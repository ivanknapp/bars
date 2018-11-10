package ru.knappia.bars.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BarEntityRepository extends CrudRepository<BarEntity, Integer> {
    List<BarEntity> findAll();

    List<BarEntity> findAllByName(String name);

    @Query(value = "select * from bar.bar " +
            "where to_tsvector('russian', name) @@ to_tsquery('russian', ?1)",
            nativeQuery = true
    )
    List<BarEntity> searchByName(String name);

    @Query(value = "select * from bar.bar " +
            "where to_tsvector('russian', address) @@ to_tsquery('russian', ?1)",
            nativeQuery = true
    )
    List<BarEntity> searchByAddress(String address);

    @Query(value = "select * from bar.bar " +
            "where to_tsvector('russian', district) @@ to_tsquery('russian', ?1)",
            nativeQuery = true
    )
    List<BarEntity> searchByDistrict(String district);

}
