package com.erenkurt.venderingapp.Demand;

import com.erenkurt.venderingapp.Process.Process;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DemandRepository extends MongoRepository<Demand, String> {
    Demand findByDemandId(String demandId);
}
