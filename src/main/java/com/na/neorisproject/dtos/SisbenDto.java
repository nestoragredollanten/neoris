package com.na.neorisproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nagredo
 * @project neoris-project
 * @class SisbenDto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SisbenDto {
    private Integer id;
    private String nivel;
    private String description; // (bajo, medio, alto)
    private Double minScore;
    private Double maxScore;

}
