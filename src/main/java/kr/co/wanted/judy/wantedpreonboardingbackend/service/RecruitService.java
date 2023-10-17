package kr.co.wanted.judy.wantedpreonboardingbackend.service;

import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Apply;
import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import kr.co.wanted.judy.wantedpreonboardingbackend.exception.RecruitException;
import kr.co.wanted.judy.wantedpreonboardingbackend.repository.ApplyRepository;
import kr.co.wanted.judy.wantedpreonboardingbackend.repository.NoticeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@Transactional
public class RecruitService {

    private final NoticeRepository noticeRepository;
    private final ApplyRepository applyRepository;

    /*
     * 생성자
     * @param noticeRepository 채용공고 엔티티
     * @param applyRepository 지원내역 엔티티
     * */
    public RecruitService(NoticeRepository noticeRepository, ApplyRepository applyRepository) {
        this.noticeRepository = noticeRepository;
        this.applyRepository = applyRepository;
    }

    // 요구사항 1. 등록 유형의 서비스
    @Transactional
    public Notice addNotice(Notice notice) {
        try {
            // 채용정보 등록
            return noticeRepository.save(notice);
        }catch (Exception e){
            throw new RecruitException("등록 중 오류가 발생했습니다.");
        }
    }

    // 요구사항 2. 수정 유형의 서비스
    @Transactional
    public void modifyNotice(long id, final Notice u) {

        // Entity 조회
        Optional<Notice> oNotice = noticeRepository.findById(id);
        if(!oNotice.isPresent()) return;

        // Entity 변경
        Notice notice = oNotice.get();
        notice.setPosition(u.getPosition());
        notice.setArea(u.getArea());
        notice.setCountry(u.getCountry());
        notice.setSkill(u.getSkill());
        notice.setDescription(u.getDescription());
        notice.setReward(u.getReward());

        // Entity 저장
        noticeRepository.save(notice);
    }

    // 요구사항 3. 삭제 유형의 서비스
    @Transactional
    public void removeNotice(long id) {
        try{
            Optional<Notice> entity = noticeRepository.findById(id);
            entity.ifPresent(noticeRepository::delete);

        }catch (Exception e){
            throw new RecruitException("삭제 중 오류가 발생했습니다.");
        }
    }
    
    //요구사항 4-1. 목록조회 유형의 서비스
    @Transactional
    public List<Notice> findNotice() {
        try {
            // 새로운 List<Notice> 생성 및 Iterator 사용
            Iterable<Notice> data = noticeRepository.findAll();
            List<Notice> rs = new ArrayList<>();
            Iterator<Notice> iterator = data.iterator();
            iterator.forEachRemaining(rs::add);

            return rs;

        }catch (Exception e){
            throw new RecruitException("조회 중 오류가 발생했습니다.");
        }
    }
    
    //요구사항 4-2. 검색조회 유형의 서비스
    @Transactional
    public Page<Notice> searchNotice(String keyword, Pageable pageable) {
        try {
            return noticeRepository.findByPositionContaining(keyword, pageable);

        }catch (Exception e){
            throw new RecruitException("등록 중 오류가 발생했습니다.");
        }
    }

    // 요구사항 5. 상세조회 유형의 서비스
    @Transactional
    public Page<Notice> findNoticeDetail(long id, Pageable pageable) {
        try {
            return noticeRepository.findByCompanyId(id, pageable);

        }catch (Exception e){

            throw new RecruitException("조회 중 오류가 발생했습니다.");
        }
    }

    // 요구사항 6. 지원자 등록 유형의 서비스
    @Transactional
    public Apply addApply(Apply apply) {
        try {
            // 지원정보 등록
            return applyRepository.save(apply);
        }catch (Exception e){
            throw new RecruitException("등록 중 오류가 발생했습니다.");
        }
    }

}
