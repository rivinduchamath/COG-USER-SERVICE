package com.cloudofgoods.userservice.dto;

import com.cloudofgoods.userservice.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private Long id;

    private String name;

    private List<PermissionDTO> permissionDTOS;


}
