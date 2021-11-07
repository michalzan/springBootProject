package com.engeto.springBootProject.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class AddItemRequest {

    @Size(min = 3, max = 255)
    private String name;
    @Min(1)
    private Long amount;

    public AddItemRequest() {
    }

    public AddItemRequest(@Size(min = 3, max = 255) String name, @Min(1) Long amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
