package com.example.demospring.controller;


import com.example.demospring.dto.UserRequestResponse;
import com.example.demospring.dto.UserPageResponse;
import com.example.demospring.entity.User;
import com.example.demospring.service.UserService;
import com.example.demospring.serviceImpl.UserServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }




    @GetMapping
    public UserPageResponse getAll(@RequestParam(value = "page") int page, @RequestParam(value = "count") int count) {
        logger.info("getAll request accepted");
        return userService.getAll(page,count);
    }

    @GetMapping("/{id}")
    public UserRequestResponse getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveUser(@RequestBody UserRequestResponse user) {
        System.out.println("salam");
        User user1 = userService.saveUser(user);
        System.out.println(user1);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
