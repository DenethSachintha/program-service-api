package com.sachin.lms.programserviceapi.service.impl;

import com.sachin.lms.programserviceapi.dto.request.RequestProgramDto;
import com.sachin.lms.programserviceapi.dto.response.ResponseProgramDto;
import com.sachin.lms.programserviceapi.entity.Program;
import com.sachin.lms.programserviceapi.entity.Subject;
import com.sachin.lms.programserviceapi.repo.ProgramRepository;
import com.sachin.lms.programserviceapi.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;
    private final ProgramAspectsServiceImpl programAspectsService;


    @Override
    public void createProgram(RequestProgramDto programDto) {
        Program program = Program.builder()
                .name(programDto.getName())
                .price(programDto.getPrice())
                .startDate(programDto.getStartDate())
                .subjects(programDto.getSubjects())
                .build();

        ArrayList<Long> list = new ArrayList<>();
        for (Subject sub:program.getSubjects()
        ) {
            list.add(sub.getId());
        }

        String ids =  list.stream().map(Object::toString).collect(Collectors.joining(", "));

        Boolean isOk = programAspectsService.checkSubjects(ids);

        if(Boolean.TRUE.equals(isOk)){
            programRepository.save(program);
        }else{
            throw new IllegalArgumentException("Try again with available Languages");
        }

    }


    @Override
    public List<ResponseProgramDto> findAllPrograms() {
        List<Program> all = programRepository.findAll();
        List<ResponseProgramDto> list = new ArrayList<>();
        for (Program p:all
        ) {
            list.add(new ResponseProgramDto(
                    p.getId(),p.getName(),p.getPrice(),p.getStartDate(),p.getSubjects()
            ));
        }
        return list;
    }
}