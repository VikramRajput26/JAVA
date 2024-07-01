package com.app.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AppointmentDTO {

	private Long appointmentId;
	private Long childId;
	private String clinicName;
	private LocalDateTime appointmentDate;
	private String reason;
	private String status;

	// Getters and setters
}
