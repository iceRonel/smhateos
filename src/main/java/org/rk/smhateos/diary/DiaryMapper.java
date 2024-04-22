package org.rk.smhateos.diary;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiaryMapper {

    DiaryMapper INSTANCE = Mappers.getMapper(DiaryMapper.class);



    @Mapping(source ="identifier",target = "id")
    @Mapping(expression ="java(getSystolic(entry.getPressure().getSystolic()))",target = "systolic")
    DiaryDto map(DiaryEntry entry);
}
