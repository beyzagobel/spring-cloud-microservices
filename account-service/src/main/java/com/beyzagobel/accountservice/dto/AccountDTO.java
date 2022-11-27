package com.beyzagobel.accountservice.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class AccountDTO implements Serializable {

    private String id;
    private String username;
    private String email;
    private String password;
    private Date createdAt;
    private Boolean isActive;

}
