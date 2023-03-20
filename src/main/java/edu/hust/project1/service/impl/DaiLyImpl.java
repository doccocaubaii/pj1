package edu.hust.project1.service.impl;

import edu.hust.project1.dto.DaiLyDTO;
import edu.hust.project1.entity.DaiLyEntity;
import edu.hust.project1.mapper.DaiLyMapper;
import edu.hust.project1.repository.DaiLyRepository;
import edu.hust.project1.service.DaiLyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaiLyImpl implements DaiLyService {
    @Autowired
    DaiLyRepository daiLyRepo;

    @Autowired
    DaiLyMapper daiLyMapper;

    @Override
    public List<DaiLyDTO> getAll() {
        List<DaiLyEntity> daiLyEntityList = daiLyRepo.findAllByIsActive(1);
        return daiLyMapper.toDto(daiLyEntityList);
    }

    @Override
    public DaiLyDTO getById(Integer id) {
        DaiLyEntity daiLyEntity = daiLyRepo.findByIdAndIsActive(id, 1);
        return daiLyMapper.toDto(daiLyEntity);
    }

    @Override
    public DaiLyDTO save(DaiLyDTO daiLy) {
        DaiLyEntity daiLyEntity = daiLyMapper.toEntity(daiLy);
        return daiLyMapper.toDto(daiLyRepo.save(daiLyEntity));
    }

    @Override
    public Boolean deleteById(Integer id) {
        DaiLyEntity daiLy = daiLyRepo.findByIdAndIsActive(id, 1);
        if (daiLy == null) return false;
        daiLy.setIsActive(0);
        daiLyRepo.save(daiLy);
        return true;
    }
}
