package com.erenkurt.venderingapp.Process;

import com.erenkurt.venderingapp.Demand.Demand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.*;

@Document(collection = "processes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Process {
    @Id
    private ObjectId id;
    private String processId;
    private int payment;
    private String status;
    public String getProcessId() {
        return processId;
    }

    public int getPayment() {
        return payment;
    }

    public String getStatus() {
        return status;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
