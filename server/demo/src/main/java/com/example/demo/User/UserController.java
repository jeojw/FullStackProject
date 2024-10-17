package com.example.demo.User;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final BCryptPasswordEncoder encoder;

    @GetMapping("/api/getUserInfo")
    public ResponseEntity<UserDto> getUserInfo(@RequestBody SigninRequestDto signinRequestDto){
        return ResponseEntity.ok(userService.getUserInfo(signinRequestDto));
    }

    @PostMapping("/api/signIn")
    public ResponseEntity<Boolean> signIn(@RequestBody @Validated SigninRequestDto signinRequestDto){
        String encodedPassword = encoder.encode(signinRequestDto.getUserPassword());
        signinRequestDto.setUserPassword(encodedPassword);

        return ResponseEntity.ok(userService.signIn(signinRequestDto));
    }

    @PostMapping("/api/signUp")
    public ResponseEntity<?> signUp(@RequestBody @Validated UserDto userDto){
        String encodedPassword = encoder.encode(userDto.getUserPassword());
        userDto.setUserPassword(encodedPassword);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
