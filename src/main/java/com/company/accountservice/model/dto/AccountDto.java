package com.company.accountservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String id ;

    private String username;
    private String name;

    private String surname;

    private String email;

    private LocalDateTime birthDate;

    private String password;

    private LocalDateTime createdAt;

    private Boolean active;
}
