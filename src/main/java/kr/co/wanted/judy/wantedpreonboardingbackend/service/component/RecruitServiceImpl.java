package kr.co.wanted.judy.wantedpreonboardingbackend.service.component;

import kr.co.wanted.judy.wantedpreonboardingbackend.Exception.RecruitException;
import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Apply;
import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import kr.co.wanted.judy.wantedpreonboardingbackend.repository.ApplyRepository;
import kr.co.wanted.judy.wantedpreonboardingbackend.repository.NoticeRepository;
import kr.co.wanted.judy.wantedpreonboardingbackend.service.RecruitService;
import lombok.extern.slf4j.Slf4j;
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

    public RecruitServiceImpl(NoticeRepository noticeRepository, ApplyRepository applyRepository) {
        this.noticeRepository = noticeRepository;
        this.applyRepository = applyRepository;
    }


    @Override
    public void addNotice(Notice notice) {
        try {
            // 채용정보 등록
            noticeRepository.save(notice);
        }catch (Exception e){
            throw new RecruitException("등록 중 오류가 발생했습니다.");
        }
    }

    @Override
    @Transactional
    public void modifyNotice(long id, final Notice u) {

        Optional<Notice> oNotice = noticeRepository.findById(id);
        if(!oNotice.isPresent()) return;

        Notice notice = oNotice.get();
        notice.setPosition(u.getPosition());
        notice.setArea(u.getArea());
        notice.setCountry(u.getCountry());
        notice.setSkill(u.getSkill());
        notice.setDescription(u.getDescription());
        notice.setReward(u.getReward());
        noticeRepository.save(notice);

//        entity.ifPresent(t -> {
//            if(updateParams.getArea() != null){
//                t.setArea(updateParams.getArea());
//            }
//            if(updateParams.getCountry() != null){
//                t.setCountry(updateParams.getCountry());
//            }
//            if(updateParams.getPosition() != null){
//                t.setPosition(updateParams.getPosition());
//            }
//            noticeRepository.save(t);
//        });
    }

    @Override
    public void removeNotice(long id) {
        try{
            Optional<Notice> entity = noticeRepository.findById(id);
            entity.ifPresent(noticeRepository::delete);

        }catch (Exception e){
            throw new RecruitException("삭제 중 오류가 발생했습니다.");
        }
    }

    @Override
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

    @Override
    public List<Notice> searchNotice() {
        return null;
    }

    @Override
    public Notice findNoticeDetail(long id) {
        try {
            return noticeRepository.findById(id).orElse(null);

        }catch (Exception e){
            throw new RecruitException("등록 중 오류가 발생했습니다.");
        }
    }

    @Override
    public void apply(Apply apply) {
        try {
            // 지원정보 등록
            applyRepository.save(apply);
        }catch (Exception e){
            throw new RecruitException("등록 중 오류가 발생했습니다.");
        }
    }
}
