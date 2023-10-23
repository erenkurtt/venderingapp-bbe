package com.erenkurt.venderingapp.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(maxAge = 300)
@RestController
@RequestMapping("/system")
public class SystemController {
    @Autowired
    private SystemService systemService;

    @GetMapping
    public ResponseEntity<List<System>> getSystem() {
        return new ResponseEntity<List<System>>(systemService.getSystem(), HttpStatus.OK);
    }

    @GetMapping("/{systemId}")
    public ResponseEntity<System> getOneSystem(@PathVariable Integer systemId) {
        return new ResponseEntity<System>(systemService.getOneSystem(systemId), HttpStatus.OK);
    }

    @PutMapping("/{systemId}")
    public ResponseEntity<System> updateSystem(@PathVariable Integer systemId, @RequestBody System updatedSystem) {
        System system = systemService.updateSystem(systemId, updatedSystem);

        if (system != null) {
            return ResponseEntity.ok(system);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
