package com.rudari.isa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rudari.isa.dtos.BaseDTO;
import com.rudari.isa.mappers.BaseMapper;
import com.rudari.isa.models.BaseEntity;
import com.rudari.isa.services.BaseService;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseController<
		T extends BaseEntity,
		DTO extends BaseDTO<T>,
		DTOLeaf extends BaseDTO<T>,
		Mapper extends BaseMapper<T, DTO, DTOLeaf>
		> {

	BaseService<T> service;
	Mapper mapper;

	public BaseController(BaseService<T> service, Mapper mapper){
		this.service = service;
		this.mapper = mapper;
	}
	@GetMapping
	public List<DTO> findAll() {

		List<DTO> result = new ArrayList<>();
		service.findAll().forEach(item -> result.add(mapper.entityToDTO(item)));
		return result;
	}

	@GetMapping("/{id}")
	public ResponseEntity<DTO> findById(@PathVariable Long id) {
		return service.findById(id).map(item -> ResponseEntity.ok(mapper.entityToDTO(item)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<DTO> create(@RequestBody DTO item) {
		return service.create(mapper.DTOToEntity(item))
				.map(itemT -> ResponseEntity.ok(mapper.entityToDTO(itemT)))
				.orElse(ResponseEntity.badRequest().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<DTO> updatePut(@PathVariable  Long id, @RequestBody DTO item) {
		return service.update(id, mapper.DTOToEntity(item))
				.map(itemT -> ResponseEntity.ok(mapper.entityToDTO(itemT)))
				.orElse(ResponseEntity.badRequest().build());
	}

	@PatchMapping("/{id}")
	public ResponseEntity<DTO> updatePatch(@PathVariable Long id, @RequestBody DTO item) {
		return service.updatePatch(id, mapper.DTOToEntity(item))
				.map(itemT -> ResponseEntity.ok(mapper.entityToDTO(itemT)))
				.orElse(ResponseEntity.badRequest().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
