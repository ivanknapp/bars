package ru.knappia.bars.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "bar", name = "bar")
@Data
public class BarEntity {
    @Id
    private Integer id;

    private String name;
    private String district;
    private String address;
    private String admArea;
    private String publicPhone;

    private String longitudeWGS84;
    private String latitudeWGS84;
}
