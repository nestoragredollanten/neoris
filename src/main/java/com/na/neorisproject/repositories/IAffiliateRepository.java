package com.na.neorisproject.repositories;

import com.na.neorisproject.domains.AffiliateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nagredo
 * @project neoris-project
 * @class NeorisRepository
 */
@Repository
public interface IAffiliateRepository extends JpaRepository<AffiliateEntity, Integer> {
}
