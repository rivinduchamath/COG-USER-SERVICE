package com.cloudofgoods.userservice.controller;

import com.cloudofgoods.userservice.dto.UserDTO;
import com.cloudofgoods.userservice.dto.UserRegisterDTO;
import com.cloudofgoods.userservice.service.UsersServiceBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/services")
public class UsersController {

    private final UsersServiceBO customerService;

    //Save UserDTO With Credentials If Want Future
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public UserRegisterDTO save(@RequestBody UserDTO users) {

        UserRegisterDTO userDTO = customerService.save(users);

        return new UserRegisterDTO(userDTO.getUsername(), userDTO.getEmail());
    }

    // Save User Without User Authentication (Implemented For Normal Customer Registration)
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String saveCustomer(@RequestBody UserDTO users) {
        UserRegisterDTO userRegisterDTO = null;

        try {
            userRegisterDTO = customerService.save(users);
            if (!userRegisterDTO.getEmail().equals("")) {
                return "User " + userRegisterDTO.getUsername() + " Save Success";
            } else {
                return "User Save Failed";
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return "User Save Failed";
        }
    }

    @RequestMapping(value = "/getprofile/{userName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize("hasAuthority('read_profile')")
    public UserDTO fetch(@PathVariable(name = "userName") String username, HttpServletRequest request) {

        String code = request.getHeader("Authorization");
        String contentType = request.getHeader("Content-Type");
        return customerService.getUser(username, code, contentType);
    }

    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('ROLE_admin')")
    public List<UserDTO> userDetails(HttpServletRequest request)  {
        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
        String code = request.getHeader("Authorization");
        String contentType = request.getHeader("Content-Type");
        return customerService.fetchAllProfiles(code, contentType);
    }

    @RequestMapping(value = "/accountLockUser", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public UserDTO accountLockUser(HttpServletRequest request) {
        System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
        String code = request.getHeader("Authorization");
        String contentType = request.getHeader("Content-Type");
        String userName = request.getHeader("UserName");
        return customerService.accountLockUser(userName, code, contentType);
    }

}

