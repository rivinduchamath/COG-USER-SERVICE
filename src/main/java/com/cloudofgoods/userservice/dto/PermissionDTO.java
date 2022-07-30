package com.cloudofgoods.userservice.dto;

import com.cloudofgoods.userservice.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDTO implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Integer id;

    private String name;
}

