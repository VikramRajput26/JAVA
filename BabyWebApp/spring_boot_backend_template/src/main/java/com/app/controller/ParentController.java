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

import com.app.dto.ParentDTO;
import com.app.service.ParentService;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

	@Autowired
	private ParentService parentService;

	@GetMapping
	public ResponseEntity<List<ParentDTO>> getAllParents() {
		List<ParentDTO> parents = parentService.getAllParents();
		return new ResponseEntity<>(parents, HttpStatus.OK);
	}

	@GetMapping("/{parentId}")
	public ResponseEntity<ParentDTO> getParentById(@PathVariable Long parentId) {
		ParentDTO parentDTO = parentService.getParentById(parentId);
		if (parentDTO != null) {
			return new ResponseEntity<>(parentDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<ParentDTO> createParent(@RequestBody ParentDTO parentDTO) {
		ParentDTO createdParent = parentService.createParent(parentDTO);
		return new ResponseEntity<>(createdParent, HttpStatus.CREATED);
	}

	@PutMapping("/{parentId}")
	public ResponseEntity<ParentDTO> updateParent(@PathVariable Long parentId, @RequestBody ParentDTO parentDTO) {
		ParentDTO updatedParent = parentService.updateParent(parentId, parentDTO);
		if (updatedParent != null) {
			return new ResponseEntity<>(updatedParent, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{parentId}")
	public ResponseEntity<Void> deleteParent(@PathVariable Long parentId) {
		parentService.deleteParent(parentId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
