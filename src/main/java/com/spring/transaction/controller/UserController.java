package com.spring.transaction.controller;


import com.spring.transaction.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferAmountBetweenTwoUsers(@RequestParam("fromId") Integer fromId, @RequestParam("toId") Integer toId,
                                                                @RequestParam("amount") Double amount) throws Exception {
        String message = this.userService.transferMoneyBetweenAccount(fromId,toId,amount);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
