package com.example.hr_management.mapper;

import com.example.hr_management.dto.position.PositionRequestDTO;
import com.example.hr_management.dto.position.PositionResponseDTO;
import com.example.hr_management.entity.Position;

public class PositionMapper {
    public static Position toEntity(PositionRequestDTO dto){
        Position pos = new Position();

        pos.setPositionName(dto.getPositionName());
        pos.setBaseSalary(dto.getBaseSalary());
        return pos;
    }

    public static PositionResponseDTO toDTO(Position pos){
        PositionResponseDTO dto = new PositionResponseDTO();
        dto.setPositionId(pos.getPositionId());
        dto.setPositionName(pos.getPositionName());
        dto.setBaseSalary(pos.getBaseSalary());
        dto.setCreatedDate(pos.getCreatedDate());
        dto.setUpdatedDate(pos.getUpdatedDate());
        return dto;

    }
}
