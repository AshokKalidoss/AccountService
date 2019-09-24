package com.demo.account.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Customer {
    @Id
    private String userId;

}
