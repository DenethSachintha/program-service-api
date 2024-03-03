package com.sachin.lms.programserviceapi.service.impl;

import com.sachin.lms.programserviceapi.dto.request.RequestProgramDto;
import com.sachin.lms.programserviceapi.entity.Program;
import com.sachin.lms.programserviceapi.repo.ProgramRepository;
import com.sachin.lms.programserviceapi.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    @Override
    public void createProgram(RequestProgramDto programDto) {
        Program program = Program.builder()
                .name(programDto.getName())
                .price(programDto.getPrice())
                .startDate(programDto.getStartDate())
                .subjects(programDto.getSubjects())
                .build();

        // get All subjects and need to check if there are available or not

        programRepository.save(program);
    }
}