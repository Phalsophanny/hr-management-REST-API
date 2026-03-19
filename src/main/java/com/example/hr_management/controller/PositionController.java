package com.example.hr_management.controller;

import com.example.hr_management.dto.position.PositionRequestDTO;
import com.example.hr_management.dto.position.PositionResponseDTO;
import com.example.hr_management.service.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/positions")
public class PositionController {
    @Autowired
    private PositionService service;

    @PostMapping
    public PositionResponseDTO create(@RequestBody PositionRequestDTO dto){
        return service.createPosition(dto);
    }

    @GetMapping
    public Page<PositionResponseDTO> getPositions(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        return service.getPositions(page,size);
    }

    @GetMapping("/{id}")
    public PositionResponseDTO getPositionById(@PathVariable Long id){
        return service.getPositionById(id);
    }

    @PutMapping("/{id}")
    public PositionResponseDTO updatePosition(@PathVariable Long id,@RequestBody PositionRequestDTO dto){
        return service.updatePosition(id,dto);
    }
}
