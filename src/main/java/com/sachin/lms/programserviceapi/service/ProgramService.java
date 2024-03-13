package com.sachin.lms.programserviceapi.service;
import com.sachin.lms.programserviceapi.dto.request.RequestProgramDto;
import com.sachin.lms.programserviceapi.dto.response.ResponseProgramDto;

import java.util.List;

public interface ProgramService {
    public void createProgram(RequestProgramDto programDto);

    List<ResponseProgramDto> findAllPrograms();
}