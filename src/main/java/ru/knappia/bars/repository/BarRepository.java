package ru.knappia.bars.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BarRepository extends CrudRepository<Bar, Integer> {
    List<Bar> findAll();

    List<Bar> findAllByName(String name);

    List<Bar> findAllByType(String type);

    @Query(value = "select * from bar.entity " +
            "where to_tsvector('russian', name) @@ to_tsquery('russian', ?1)",
            nativeQuery = true
    )
    List<Bar> searchByName(String name);

    @Query(value = "select * from bar.entity " +
            "where to_tsvector('russian', address) @@ to_tsquery('russian', ?1)",
            nativeQuery = true
    )
    List<Bar> searchByAddress(String address);

    @Query(value = "select * from bar.entity " +
            "where to_tsvector('russian', district) @@ to_tsquery('russian', ?1)",
            nativeQuery = true
    )
    List<Bar> searchByDistrict(String district);

}
