package com.example.demo.User;

import com.example.demo.Diet.DietDto;
import com.example.demo.Diet.DietEntity;
import com.example.demo.Diet.Rice.RiceDto;
import com.example.demo.Diet.SideDish.SideDishDto;
import com.example.demo.Diet.SideDish.SideDishEntity;
import com.example.demo.Diet.Soup.SoupDto;
import com.example.demo.Jwt.JwtToken;
import com.example.demo.Jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder encoder;

    public UserDto getUserInfo(SigninRequestDto signinRequestDto) {
        Optional<UserEntity> userInfo = userRepository.findByEmail(signinRequestDto.getUserEmail());
        if (userInfo.isPresent()){
            List<DietDto> dtoList = new ArrayList<>();
            List<DietEntity> entityList = userInfo.get().getDietList();
            for (DietEntity entity : entityList){
                List<SideDishDto> tmpList = new ArrayList<>();
                for (SideDishEntity sideDishEntity : entity.getSideDish()){
                    tmpList.add(SideDishDto.builder()
                            .name(sideDishEntity.getName())
                            .classification(sideDishEntity.getClassification())
                            .calorie(sideDishEntity.getCalorie())
                            .carbohydrate(sideDishEntity.getCarbohydrate())
                            .protein(sideDishEntity.getProtein())
                            .province(sideDishEntity.getProvince())
                            .build());
                }
                dtoList.add(DietDto.builder()
                        .Id(entity.getId())
                        .Rice(RiceDto.builder()
                                .name(entity.getRice().getName())
                                .calorie(entity.getRice().getCalorie())
                                .protein(entity.getRice().getProtein())
                                .province(entity.getRice().getProvince())
                                .build())
                        .Soup(SoupDto.builder()
                                .name(entity.getSoup().getName())
                                .calorie(entity.getRice().getCalorie())
                                .carbohydrate(entity.getRice().getCarbohydrate())
                                .protein(entity.getRice().getProtein())
                                .province(entity.getRice().getProvince())
                                .build())
                        .SideDishList(tmpList)
                        .Calorie(entity.getCalorie())
                        .Carbohydrate(entity.getCarbohydrate())
                        .Protein(entity.getProtein())
                        .Province(entity.getProvince())
                        .build());
            }
            return userInfo.map(userEntity -> UserDto.builder()
                    .userEmail(userEntity.getUserEmail())
                    .gender(userEntity.getGender())
                    .birth(userEntity.getBirth())
                    .age(userEntity.getAge())
                    .height(userEntity.getHeight())
                    .weight(userEntity.getWeight())
                    .BMR(userEntity.getBMR())
                    .activeCoef(userEntity.getActiveCoef())
                    .dietList(dtoList)
                    .build()).orElse(null);
        }
        else{
            return null;
        }
    }

    public JwtToken signIn(SigninRequestDto signinRequestDto){
        Optional<UserEntity> user = userRepository.findByEmail(signinRequestDto.getUserEmail());
        if (user.isPresent()){
            if (encoder.matches(signinRequestDto.getUserPassword(), user.get().getUserPassword())){
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(signinRequestDto.getUserEmail(),
                                signinRequestDto.getUserPassword());

                Authentication authentication =
                        authenticationManagerBuilder.getObject().authenticate(authenticationToken);

                return jwtTokenProvider.generateToken(authentication);
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
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

    public void changePassword(String userEmail, String newPassword){
        userRepository.changePassword(userEmail, newPassword);
    }

    public Boolean SetOptions(SetOptionRequestDto setOptionRequestDto){
        if (userRepository.findByEmail(setOptionRequestDto.getUserEmail()).isPresent()){
            int age = Period.between(setOptionRequestDto.getBirth(), LocalDate.now()).getYears();;
            double BMR = 0;
            if (setOptionRequestDto.getGender() == 1){
                BMR = 66.5 + (13.75 * setOptionRequestDto.getWeight()) + (5.003 * setOptionRequestDto.getHeight()) - (6.75 * age);
            }
            else{
                BMR = 655.1 + (9.563 * setOptionRequestDto.getWeight()) + (1.850 * setOptionRequestDto.getHeight()) - (4.676  * age);
            }
            userRepository.setOptions(setOptionRequestDto.getUserEmail(), setOptionRequestDto.getHeight(), setOptionRequestDto.getWeight(),
                    setOptionRequestDto.getGender() ,setOptionRequestDto.getBirth(), age, BMR, setOptionRequestDto.getActiveCoef());

            return true;
        }
        else {
            return false;
        }
    }
}
