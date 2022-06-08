package com.na.neorisproject.services.impl;

import com.na.neorisproject.domains.SisbenEntity;
import com.na.neorisproject.dtos.SisbenDto;
import com.na.neorisproject.exceptions.ArgumentRequiredException;
import com.na.neorisproject.exceptions.ModelNotFoundException;
import com.na.neorisproject.payloads.SisbenForm;
import com.na.neorisproject.repositories.ISisbenRepository;
import com.na.neorisproject.services.ISisbenService;
import com.na.neorisproject.utils.ObjectMapperUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nagredo
 * @project neoris-project
 * @class SisbenServiceImpl
 */
@Service
@AllArgsConstructor
public class SisbenSisbenServiceImpl implements ISisbenService {

    public static final String ID_REQUIRED = "El id es requerido";
    public static final String NOT_FOUND = "Not found";
    private final ISisbenRepository repository;

    @Override
    public List<SisbenDto> findAll() {
        return ObjectMapperUtils.mapAll(this.repository.findAll(), SisbenDto.class);
    }

    @Override
    public SisbenDto create(SisbenForm sisbenForm) {
        SisbenEntity entity = ObjectMapperUtils.map(sisbenForm, SisbenEntity.class);

        return ObjectMapperUtils.map(this.repository.save(entity), SisbenDto.class);
    }

    @Override
    public SisbenDto update(SisbenForm sisbenForm) {
        if (sisbenForm.getId() != null) {
            SisbenEntity entity = ObjectMapperUtils.map(sisbenForm, SisbenEntity.class);

            return ObjectMapperUtils.map(this.repository.save(entity), SisbenDto.class);
        } else {
            throw new ArgumentRequiredException(ID_REQUIRED);
        }
    }

    @Override
    public boolean delete(Integer id) {
        if (id != null) {
            this.repository.delete(ObjectMapperUtils.map(this.findById(id), SisbenEntity.class));

            return true;
        } else {
            return false;
        }
    }

    @Override
    public SisbenDto findById(Integer id) {
        return ObjectMapperUtils.map(this.repository.findById(id).orElseThrow(
                () -> new ModelNotFoundException(NOT_FOUND)), SisbenDto.class);
    }
}
