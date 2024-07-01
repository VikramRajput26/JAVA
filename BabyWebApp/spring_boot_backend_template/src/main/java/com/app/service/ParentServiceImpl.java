package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ParentDTO;
import com.app.entity.Parent;
import com.app.repository.ParentRepository;

@Service
@Transactional
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentRepository parentRepository;

	@Autowired
	private ModelMapper modelMapper; // Use ModelMapper for DTO-to-entity and vice versa mapping

	@Override
	public List<ParentDTO> getAllParents() {
		List<Parent> parents = parentRepository.findAll();
		return parents.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public ParentDTO getParentById(Long parentId) {
		Parent parent = parentRepository.findById(parentId).orElse(null);
		return (parent != null) ? convertToDTO(parent) : null;
	}

	@Override
	public ParentDTO createParent(ParentDTO parentDTO) {
		Parent parent = convertToEntity(parentDTO);
		parent = parentRepository.save(parent);
		return convertToDTO(parent);
	}

	@Override
	public ParentDTO updateParent(Long parentId, ParentDTO parentDTO) {
		Parent existingParent = parentRepository.findById(parentId).orElse(null);
		if (existingParent != null) {
			// Update existing parent entity with new data
			existingParent.setFirstName(parentDTO.getFirstName());
			existingParent.setLastName(parentDTO.getLastName());
			existingParent.setAddress(parentDTO.getAddress());
			existingParent.setEmail(parentDTO.getEmail());
			existingParent.setPhoneNumber(parentDTO.getPhoneNumber());

			// Save updated parent entity
			existingParent = parentRepository.save(existingParent);
			return convertToDTO(existingParent);
		} else {
			return null;
		}
	}

	@Override
	public void deleteParent(Long parentId) {
		parentRepository.deleteById(parentId);
	}

	// Helper methods for mapping between DTO and entity
	private ParentDTO convertToDTO(Parent parent) {
		return modelMapper.map(parent, ParentDTO.class);
	}

	private Parent convertToEntity(ParentDTO parentDTO) {
		return modelMapper.map(parentDTO, Parent.class);
	}
}
