package com.sachin.lms.programserviceapi.repo;


import com.sachin.lms.programserviceapi.entity.Program;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgramRepository extends MongoRepository<Program,String> {
}
