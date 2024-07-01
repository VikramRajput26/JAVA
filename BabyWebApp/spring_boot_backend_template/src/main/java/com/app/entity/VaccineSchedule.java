package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "vaccine_schedules")
@Data
public class VaccineSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleId;

	@ManyToOne
	@JoinColumn(name = "child_id")
	private Child child;

	@ManyToOne
	@JoinColumn(name = "vaccine_id")
	private Vaccine vaccine;

	@Column(name = "scheduled_date")
	private LocalDate scheduledDate;

	@Column(name = "administered_date")
	private LocalDate administeredDate;

	@Enumerated(EnumType.STRING)
	private ScheduleStatus status;

	// Getters and setters
}
