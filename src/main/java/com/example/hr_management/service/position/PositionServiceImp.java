package com.example.hr_management.service.position;

import com.example.hr_management.dto.position.PositionRequestDTO;
import com.example.hr_management.dto.position.PositionResponseDTO;
import com.example.hr_management.entity.Position;
import com.example.hr_management.exception.ResourceNotFoundException;
import com.example.hr_management.mapper.PositionMapper;
import com.example.hr_management.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

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

    @Override
    public Page<PositionResponseDTO> getPositions(int page,int size){
        return pos_repo.findAll(PageRequest.of(page,size)).map(PositionMapper::toDTO);
    }

    @Override
    public PositionResponseDTO getPositionById(Long id){
        Position pos = pos_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Position ID not found!"));
        return PositionMapper.toDTO(pos);
    }

    @Override
    public PositionResponseDTO updatePosition(Long id,PositionRequestDTO dto){
        Position pos = pos_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Position ID not Found!"));

        pos.setPositionName(dto.getPositionName());
        pos.setBaseSalary(dto.getBaseSalary());
        pos.setUpdatedDate(new Timestamp(System.currentTimeMillis()));

        Position update = pos_repo.save(pos);

        return PositionMapper.toDTO(update);
    }

}
