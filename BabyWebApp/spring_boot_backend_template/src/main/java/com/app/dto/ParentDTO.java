package com.app.dto;

import lombok.Data;

@Data
public class ParentDTO {

	private Long parentId;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phoneNumber;

	// Getters and setters
}
