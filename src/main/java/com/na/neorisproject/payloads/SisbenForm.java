package com.na.neorisproject.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nagredo
 * @project neoris-project
 * @class SisbenForm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SisbenForm {
    private Integer id;
    private String nivel;
    private String description; // (bajo, medio, alto)
    private Double minScore;
    private Double maxScore;

}
