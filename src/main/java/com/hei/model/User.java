package com.hei.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private final Integer id;
    private int tokenCount;
    private LocalDate lastTokenRenewal;

    public User(Integer id) {
        this.id = id;
        this.tokenCount = 31;
        this.lastTokenRenewal = LocalDate.now();
    }

    public int getTokenCount() {
        renewTokensIfNewMonth();
        return tokenCount;
    }

    private void renewTokensIfNewMonth() {
        LocalDate today = LocalDate.now();
        if (lastTokenRenewal.getMonth() != today.getMonth() || lastTokenRenewal.getYear() != today.getYear()) {
            tokenCount = 31;
            lastTokenRenewal = today;
        }
    }
}
