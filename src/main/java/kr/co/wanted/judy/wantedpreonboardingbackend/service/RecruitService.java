package kr.co.wanted.judy.wantedpreonboardingbackend.service;

import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Apply;
import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecruitService {

    // 요구사항 1. 등록 유형의 서비스
    void addNotice(Notice notice);

    // 요구사항 2. 수정 유형의 서비스
    void modifyNotice(final long id, final Notice params);

    // 요구사항 3. 삭제 유형의 서비스
    void removeNotice(long id);
    
    //요구사항 4-1. 목록조회 유형의 서비스
    List<Notice> findNotice();
    
    //요구사항 4-2. 검색조회 유형의 서비스
    Page<Notice> searchNotice(String keyword, Pageable pageable);

    // 요구사항 5. 상세조회 유형의 서비스
    Notice findNoticeDetail(long id);

    // 요구사항 6. 지원자 등록 유형의 서비스
    void apply(Apply apply);

}
