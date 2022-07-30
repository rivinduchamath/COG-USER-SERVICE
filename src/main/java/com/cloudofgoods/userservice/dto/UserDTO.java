package com.cloudofgoods.userservice.dto;


import com.cloudofgoods.userservice.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;

    private String username;

    private String email;

    private String password;

    private boolean enabled;

    private boolean accountNonExpired;

    private boolean credentialsNonExpired;

    private boolean accountNonLocked;

    private List<RoleDTO> roleDTOS;

    public UserDTO(String username, String email) {
        this.username = username;
        this.email = email;

    }

    public UserDTO(UserDTO userDTO) {
        this.username = userDTO.getUsername();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.enabled = userDTO.isEnabled();
        this.accountNonExpired = userDTO.isAccountNonExpired();
        this.credentialsNonExpired = userDTO.isCredentialsNonExpired();
        this.accountNonLocked = userDTO.isAccountNonLocked();
        this.roleDTOS = userDTO.getRoleDTOS();
    }

}
