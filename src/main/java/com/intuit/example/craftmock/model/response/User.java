package com.intuit.example.craftmock.model.response;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
public class User {
    private UUID id;
    private String fullName;
    private String emailAddress;
    private String physicalAddress;
    
}
