package com.cloudofgoods.userservice.service;

import com.cloudofgoods.userservice.dto.UserDTO;
import com.cloudofgoods.userservice.dto.UserRegisterDTO;

import java.util.List;

public interface UsersServiceBO {

    UserRegisterDTO save(UserDTO userDTO);

    UserDTO getUser(String profileId, String code, String contentType);

    List<UserDTO>  fetchAllProfiles(String code, String contentType) ;

    UserDTO accountLockUser(String userName, String code, String type);

}
