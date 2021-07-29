package com.example.demospringweb;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;

@Slf4j
@RestController
@Configuration
@RequiredArgsConstructor
public class TestController {

    @Bean
    public Module javaTimeModule() {
        return new JavaTimeModule();
    }

    @PostMapping("/")
    DTO proxy(DTO dto) {
        log.info("{}", dto);
        return dto;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class DTO {
        LocalDate birthDate;
        Instant date;
    }

}
