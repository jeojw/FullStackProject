package com.example.demo.Mail;

import com.example.demo.Redis.RedisUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
public class MailSendService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private RedisUtil redisUtil;

    @Async("ioTaskExecutor")
    public CompletableFuture<Boolean> checkAuthNum(String email, String authNum) {
        String redisKey = "auth:" + email;
        String storedAuthNum = redisUtil.getData(redisKey);
        return CompletableFuture.completedFuture(authNum.equals(storedAuthNum));
    }

    public int makeRandomNumber() {
        return new Random().nextInt(900000) + 100000;
    }

    @Async("ioTaskExecutor")
    public CompletableFuture<String> joinEmail(String email, String type){
        makeRandomNumber();
        int authNumber = makeRandomNumber();

        String setFrom = "jeongjw0804@gmail.com";
        String title = type.equals("signIn")
                ? "회원 가입 인증 이메일 입니다."
                : "비밀번호 찾기 인증 이메일 입니다.";
        String content = String.format("인증 번호는 %d 입니다.<br>인증번호를 제대로 입력해주세요", authNumber);

        return mailSend(setFrom, email, title, content, authNumber)
                .thenApply(success -> {
                    if (success) {
                        return Integer.toString(authNumber);
                    } else {
                        throw new RuntimeException("Failed to send email.");
                    }
                });
    }

    @Async("ioTaskExecutor")
    public CompletableFuture<Boolean> mailSend(String setFrom, String toMail, String title, String content, int authNumber){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content, true);
            mailSender.send(message);

            // 이메일 전송 성공 시 Redis에 데이터 저장
            redisUtil.setDataExpire(Integer.toString(authNumber), toMail, 60 * 5L);
            return CompletableFuture.completedFuture(true);
        } catch (MessagingException e) {
            e.printStackTrace();
            return CompletableFuture.completedFuture(false);
        }
    }
}
