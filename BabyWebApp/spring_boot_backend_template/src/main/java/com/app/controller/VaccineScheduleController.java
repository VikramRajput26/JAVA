package com.app.controller;

import java.util.List;


port org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.VaccineScheduleDTO;
import com.app.service.VaccineScheduleService;
@RestController
@RequestMapping("/api/vaccine-schedules")
public class VaccineScheduleController {

	@Autowired
	private VaccineScheduleService vaccineScheduleService;

	@GetMapping
	public ResponseEntity<List<VaccineScheduleDTO>> getAllVaccineSchedules() {
		List<VaccineScheduleDTO> vaccineSchedules = vaccineScheduleService.getAllVaccineSchedules();
		return new ResponseEntity<>(vaccineSchedules, HttpStatus.OK);
	}

	@GetMapping("/{scheduleId}")
	public ResponseEntity<VaccineScheduleDTO> getVaccineScheduleById(@PathVariable Long scheduleId) {
		VaccineScheduleDTO vaccineScheduleDTO = vaccineScheduleService.getVaccineScheduleById(scheduleId);
		if (vaccineScheduleDTO != null) {
			return new ResponseEntity<>(vaccineScheduleDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<VaccineScheduleDTO> createVaccineSchedule(
			@RequestBody VaccineScheduleDTO vaccineScheduleDTO) {
		VaccineScheduleDTO createdVaccineSchedule = vaccineScheduleService.createVaccineSchedule(vaccineScheduleDTO);
		return new ResponseEntity<>(createdVaccineSchedule, HttpStatus.CREATED);
	}

	@PutMapping("/{scheduleId}")
	public ResponseEntity<VaccineScheduleDTO> updateVaccineSchedule(@PathVariable Long scheduleId,
			@RequestBody VaccineScheduleDTO vaccineScheduleDTO) {
		VaccineScheduleDTO updatedVaccineSchedule = vaccineScheduleService.updateVaccineSchedule(scheduleId,
				vaccineScheduleDTO);
		if (updatedVaccineSchedule != null) {
			return new ResponseEntity<>(updatedVaccineSchedule, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{scheduleId}")
	public ResponseEntity<Void> deleteVaccineSchedule(@PathVariable Long scheduleId) {
		vaccineScheduleService.deleteVaccineSchedule(scheduleId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
