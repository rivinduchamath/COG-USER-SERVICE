package com.cloudofgoods.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserRegisterDTO implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    @NotNull
    @NotEmpty
    private String username;

    @NotNull
//    @ValidPassword
    @NotEmpty
    private String password;

//    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

    public UserRegisterDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
