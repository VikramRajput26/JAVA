package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ChildDTO;
import com.app.service.ChildService;

@RestController
@RequestMapping("/api/children")
public class ChildController {

	@Autowired
	private ChildService childService;

	@GetMapping
	public ResponseEntity<List<ChildDTO>> getAllChildren() {
		List<ChildDTO> children = childService.getAllChildren();
		return new ResponseEntity<>(children, HttpStatus.OK);
	}

	@GetMapping("/{childId}")
	public ResponseEntity<ChildDTO> getChildById(@PathVariable Long childId) {
		ChildDTO childDTO = childService.getChildById(childId);
		if (childDTO != null) {
			return new ResponseEntity<>(childDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<ChildDTO> createChild(@RequestBody ChildDTO childDTO) {
		ChildDTO createdChild = childService.createChild(childDTO);
		return new ResponseEntity<>(createdChild, HttpStatus.CREATED);
	}

	@PutMapping("/{childId}")
	public ResponseEntity<ChildDTO> updateChild(@PathVariable Long childId, @RequestBody ChildDTO childDTO) {
		ChildDTO updatedChild = childService.updateChild(childId, childDTO);
		if (updatedChild != null) {
			return new ResponseEntity<>(updatedChild, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{childId}")
	public ResponseEntity<Void> deleteChild(@PathVariable Long childId) {
		childService.deleteChild(childId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
