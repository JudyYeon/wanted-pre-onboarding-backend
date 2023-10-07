package kr.co.wanted.judy.wantedpreonboardingbackend.service.impl;

import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import kr.co.wanted.judy.wantedpreonboardingbackend.service.RecruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class RecruitServiceImpl implements RecruitService {
    @Override
    public void addNotice(Notice recruitNoticeDTO) {

    }

    @Override
    public void modifyNotice() {

    }

    @Override
    public void removeNotice() {

    }

    @Override
    public List<Notice> findNotice() {
        return null;
    }

    @Override
    public List<Notice> searchNotice() {
        return null;
    }

    @Override
    public Notice findNoticeDetail(int id) {
        return null;
    }
}
