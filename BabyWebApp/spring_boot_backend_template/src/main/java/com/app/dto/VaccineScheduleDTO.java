package com.app.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VaccineScheduleDTO {

	private Long scheduleId;
	private Long childId;
	private Long vaccineId;
	private LocalDate scheduledDate;
	private LocalDate administeredDate;
	private String status;

	// Getters and setters
}
