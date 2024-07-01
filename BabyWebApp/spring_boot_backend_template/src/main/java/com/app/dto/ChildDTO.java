package com.app.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ChildDTO {

	private Long childId;
	private Long parentId; // Assuming you want to include parent ID in DTO
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String gender;
	private String bloodType;

	// Getters and setters
}
