package com.example.demo.Mail;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class MailController {
    private final MailSendService mailService;

    @PostMapping("/api/mailSend")
    public ResponseEntity<CompletableFuture<String>> mailSend(@RequestBody @Valid EmailRequestDto emailDto){
        return ResponseEntity.ok(mailService.joinEmail(emailDto.getEmail(), emailDto.getType()));
    }

    @PostMapping("/api/mailAuthCheck")
    public ResponseEntity<CompletableFuture<Boolean>> authCheck(@RequestBody @Valid EmailCheckDto emailCheckDto){
        CompletableFuture<Boolean> Checked = mailService.checkAuthNum(emailCheckDto.getEmail(), emailCheckDto.getAuthNum());
        return ResponseEntity.ok(Checked);
    }
}
