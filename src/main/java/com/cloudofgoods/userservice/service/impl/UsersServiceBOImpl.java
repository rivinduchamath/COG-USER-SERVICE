package com.cloudofgoods.userservice.service.impl;


import com.cloudofgoods.userservice.dto.UserDTO;
import com.cloudofgoods.userservice.dto.UserRegisterDTO;
import com.cloudofgoods.userservice.service.UsersServiceBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersServiceBOImpl implements UsersServiceBO {

    final RestTemplate restTemplate;

    @Override
    public UserRegisterDTO save(UserDTO userDTO) {

        String getUserURL = "http://localhost:9191//registration/users";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(getUserURL);
        UriComponents uriComponents = builder.build().encode();
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getEmail());
        ParameterizedTypeReference<UserRegisterDTO> responseType = new ParameterizedTypeReference<UserRegisterDTO>() {
        };
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<Object>(userRegisterDTO, headers);
        return restTemplate.exchange(uriComponents.toUri(), HttpMethod.POST, entity, responseType).getBody();
    }

    @Override
    public UserDTO getUser(String userName, String code, String contentType) {
        String getCustomerUri = "http://localhost:9191/getuser";

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(getCustomerUri); // The allRequestParams must have been built for all the query params
        UriComponents uriComponents = builder.build().encode();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", code);
        headers.set("userName", userName);
        headers.set("Content-Type", contentType);
        ParameterizedTypeReference<UserDTO> responseType = new ParameterizedTypeReference<UserDTO>() {
        };

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, entity, responseType).getBody();
    }

    @Override
    public List<UserDTO> fetchAllProfiles(String code, String contentType) {

        String getCustomerUri = "http://localhost:9191//getallusers";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(getCustomerUri);
        UriComponents uriComponents = builder.build().encode();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", code);
        headers.set("Content-Type", contentType);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ParameterizedTypeReference<List<UserDTO>> typeRef = new ParameterizedTypeReference<List<UserDTO>>() {
        };
        return restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, entity, typeRef).getBody();
    }

    @Override
    public UserDTO accountLockUser(String userName, String code, String type) {
        String getCustomerUri = "http://localhost:9191/accountLock";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(getCustomerUri);
        UriComponents uriComponents = builder.build().encode();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", code);
        headers.set("Content-Type", type);
        headers.set("UserName", userName);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ParameterizedTypeReference<UserDTO> typeRef = new ParameterizedTypeReference<UserDTO>() {
        };

        return restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, entity, typeRef).getBody();
    }
}
