package com.erenkurt.venderingapp.System;

import com.erenkurt.venderingapp.System.System;
import com.erenkurt.venderingapp.System.SystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SystemService {
    @Autowired
    private SystemRepository systemRepository;

    public List<System> getSystem() {
        return systemRepository.findAll();
    }

    public System getOneSystem(Integer systemId) {
        return systemRepository.findBySystemId(systemId);
    }

    public System updateSystem(Integer systemId, System updateSystem) {
        System system = systemRepository.findBySystemId(systemId);

        if (system != null) {
            // Update the existing product with data from updatedProduct
            system.setBalance(updateSystem.getBalance());
            system.setTemperature(updateSystem.getTemperature());

            // Save the updated product to the repository
            return systemRepository.save(system);
        } else {
            return null; // Product not found
        }
    }
}
