package com.sachin.lms.programserviceapi.service;

import com.sachin.lms.programserviceapi.dto.request.RequestProgramDto;

public interface ProgramService {
    public void createProgram(RequestProgramDto programDto);
}
