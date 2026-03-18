package com.example.hr_management.service.position;

import com.example.hr_management.dto.position.PositionRequestDTO;
import com.example.hr_management.dto.position.PositionResponseDTO;
import org.springframework.data.domain.Page;

public interface PositionService {
    PositionResponseDTO createPosition(PositionRequestDTO dto);
    Page<PositionResponseDTO> getPositions(int page,int size);
    PositionResponseDTO getPositionById(Long id);
}
