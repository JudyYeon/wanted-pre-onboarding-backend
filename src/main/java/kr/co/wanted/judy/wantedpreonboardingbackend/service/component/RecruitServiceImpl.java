package kr.co.wanted.judy.wantedpreonboardingbackend.service.component;

import kr.co.wanted.judy.wantedpreonboardingbackend.exception.RecruitException;
import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Apply;
import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import kr.co.wanted.judy.wantedpreonboardingbackend.repository.ApplyRepository;
import kr.co.wanted.judy.wantedpreonboardingbackend.repository.NoticeRepository;
import kr.co.wanted.judy.wantedpreonboardingbackend.service.RecruitService;
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
public class RecruitServiceImpl implements RecruitService {

    private final NoticeRepository noticeRepository;
    private final ApplyRepository applyRepository;

    /*
    * 생성자
    * @param noticeRepository 채용공고 엔티티
    * @param applyRepository 지원내역 엔티티
    * */
    public RecruitServiceImpl(NoticeRepository noticeRepository, ApplyRepository applyRepository) {
        this.noticeRepository = noticeRepository;
        this.applyRepository = applyRepository;
    }


    /*
    * 채용 공고를 등록하는 서비스
    * @param notice 채용공고정보 객체
    * */
    @Override
    @Transactional
    public void addNotice(Notice notice) {
        try {
            // 채용정보 등록
            noticeRepository.save(notice);
        }catch (Exception e){
            throw new RecruitException("등록 중 오류가 발생했습니다.");
        }
    }

    /*
    * 채용 공고를 수정하는 서비스
    * @param id 공고 ID
    * @param u 업데이트 할 공고정보 객체
    * */
    @Override
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

    /*
     * 채용 공고를 삭제하는 서비스
     * @param id 삭제 할 공고 ID
     * */
    @Override
    @Transactional
    public void removeNotice(long id) {
        try{
            Optional<Notice> entity = noticeRepository.findById(id);
            entity.ifPresent(noticeRepository::delete);

        }catch (Exception e){
            throw new RecruitException("삭제 중 오류가 발생했습니다.");
        }
    }

    /*
     * 채용 공고 목록을 조회하는 서비스
     * */
    @Override
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

    /*
     * position 으로 채용 공고를 검색하는 서비스
     * @param position 검색할 분야(frontend, backend)
     * */
    @Override
    @Transactional
    public Page<Notice> searchNotice(String keyword, Pageable pageable) {
        try {
            return noticeRepository.findByPositionContaining(keyword, pageable);

        }catch (Exception e){
            throw new RecruitException("등록 중 오류가 발생했습니다.");
        }
    }

    /*
     * 공고 상세조회
     * @param id 조회 할 공고 ID
     * */
    @Override
    @Transactional
    public Notice findNoticeDetail(long id) {
        try {
            return noticeRepository.findById(id).orElse(null);

        }catch (Exception e){
            throw new RecruitException("등록 중 오류가 발생했습니다.");
        }
    }

    /*
     * 채용 지원하기
     * @param apply 지원 정보
     * */
    @Override
    @Transactional
    public void applyNotion(Apply apply) {
        try {
            // 지원정보 등록
            applyRepository.save(apply);
        }catch (Exception e){
            throw new RecruitException("등록 중 오류가 발생했습니다.");
        }
    }
}
