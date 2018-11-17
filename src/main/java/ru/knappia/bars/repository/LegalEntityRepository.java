package ru.knappia.bars.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LegalEntityRepository extends CrudRepository<LegalEntity, Integer> {
    List<LegalEntity> findAll();

    List<LegalEntity> findAllByName(String name);

    @Query(value = "select * from bar.entity " +
            "where to_tsvector('russian', name) @@ to_tsquery('russian', ?1)",
            nativeQuery = true
    )
    List<LegalEntity> searchByName(String name);

    @Query(value = "select * from bar.entity " +
            "where to_tsvector('russian', address) @@ to_tsquery('russian', ?1)",
            nativeQuery = true
    )
    List<LegalEntity> searchByAddress(String address);

    @Query(value = "select * from bar.entity " +
            "where to_tsvector('russian', district) @@ to_tsquery('russian', ?1)",
            nativeQuery = true
    )
    List<LegalEntity> searchByDistrict(String district);

}
