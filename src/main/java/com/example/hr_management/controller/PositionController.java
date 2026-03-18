package com.example.hr_management.controller;

import com.example.hr_management.dto.position.PositionRequestDTO;
import com.example.hr_management.dto.position.PositionResponseDTO;
import com.example.hr_management.service.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/positions")
public class PositionController {
    @Autowired
    private PositionService service;

    @PostMapping
    public PositionResponseDTO create(@RequestBody PositionRequestDTO dto){
        return service.createPosition(dto);
    }
}
