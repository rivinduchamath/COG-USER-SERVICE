package com.cloudofgoods.userservice.dto;

import com.cloudofgoods.userservice.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDTO implements SuperEntity {

    private Integer id;

    private String name;
}

