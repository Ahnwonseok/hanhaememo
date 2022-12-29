package com.sparta.hanghaememo.service;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.dto.MemoRequestDto2;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Memo createMemo(MemoRequestDto requestDto){ //Entity인 Memo객체를 반환
        Memo memo = new Memo(requestDto); // Memo Entity 생성자에 클라이언트에서 넘겨준 데이터를 넣어줌
        memoRepository.save(memo); //엔티티(테이블)을 리포지터리를 통해 저장
        return memo;
    }

    @Transactional(readOnly = true) //읽기 전용
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Long update(Long id, MemoRequestDto2 requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(  //업데이트할 메모가 있는지 확인
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        memo.update(requestDto);
        return memo.getId();
    }
    @Transactional
    public Long deleteMemo(Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}
