package com.sparta.hanghaememo.dto;

import lombok.Getter;

@Getter
public class MemoRequestDto { //클라이언트에서 넘어오는 데이터를 객체를 통해 받음
    private String name;
    private String contents;
    private String title;
    private String password;
}

