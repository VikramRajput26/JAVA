package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.VaccineDTO;
import com.app.service.VaccineService;

@RestController
@RequestMapping("/api/vaccines")
public class VaccineController {

	@Autowired
	private VaccineService vaccineService;

	@GetMapping
	public ResponseEntity<List<VaccineDTO>> getAllVaccines() {
		List<VaccineDTO> vaccines = vaccineService.getAllVaccines();
		return new ResponseEntity<>(vaccines, HttpStatus.OK);
	}

	@GetMapping("/{vaccineId}")
	public ResponseEntity<VaccineDTO> getVaccineById(@PathVariable Long vaccineId) {
		VaccineDTO vaccineDTO = vaccineService.getVaccineById(vaccineId);
		if (vaccineDTO != null) {
			return new ResponseEntity<>(vaccineDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<VaccineDTO> createVaccine(@RequestBody VaccineDTO vaccineDTO) {
		VaccineDTO createdVaccine = vaccineService.createVaccine(vaccineDTO);
		return new ResponseEntity<>(createdVaccine, HttpStatus.CREATED);
	}

	@PutMapping("/{vaccineId}")
    public ResponseEntity<VaccineDTO> updateVaccine(@PathVariable Long vaccineId, @RequestBody VaccineDTO vaccineDTO) {
        VaccineDTO updatedVaccine = vaccineService.updateVaccine(vaccineId, vaccineDTO);
        if (updatedVaccine != null) {
            return new ResponseEntity<>(updatedVaccine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
