package com.erenkurt.venderingapp.System;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "system")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class System {
    @Id
    private ObjectId id;
    private int systemId;
    private double balance;
    private int temperature;

    public System(int systemId, double balance, int temperature) {
        this.systemId = systemId;
        this.balance = balance;
        this.temperature = temperature;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public double getBalance() {
        return balance;
    }

    public int getTemperature() {
        return temperature;
    }
}
