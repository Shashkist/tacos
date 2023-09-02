package com.ilia.tacos.web;

import com.ilia.tacos.data.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
//    private final UserDetailsService userDetailsService;

    @GetMapping()
    public ResponseEntity<?>  currentOrder() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);

    }

//    @GetMapping("/puk")
//    public ResponseEntity<?>  getUser() {
//        return new ResponseEntity<>(userDetailsService.loadUserByUsername("puk"), HttpStatus.OK);
//
//    }


}
