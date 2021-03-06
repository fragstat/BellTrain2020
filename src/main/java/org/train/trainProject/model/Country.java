package org.train.trainProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Страна
 */
@Data
@Entity(name = "Country")
@NoArgsConstructor
public class Country {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Код страны
     */
    @Column(name = "code", nullable = false, unique = true)
    private Integer code;

    /**
     * Название страны
     */
    @Column(name = "country_name", length = 100, nullable = false)
    private String countryName;

    public Country(Integer code, String countryName) {
        this.code = code;
        this.countryName = countryName;
    }
}
