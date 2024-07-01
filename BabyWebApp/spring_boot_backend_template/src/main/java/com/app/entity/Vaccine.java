package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaccines")
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vaccineId;

	@Column(name = "vaccine_name")
	private String vaccineName;

	private String description;

	@Column(name = "recommended_age")
	private String recommendedAge;

	@Column(name = "side_effects")
	private String sideEffects;

	// Getters and setters
}
