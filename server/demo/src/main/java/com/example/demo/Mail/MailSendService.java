package com.example.demo.Mail;

import com.example.demo.Redis.RedisUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@Service
public class MailSendService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private RedisUtil redisUtil;
    private int authNumber;

    public boolean checkAuthNum(String email, String authNum){
        if (redisUtil.getData(authNum) == null){
            return false;
        }
        else return redisUtil.getData(authNum).equals(email);
    }

    public void makeRandomNumber(){
        Random r = new Random();
        StringBuilder randomNumber = new StringBuilder();
        for (int i = 0; i < 6; i++){
            randomNumber.append(Integer.toString(r.nextInt(10)));
        }

        authNumber = Integer.parseInt(randomNumber.toString());
    }

    public String joinEmail(String email, String type){
        makeRandomNumber();
        String setFrom = "jeongjw0804@gmail.com";
        String toMail = email;
        String title = "";
        if (Objects.equals(type, "signIn")){
            title = "회원 가입 인증 이메일 입니다.";
        }
        else{
            title = "비밀번호 찾기 인증 이메일 입니다.";
        }
        String content = String.format("인증 번호는 %d 입니다." +
                "<br>" +
                "인증번호를 제대로 입력해주세요", authNumber
                );
        mailSend(setFrom, toMail, title, content);
        return Integer.toString(authNumber);
    }

    public void mailSend(String setFrom, String toMail, String title, String content){
        MimeMessage message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content, true);
            mailSender.send(message);
        } catch (MessagingException e){
            e.printStackTrace();
        }
        redisUtil.setDataExpire(Integer.toString(authNumber),toMail,60*5L);
    }
}
