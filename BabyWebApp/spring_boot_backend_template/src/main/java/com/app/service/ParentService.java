package com.app.service;

import java.util.List;

import com.app.dto.ParentDTO;

public interface ParentService {

	List<ParentDTO> getAllParents();

	ParentDTO getParentById(Long parentId);

	ParentDTO createParent(ParentDTO parentDTO);

	ParentDTO updateParent(Long parentId, ParentDTO parentDTO);

	void deleteParent(Long parentId);
}
