package com.company.accountservice.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Table(value = "accounts")
public class Account implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Setter
    @Column(value = "uname")
    private String username;

    @Setter
    @Column(value = "name")
    private String name;

    @Setter
    @Column(value = "surname")
    private String surname;

    @Setter
    @Column(value = "email")
    private String email;

    @Setter
    @Column(value = "birth_date")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime birthDate;

    @Setter
    @Column(value = "pwd")
    private String password;

    @Column(value = "created_at")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    @Column(value = "is_active")
    private Boolean active;

}