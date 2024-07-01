package com.app.dto;

import lombok.Data;

@Data
public class VaccineDTO {

	private Long vaccineId;
	private String vaccineName;
	private String description;
	private String recommendedAge;
	private String sideEffects;

	// Getters and setters
}
