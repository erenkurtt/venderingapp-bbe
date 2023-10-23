package com.erenkurt.venderingapp.Process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(maxAge = 300)
@RestController
@RequestMapping("/processes")
public class ProcessController {
    @Autowired
    private ProcessService processService;
    @GetMapping
    public ResponseEntity<List<Process>> getProcesses() {
        return new ResponseEntity<List<Process>>(processService.getProcesses(), HttpStatus.OK);
    }

    @GetMapping("/{processId}")
    public ResponseEntity<Process> getOneProcess(@PathVariable String processId) {
        Process process = processService.getOneProcess(processId);

        if (process != null) {
            return ResponseEntity.ok(process);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{processId}")
    public ResponseEntity<Process> updateProcess(@PathVariable String processId, @RequestBody Process updatedProcess) {
        Process process = processService.updateProcess(processId, updatedProcess);

        if (process != null) {
            return ResponseEntity.ok(process);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
