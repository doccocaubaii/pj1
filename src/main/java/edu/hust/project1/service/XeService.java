package edu.hust.project1.service;

import edu.hust.project1.dto.XeDTO;

import java.util.List;

public interface XeService {
    List<XeDTO> getAll();
    XeDTO getById(Integer id);
    XeDTO save(XeDTO xe);
    Boolean deleteById(Integer id);

    List<XeDTO> getAllByDaily(Integer idDaily);
}
