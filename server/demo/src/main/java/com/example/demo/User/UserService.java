package com.example.demo.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserDto getUserInfo(SigninRequestDto signinRequestDto) {
        String encodePassword = encoder.encode(signinRequestDto.getUserPassword());
        Optional<UserEntity> userInfo = userRepository.checkUser(signinRequestDto.getUserEmail(), encodePassword);
        return userInfo.map(userEntity -> UserDto.builder()
                .UserEmail(userEntity.getUserEmail())
                .UserPassword(userEntity.getUserPassword())
                .Carbohydrate(userEntity.getCarbohydrate())
                .Protein(userEntity.getProtein())
                .Province(userEntity.getProvince())
                .build()).orElse(null);
    }

    public void setNutrient(String userEmail, NutrientDto nutrientDto){
        userRepository.setNutrient(nutrientDto.getCarbohydrate(), nutrientDto.getProtein(),
                nutrientDto.getProvince(), userEmail);
    }

    public void signIn(SigninRequestDto signinRequestDto){

    }
}
