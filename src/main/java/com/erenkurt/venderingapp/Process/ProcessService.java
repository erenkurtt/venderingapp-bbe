package com.erenkurt.venderingapp.Process;

import com.erenkurt.venderingapp.Process.Process;
import com.erenkurt.venderingapp.Process.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {
    @Autowired
    private ProcessRepository processRepository;
    public List<Process> getProcesses () {
        return processRepository.findAll();
    }

    public Process getOneProcess (String processId) {
        return processRepository.findByProcessId(processId);
    }

    public Process updateProcess(String processId, Process updatedProcess) {
        Process process = processRepository.findByProcessId(processId);

        if (process != null) {
            // Update the existing product with data from updatedProduct
            process.setPayment(updatedProcess.getPayment());
            process.setStatus(updatedProcess.getStatus());

            // Save the updated product to the repository
            return processRepository.save(process);
        } else {
            return null; // Product not found
        }
    }
}
