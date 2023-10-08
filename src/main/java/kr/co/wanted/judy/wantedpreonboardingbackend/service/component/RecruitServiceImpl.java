package kr.co.wanted.judy.wantedpreonboardingbackend.service.component;

import kr.co.wanted.judy.wantedpreonboardingbackend.Exception.NoticeException;
import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import kr.co.wanted.judy.wantedpreonboardingbackend.repository.RecruitRepository;
import kr.co.wanted.judy.wantedpreonboardingbackend.service.RecruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class RecruitServiceImpl implements RecruitService {

    private final RecruitRepository recruitRepository;

    public RecruitServiceImpl(RecruitRepository recruitRepository) {
        this.recruitRepository = recruitRepository;
    }

    @Override
    public void addNotice(Notice notice) {
        try {
            // 채용정보 등록
            recruitRepository.save(notice);
        }catch (Exception e){
            throw new NoticeException("등록 중 오류가 발생하였습니다.");
        }
    }

    @Override
    public void modifyNotice() {

    }

    @Override
    public void removeNotice() {

    }

    @Override
    public List<Notice> findNotice() {
        try {
            // 새로운 List<Notice> 생성 및 Iterator 사용
            Iterable<Notice> data = recruitRepository.findAll();
            List<Notice> rs = new ArrayList<>();
            Iterator<Notice> iterator = data.iterator();
            iterator.forEachRemaining(rs::add);

            return rs;

        }catch (Exception e){
            throw new NoticeException("조회 중 오류가 발생하였습니다.");
        }
    }

    @Override
    public List<Notice> searchNotice() {
        return null;
    }

    @Override
    public Notice findNoticeDetail(int id) {
        try {
            return recruitRepository.findById(id).orElse(null);

        }catch (Exception e){
            throw new NoticeException("등록 중 오류가 발생하였습니다.");
        }
    }
}
