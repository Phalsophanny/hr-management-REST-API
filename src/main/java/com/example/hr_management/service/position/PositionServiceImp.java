package com.example.hr_management.service.position;

import com.example.hr_management.dto.position.PositionRequestDTO;
import com.example.hr_management.dto.position.PositionResponseDTO;
import com.example.hr_management.entity.Position;
import com.example.hr_management.mapper.PositionMapper;
import com.example.hr_management.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImp implements PositionService{
    @Autowired
    private PositionRepository pos_repo;

    @Override
    public PositionResponseDTO createPosition(PositionRequestDTO dto){
        Position pos = PositionMapper.toEntity(dto);
        pos_repo.save(pos);
        return PositionMapper.toDTO(pos);
    }

}
