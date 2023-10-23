package com.erenkurt.venderingapp.Demand;

import com.erenkurt.venderingapp.Process.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemandService {
    @Autowired
    private DemandRepository demandRepository;

    public List<Demand> getDemands () {
        return demandRepository.findAll();
    }
    public Demand getOneDemand (String demandId) {
        return demandRepository.findByDemandId(demandId);
    }

    public Demand updateDemand(String demandId, Demand updatedDemand) {
        Demand demand = demandRepository.findByDemandId(demandId);

        if (demand != null) {
            // Update the existing product with data from updatedProduct
            demand.setPrice(updatedDemand.getPrice());
            demand.setCount(updatedDemand.getCount());

            // Save the updated product to the repository
            return demandRepository.save(demand);
        } else {
            return null; // Product not found
        }
    }
}
