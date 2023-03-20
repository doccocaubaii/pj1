package edu.hust.project1.mapper;

import edu.hust.project1.dto.DaiLyDTO;
import edu.hust.project1.entity.DaiLyEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DaiLyMapper extends EntityMapper<DaiLyDTO, DaiLyEntity>{
}
