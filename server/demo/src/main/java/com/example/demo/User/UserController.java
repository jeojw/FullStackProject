package com.example.demo.User;

import com.example.demo.Jwt.JwtToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final BCryptPasswordEncoder encoder;

    @PostMapping("/api/getUserInfo")
    public ResponseEntity<UserDto> getUserInfo(@RequestBody SigninRequestDto signinRequestDto){
        return ResponseEntity.ok(userService.getUserInfo(signinRequestDto));
    }

    @PostMapping("/api/signIn")
    public ResponseEntity<JwtToken> signIn(@RequestBody @Validated SigninRequestDto signinRequestDto){
        return ResponseEntity.ok(userService.signIn(signinRequestDto));
    }

    @PostMapping("/api/signUp")
    public ResponseEntity<?> signUp(@RequestBody @Validated UserDto userDto){
        String encodedPassword = encoder.encode(userDto.getUserPassword());
        userDto.setUserPassword(encodedPassword);
        userService.signUp(userDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody @Validated ChangePasswordDto changePasswordDto){
        String encodedPassword = encoder.encode(changePasswordDto.getNewPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/setOption")
    public ResponseEntity<Boolean> setOptions(@RequestBody @Validated SetOptionRequestDto requestDto,
                                              @RequestParam("userEmail") String userEmail){
        return ResponseEntity.ok(userService.SetOptions(userEmail, requestDto));
    }
}
