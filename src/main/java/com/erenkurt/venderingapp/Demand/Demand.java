package com.erenkurt.venderingapp.Demand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "demands")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demand {
    @Id
    private ObjectId id;
    private String demandId;
    private int productId;
    private int count;
    private double price;

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int getProductId() {
        return productId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
