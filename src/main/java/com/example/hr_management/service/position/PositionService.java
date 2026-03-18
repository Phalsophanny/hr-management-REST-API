package com.example.hr_management.service.position;

import com.example.hr_management.dto.position.PositionRequestDTO;
import com.example.hr_management.dto.position.PositionResponseDTO;

public interface PositionService {
    PositionResponseDTO createPosition(PositionRequestDTO dto);
}
