package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.VaccineScheduleDTO;
import com.app.entity.ScheduleStatus;
import com.app.entity.VaccineSchedule;
import com.app.repository.VaccineScheduleRepository;

@Service
@Transactional
public class VaccineScheduleServiceImpl implements VaccineScheduleService {

	@Autowired
	private VaccineScheduleRepository vaccineScheduleRepository;

	@Autowired
	private ModelMapper modelMapper; // Use ModelMapper for DTO-to-entity and vice versa mapping

	@Override
	public List<VaccineScheduleDTO> getAllVaccineSchedules() {
		List<VaccineSchedule> vaccineSchedules = vaccineScheduleRepository.findAll();
		return vaccineSchedules.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public VaccineScheduleDTO getVaccineScheduleById(Long scheduleId) {
		VaccineSchedule vaccineSchedule = vaccineScheduleRepository.findById(scheduleId).orElse(null);
		return (vaccineSchedule != null) ? convertToDTO(vaccineSchedule) : null;
	}

	@Override
	public VaccineScheduleDTO createVaccineSchedule(VaccineScheduleDTO vaccineScheduleDTO) {
		VaccineSchedule vaccineSchedule = convertToEntity(vaccineScheduleDTO);
		vaccineSchedule = vaccineScheduleRepository.save(vaccineSchedule);
		return convertToDTO(vaccineSchedule);
	}

	@Override
	public VaccineScheduleDTO updateVaccineSchedule(Long scheduleId, VaccineScheduleDTO vaccineScheduleDTO) {
		VaccineSchedule existingVaccineSchedule = vaccineScheduleRepository.findById(scheduleId).orElse(null);
		if (existingVaccineSchedule != null) {
			// Update existing vaccine schedule entity with new data
			existingVaccineSchedule.setScheduledDate(vaccineScheduleDTO.getScheduledDate());
			existingVaccineSchedule.setAdministeredDate(vaccineScheduleDTO.getAdministeredDate());
			existingVaccineSchedule.setStatus(ScheduleStatus.valueOf((vaccineScheduleDTO.getStatus().toUpperCase())));

			// Save updated vaccine schedule entity
			existingVaccineSchedule = vaccineScheduleRepository.save(existingVaccineSchedule);
			return convertToDTO(existingVaccineSchedule);
		} else {
			return null;
		}
	}

	@Override
	public void deleteVaccineSchedule(Long scheduleId) {
		vaccineScheduleRepository.deleteById(scheduleId);
	}

	// Helper methods for mapping between DTO and entity
	private VaccineScheduleDTO convertToDTO(VaccineSchedule vaccineSchedule) {
		return modelMapper.map(vaccineSchedule, VaccineScheduleDTO.class);
	}

	private VaccineSchedule convertToEntity(VaccineScheduleDTO vaccineScheduleDTO) {
		return modelMapper.map(vaccineScheduleDTO, VaccineSchedule.class);
	}
}
