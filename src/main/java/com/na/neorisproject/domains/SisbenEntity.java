package com.na.neorisproject.domains;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nagredo
 * @project neoris-project
 * @class SistenEntity
 */
@Data
@Entity
@Table(name = "sisben_tbl", schema = "neoris")
public class SisbenEntity implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;

    @Id
    @Column(name = "id_sisben")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sisben_generator")
    private Integer id;

    @Column(length = 100)
    private String nivel;

    @Column(length = 100)
    private String description; // (bajo, medio, alto)

    @Column
    private Double minScore;

    @Column
    private Double maxScore;

}
