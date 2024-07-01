package com.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.app.dto.AppointmentDTO;
import com.app.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping
	public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
		List<AppointmentDTO> appointments = appointmentService.getAllAppointments();
		return new ResponseEntity<>(appointments, HttpStatus.OK);
	}

	@GetMapping("/{appointmentId}")
	public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long appointmentId) {
		AppointmentDTO appointmentDTO = appointmentService.getAppointmentById(appointmentId);
		if (appointmentDTO != null) {
			return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
		AppointmentDTO createdAppointment = appointmentService.createAppointment(appointmentDTO);
		return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
	}

	@PutMapping("/{appointmentId}")
	public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable Long appointmentId,
			@RequestBody AppointmentDTO appointmentDTO) {
		AppointmentDTO updatedAppointment = appointmentService.updateAppointment(appointmentId, appointmentDTO);
		if (updatedAppointment != null) {
			return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{appointmentId}")
	public ResponseEntity<Void> deleteAppointment(@PathVariable Long appointmentId) {
		appointmentService.deleteAppointment(appointmentId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
