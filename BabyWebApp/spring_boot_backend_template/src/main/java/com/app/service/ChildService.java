package com.app.service;

import java.util.List;

import com.app.dto.ChildDTO;

public interface ChildService {

	List<ChildDTO> getAllChildren();

	ChildDTO getChildById(Long childId);

	ChildDTO createChild(ChildDTO childDTO);

	ChildDTO updateChild(Long childId, ChildDTO childDTO);

	void deleteChild(Long childId);
}
