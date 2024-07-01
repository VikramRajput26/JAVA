package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ChildDTO;
import com.app.entity.Child;
import com.app.entity.Gender;
import com.app.repository.ChildRepository;

@Service
@Transactional
public class ChildServiceImpl implements ChildService {

	@Autowired
	private ChildRepository childRepository;

	@Autowired
	private ModelMapper modelMapper; // Use ModelMapper for DTO-to-entity and vice versa mapping

	@Override
	public List<ChildDTO> getAllChildren() {
		List<Child> children = childRepository.findAll();
		return children.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public ChildDTO getChildById(Long childId) {
		Child child = childRepository.findById(childId).orElse(null);
		return (child != null) ? convertToDTO(child) : null;
	}

	@Override
	public ChildDTO createChild(ChildDTO childDTO) {
		Child child = convertToEntity(childDTO);
		child = childRepository.save(child);
		return convertToDTO(child);
	}

	@Override
	public ChildDTO updateChild(Long childId, ChildDTO childDTO) {
		Child existingChild = childRepository.findById(childId).orElse(null);
		if (existingChild != null) {
			// Update existing child entity with new data
			existingChild.setFirstName(childDTO.getFirstName());
			existingChild.setLastName(childDTO.getLastName());
			existingChild.setDateOfBirth(childDTO.getDateOfBirth());
			existingChild.setGender(Gender.valueOf(childDTO.getGender().toUpperCase()));
			existingChild.setBloodType(childDTO.getBloodType());

			// Save updated child entity
			existingChild = childRepository.save(existingChild);
			return convertToDTO(existingChild);
		} else {
			return null;
		}
	}

	@Override
	public void deleteChild(Long childId) {
		childRepository.deleteById(childId);
	}

	// Helper methods for mapping between DTO and entity
	private ChildDTO convertToDTO(Child child) {
		return modelMapper.map(child, ChildDTO.class);
	}

	private Child convertToEntity(ChildDTO childDTO) {
		return modelMapper.map(childDTO, Child.class);
	}
}
