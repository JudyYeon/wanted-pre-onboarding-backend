package kr.co.wanted.judy.wantedpreonboardingbackend.service;

import kr.co.wanted.judy.wantedpreonboardingbackend.domain.RecruitNotice;

import java.util.List;

public interface RecruitService {

    // 요구사항 1. 등록 유형의 서비스
    void addNotice(RecruitNotice recruitNoticeDTO);

    // 요구사항 2. 수정 유형의 서비스
    void modifyNotice();

    // 요구사항 3. 삭제 유형의 서비스
    void removeNotice();
    
    //요구사항 4-1. 목록조회 유형의 서비스
    List<RecruitNotice> findNotice();
    
    //요구사항 4-2. 검색조회 유형의 서비스
    List<RecruitNotice> searchNotice();

    // 요구사항 5. 상세조회 유형의 서비스
    RecruitNotice findNoticeDetail(int id);

    // 요구사항 6. 지원자 등록 유형의 서비스

}
