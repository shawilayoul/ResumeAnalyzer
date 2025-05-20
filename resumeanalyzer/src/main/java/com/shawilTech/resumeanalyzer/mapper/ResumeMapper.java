package com.shawilTech.resumeanalyzer.mapper;

import com.shawilTech.resumeanalyzer.dto.ResumeUploadResponseDTO;
import com.shawilTech.resumeanalyzer.model.Resume;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResumeMapper {

    ResumeMapper INSTANCEE = Mappers.getMapper(ResumeMapper.class);

    @Mapping(source = "resume.id", target = "resumeId")
    @Mapping(source = "resume.filename", target = "filename")
    @Mapping(source = "feedback", target = "feedback")
    ResumeUploadResponseDTO toDto(Resume resume, String feedback);
}
