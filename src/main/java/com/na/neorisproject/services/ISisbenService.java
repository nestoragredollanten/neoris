package com.na.neorisproject.services;

import com.na.neorisproject.dtos.SisbenDto;
import com.na.neorisproject.payloads.SisbenForm;

import java.util.List;

/**
 * @author nagredo
 * @project neoris-project
 * @class IService
 */
public interface ISisbenService {
    List<SisbenDto> findAll();
    SisbenDto create(SisbenForm sisbenForm);
    SisbenDto update(SisbenForm sisbenForm);
    boolean delete(Integer id);
    SisbenDto findById(Integer id);
}
