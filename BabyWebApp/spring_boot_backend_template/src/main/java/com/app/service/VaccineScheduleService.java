package com.app.service;

import java.util.List;

import com.app.dto.VaccineScheduleDTO;

public interface VaccineScheduleService {

	List<VaccineScheduleDTO> getAllVaccineSchedules();

	VaccineScheduleDTO getVaccineScheduleById(Long scheduleId);

	VaccineScheduleDTO createVaccineSchedule(VaccineScheduleDTO vaccineScheduleDTO);

	VaccineScheduleDTO updateVaccineSchedule(Long scheduleId, VaccineScheduleDTO vaccineScheduleDTO);

	void deleteVaccineSchedule(Long scheduleId);
}
