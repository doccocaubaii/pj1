package edu.hust.project1.service.impl;

import edu.hust.project1.dto.XeDTO;
import edu.hust.project1.entity.XeEntity;
import edu.hust.project1.mapper.XeMapper;
import edu.hust.project1.repository.XeRepository;
import edu.hust.project1.service.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XeImpl implements XeService {

    @Autowired
    XeRepository xeRepo;

    @Autowired
    XeMapper xeMapper;

    @Override
    public List<XeDTO> getAll() {
        List<XeEntity> xeEntityList = xeRepo.findAllByStatus(true);
        return xeMapper.toDto(xeEntityList);
    }

    @Override
    public XeDTO getById(Integer id) {
        XeEntity xeEntity = xeRepo.findByIdAndStatus(id, true);
        return xeMapper.toDto(xeEntity);
    }

    @Override
    public XeDTO save(XeDTO xe) {
        XeEntity xeEntity = xeMapper.toEntity(xe);
        return xeMapper.toDto(xeRepo.save(xeEntity));
    }

    @Override
    public Boolean deleteById(Integer id) {
        XeEntity xe = xeRepo.findByIdAndStatus(id, true);
        if (xe == null) return false;
        xe.setStatus(false);
        xeRepo.save(xe);
        return true;
    }

    @Override
    public List<XeDTO> getAllByDaily(Integer idDaily) {
        List<XeEntity> xeEntityList = xeRepo.queryWithIdDaiLyAndStatus(idDaily, 1);
        return xeMapper.toDto(xeEntityList);
    }
}
