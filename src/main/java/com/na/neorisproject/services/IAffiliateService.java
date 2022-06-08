package com.na.neorisproject.services;

import com.na.neorisproject.dtos.AffiliateDto;
import com.na.neorisproject.payloads.AffiliateForm;

import java.util.List;

/**
 * @author nagredo
 * @project neoris-project
 * @class NeorisService
 */
public interface IAffiliateService {
    List<AffiliateDto> findAll();
    AffiliateDto create(AffiliateForm affiliateForm);
    AffiliateDto update(AffiliateForm affiliateForm);
    boolean delete(Integer id);
    AffiliateDto findById(Integer id);
}
