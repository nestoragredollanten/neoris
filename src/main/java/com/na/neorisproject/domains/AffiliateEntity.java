package com.na.neorisproject.domains;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nagredo
 * @project neoris-project
 * @class NeorisEntity
 */
@Data
@Entity
@Table(name = "affiliate_tbl", schema = "neoris")
public class AffiliateEntity implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;

    @Id
    @Column(name = "id_affiliate")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "affiliate_generator")
    private Integer id;

    @Column(length = 100)
    private String name;

    @Column
    private Double score;

    @Column(length = 100)
    private String phone;

    @Column(length = 100)
    private String address;

    @Column
    private Date birthdate;

    @Column
    private Date affiliateDate;

    @Column(length = 100)
    private String identificationType;

    @Column(length = 100)
    private String identificationNumber;

    @ManyToOne
    @JoinColumn(name="id_sisben", nullable=false)
    private SisbenEntity idSisben;
}
