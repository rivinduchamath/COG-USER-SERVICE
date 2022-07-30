package com.cloudofgoods.userservice.dto;

import com.cloudofgoods.userservice.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO implements SuperEntity {


    private Long id;

    private String name;

    private List<PermissionDTO> permissionDTOS;


}
