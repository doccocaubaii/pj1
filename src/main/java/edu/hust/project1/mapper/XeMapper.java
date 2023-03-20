package edu.hust.project1.mapper;

import edu.hust.project1.dto.XeDTO;
import edu.hust.project1.entity.XeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface XeMapper extends EntityMapper<XeDTO, XeEntity>{
    @Override
    @Mapping(source = "idDaiLy", target = "daiLyByIdDaiLy.id")
    XeEntity toEntity(XeDTO xeDTO);

    @Override
    @Mapping(source = "daiLyByIdDaiLy.id", target = "idDaiLy")
    XeDTO toDto(XeEntity xeEntity);
}
