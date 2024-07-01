package com.app.entity;

import java.time.LocalDateTime;

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

@Entity
@Table(name = "appointments")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appointmentId;

	@ManyToOne
	@JoinColumn(name = "child_id")
	private Child child;

	@Column(name = "clinic_name")
	private String clinicName;

	@Column(name = "appointment_date")
	private LocalDateTime appointmentDate;

	private String reason;

	@Enumerated(EnumType.STRING)
	private AppointmentStatus status;

	// Getters and setters
}
