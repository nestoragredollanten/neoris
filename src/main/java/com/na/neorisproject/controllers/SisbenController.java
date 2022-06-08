package com.na.neorisproject.controllers;

import com.na.neorisproject.dtos.SisbenDto;
import com.na.neorisproject.payloads.SisbenForm;
import com.na.neorisproject.services.ISisbenService;
import com.na.neorisproject.utils.GeneralBodyResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nagredo
 * @project neoris-project
 * @class SisbenController
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class SisbenController {

    private final ISisbenService sisbenService;

    @GetMapping("/sisben")
    public ResponseEntity<GeneralBodyResponse<List<SisbenDto>>> getAll() {
        try {
            List<SisbenDto> sisbenDtos = this.sisbenService.findAll();

            if (!sisbenDtos.isEmpty())
                return new ResponseEntity<>(new GeneralBodyResponse<>(sisbenDtos, "list neoris", null), HttpStatus.OK);
            else
                return new ResponseEntity<>(new GeneralBodyResponse<>(null, "empty", null), HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/sisben")
    public ResponseEntity<GeneralBodyResponse<SisbenDto>> create(@RequestBody SisbenForm sisbenForm) {
        try {
            SisbenDto sisbenDto = this.sisbenService.create(sisbenForm);

            if (sisbenDto.getId() != null)
                return new ResponseEntity<>(new GeneralBodyResponse<>(sisbenDto, "created", null), HttpStatus.OK);
            else
                return new ResponseEntity<>(new GeneralBodyResponse<>(null, "not created", null), HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/sisben")
    public ResponseEntity<GeneralBodyResponse<SisbenDto>> update(@RequestBody SisbenForm sisbenForm) {
        try {
            SisbenDto sisbenDto = this.sisbenService.update(sisbenForm);

            return new ResponseEntity<>(new GeneralBodyResponse<>(sisbenDto, "update", null), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("sisben/{id}")
    public ResponseEntity<GeneralBodyResponse<Boolean>> delete(@PathVariable Integer id) {
        try {
            if (this.sisbenService.delete(id))
                return new ResponseEntity<>(new GeneralBodyResponse<>(true, "delete ok", null), HttpStatus.OK);
            else
                return new ResponseEntity<>(new GeneralBodyResponse<>(false, "not delete", null), HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("sisben/{id}")
    public ResponseEntity<GeneralBodyResponse<SisbenDto>> findById(@PathVariable Integer id) {
        try {
            SisbenDto sisbenDto = this.sisbenService.findById(id);

            return new ResponseEntity<>(new GeneralBodyResponse<>(sisbenDto, "find neoris", null), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
}
