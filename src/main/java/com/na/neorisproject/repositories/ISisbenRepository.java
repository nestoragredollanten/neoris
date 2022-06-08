package com.na.neorisproject.repositories;

import com.na.neorisproject.domains.SisbenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author nagredo
 * @project neoris-project
 * @class ISisbenRepository
 */
@Repository
public interface ISisbenRepository extends JpaRepository<SisbenEntity, Integer> {
    @Query(value = "select * from sisben_tbl st where st.min_score < :score and st.max_score > :score", nativeQuery = true)
    Optional<SisbenEntity> findByScore(@Param("score") Double score);
}
