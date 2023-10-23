package com.erenkurt.venderingapp.Demand;

import com.erenkurt.venderingapp.Process.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 300)
@RestController
@RequestMapping("/demands")
public class DemandController {
    @Autowired
    private DemandService demandService;

    @GetMapping
    public ResponseEntity<List<Demand>> getDemands() {
        return new ResponseEntity<List<Demand>>(demandService.getDemands(), HttpStatus.OK);
    }

    @GetMapping("/{demandId}")
    public ResponseEntity<Demand> getOneDemand(@PathVariable String demandId) {
        Demand demand = demandService.getOneDemand(demandId);

        if (demand != null) {
            return ResponseEntity.ok(demand);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{demandId}")
    public ResponseEntity<Demand> updateDemand(@PathVariable String demandId, @RequestBody Demand updatedDemand) {
        Demand demand = demandService.updateDemand(demandId, updatedDemand);

        if (demand != null) {
            return ResponseEntity.ok(demand);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
