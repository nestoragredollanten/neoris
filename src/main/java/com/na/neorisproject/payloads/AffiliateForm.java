package com.na.neorisproject.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author nagredo
 * @project neoris-project
 * @class NeorisForm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AffiliateForm {
    private Integer id;
    private String name;
    private Double score;
    private String phone;
    private String address;
    private Date birthdate;
    private Date affiliateDate;
    private String identificationType;
    private String identificationNumber;
    private Integer idSisben;

}
