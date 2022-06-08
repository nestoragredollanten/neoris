package com.na.neorisproject.services.impl;

import com.na.neorisproject.domains.AffiliateEntity;
import com.na.neorisproject.domains.SisbenEntity;
import com.na.neorisproject.dtos.AffiliateDto;
import com.na.neorisproject.exceptions.ArgumentRequiredException;
import com.na.neorisproject.exceptions.ModelNotFoundException;
import com.na.neorisproject.payloads.AffiliateForm;
import com.na.neorisproject.repositories.IAffiliateRepository;
import com.na.neorisproject.repositories.ISisbenRepository;
import com.na.neorisproject.services.IAffiliateService;
import com.na.neorisproject.utils.ObjectMapperUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author nagredo
 * @project neoris-project
 * @class NeorisServiceImple
 */
@Service
@AllArgsConstructor
public class AffiliateServiceImpl implements IAffiliateService {

    public static final String ID_REQUIRED = "El id es requerido";
    public static final String NOT_FOUND = "Not found";
    private final IAffiliateRepository affiliateRepository;
    private final ISisbenRepository sisbenRepository;

    @Override
    public List<AffiliateDto> findAll() {
        return ObjectMapperUtils.mapAll(this.affiliateRepository.findAll(), AffiliateDto.class);
    }

    @Override
    public AffiliateDto create(AffiliateForm affiliateForm) {
        AffiliateEntity entity = ObjectMapperUtils.map(affiliateForm, AffiliateEntity.class);
        addSisben(affiliateForm, entity);

        return ObjectMapperUtils.map(this.affiliateRepository.save(entity), AffiliateDto.class);
    }

    @Override
    public AffiliateDto update(AffiliateForm affiliateForm) {
        if (affiliateForm.getId() != null) {
            AffiliateEntity entity = ObjectMapperUtils.map(affiliateForm, AffiliateEntity.class);
            addSisben(affiliateForm, entity);

            return ObjectMapperUtils.map(this.affiliateRepository.save(entity), AffiliateDto.class);
        } else {
            throw new ArgumentRequiredException(ID_REQUIRED);
        }
    }

    @Override
    public boolean delete(Integer id) {
        if (id != null) {
            this.affiliateRepository.delete(ObjectMapperUtils.map(this.findById(id), AffiliateEntity.class));

            return true;
        } else {
            return false;
        }
    }

    @Override
    public AffiliateDto findById(Integer id) {
        return ObjectMapperUtils.map(this.affiliateRepository.findById(id).orElseThrow(
                () -> new ModelNotFoundException(NOT_FOUND)), AffiliateDto.class);
    }

    private void addSisben(AffiliateForm affiliateForm, AffiliateEntity entity) {
        Optional<SisbenEntity> sisbenEntity = this.sisbenRepository.findByScore(affiliateForm.getScore());

        if (sisbenEntity.isPresent())
            entity.setIdSisben(sisbenEntity.get());
    }
}
