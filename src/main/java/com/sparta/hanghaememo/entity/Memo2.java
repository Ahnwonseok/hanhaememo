package com.sparta.hanghaememo.entity;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.dto.MemoRequestDto2;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Memo2 extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String contents;



    public Memo2(MemoRequestDto2 requestDto) { //생성자
        this.contents = requestDto.
    }

    public void update(MemoRequestDto requestDto) { //수정은 직접 테이블에서
        this.username = requestDto.getName();
        this.contents = requestDto.getContents();
    }
}