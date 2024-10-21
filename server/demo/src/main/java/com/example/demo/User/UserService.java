package com.example.demo.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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
                .userEmail(userEntity.getUserEmail())
                .userPassword(userEntity.getUserPassword())
                .gender(userEntity.getGender())
                .birth(userEntity.getBirth())
                .height(userEntity.getHeight())
                .weight(userEntity.getWeight())
                .activeCoef(userEntity.getActiveCoef())
                .build()).orElse(null);
    }

    public Boolean signIn(SigninRequestDto signinRequestDto){
        Optional<UserEntity> userInfo = userRepository.checkUser(signinRequestDto.getUserEmail(), signinRequestDto.getUserPassword());
        return userInfo.isPresent();
    }

    public void signUp(UserDto userDto){
        userRepository.save(UserEntity.builder()
                        .userEmail(userDto.getUserEmail())
                        .userPassword(userDto.getUserPassword())
                        .gender(userDto.getGender())
                        .birth(userDto.getBirth())
                        .age(userDto.getAge())
                        .height(userDto.getHeight())
                        .weight(userDto.getWeight())
                        .activeCoef(userDto.getActiveCoef())
                        .BMR(userDto.getBMR())
                        .build());
    }

    public Boolean SetOptions(String userEmail, SetOptionRequestDto setOptionRequestDto){
        if (userRepository.checkUserByEmail(userEmail).isPresent()){
            int age = Period.between(setOptionRequestDto.getBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();;
            double BMR = 0;
            if (setOptionRequestDto.getGender() == 1){
                BMR = 66.5 + (13.75 * setOptionRequestDto.getWeight()) + (5.003 * setOptionRequestDto.getHeight()) - (6.75 * age);
            }
            else{
                BMR = 655.1 + (9.563 * setOptionRequestDto.getWeight()) + (1.850 * setOptionRequestDto.getHeight()) - (4.676  * age);
            }
            userRepository.setOptions(userEmail, setOptionRequestDto.getHeight(), setOptionRequestDto.getWeight(),
                    setOptionRequestDto.getGender() ,setOptionRequestDto.getBirth(), age, BMR, setOptionRequestDto.getActiveCoef());

            return true;
        }
        else {
            return false;
        }
    }
}
