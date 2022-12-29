package com.sparta.hanghaememo.repository;


import com.sparta.hanghaememo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> { //DB와 연결
    List<Memo> findAllByOrderByModifiedAtDesc(); //수정한 날짜 내리차순으로 정렬 후 찾는다.
}
