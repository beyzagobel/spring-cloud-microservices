package com.beyzagobel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "accounts")
@EqualsAndHashCode(of = "id")
public class Account implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Column(value = "account_username")
    private String username;

    @Column(value = "account_email")
    private String email;

    @Column(value = "account_password")
    private String password;

    @Column(value = "account_created_at")
    private Date createdAt;

    @Column(value = "account_is_active")
    private Boolean isActive;


}
