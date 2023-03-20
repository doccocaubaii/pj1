package edu.hust.project1.service;

import edu.hust.project1.dto.DaiLyDTO;

import java.util.List;

public interface DaiLyService {
    List<DaiLyDTO> getAll();
    DaiLyDTO getById(Integer id);

    DaiLyDTO save(DaiLyDTO daiLy);

    Boolean deleteById(Integer id);
}
