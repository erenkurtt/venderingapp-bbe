package com.erenkurt.venderingapp.Process;

import com.erenkurt.venderingapp.Process.Process;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcessRepository extends MongoRepository<Process, String> {
    Process findByProcessId(String processId);
}
