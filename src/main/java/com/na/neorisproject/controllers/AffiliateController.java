package com.na.neorisproject.controllers;

import com.na.neorisproject.dtos.AffiliateDto;
import com.na.neorisproject.payloads.AffiliateForm;
import com.na.neorisproject.services.IAffiliateService;
import com.na.neorisproject.utils.GeneralBodyResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nagredo
 * @project neoris-project
 * @class NeorisController
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AffiliateController {

    private final IAffiliateService neorisService;

    @GetMapping("/affiliate")
    public ResponseEntity<GeneralBodyResponse<List<AffiliateDto>>> getAll() {
        try {
            List<AffiliateDto> affiliateDtos = this.neorisService.findAll();

            if (!affiliateDtos.isEmpty())
                return new ResponseEntity<>(new GeneralBodyResponse<>(affiliateDtos, "list neoris", null), HttpStatus.OK);
            else
                return new ResponseEntity<>(new GeneralBodyResponse<>(null, "empty", null), HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/affiliate")
    public ResponseEntity<GeneralBodyResponse<AffiliateDto>> create(@RequestBody AffiliateForm affiliateForm) {
        try {
            AffiliateDto affiliateDto = this.neorisService.create(affiliateForm);

            if (affiliateDto.getId() != null)
                return new ResponseEntity<>(new GeneralBodyResponse<>(affiliateDto, "created", null), HttpStatus.OK);
            else
                return new ResponseEntity<>(new GeneralBodyResponse<>(null, "not created", null), HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/affiliate")
    public ResponseEntity<GeneralBodyResponse<AffiliateDto>> update(@RequestBody AffiliateForm affiliateForm) {
        try {
            AffiliateDto affiliateDto = this.neorisService.update(affiliateForm);

            return new ResponseEntity<>(new GeneralBodyResponse<>(affiliateDto, "update", null), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("affiliate/{id}")
    public ResponseEntity<GeneralBodyResponse<Boolean>> delete(@PathVariable Integer id) {
        try {
            if (this.neorisService.delete(id))
                return new ResponseEntity<>(new GeneralBodyResponse<>(true, "delete ok", null), HttpStatus.OK);
            else
                return new ResponseEntity<>(new GeneralBodyResponse<>(false, "not delete", null), HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("affiliate/{id}")
    public ResponseEntity<GeneralBodyResponse<AffiliateDto>> findById(@PathVariable Integer id) {
        try {
            AffiliateDto affiliateDto = this.neorisService.findById(id);

            return new ResponseEntity<>(new GeneralBodyResponse<>(affiliateDto, "find neoris", null), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
}
