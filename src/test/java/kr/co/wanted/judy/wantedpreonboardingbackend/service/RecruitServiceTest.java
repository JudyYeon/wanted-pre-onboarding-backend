package kr.co.wanted.judy.wantedpreonboardingbackend.service;

import kr.co.wanted.judy.wantedpreonboardingbackend.repository.ApplyRepository;
import kr.co.wanted.judy.wantedpreonboardingbackend.repository.NoticeRepository;
import org.junit.jupiter.api.Test;

class RecruitServiceTest {

    private final NoticeRepository noticeRepository;
    private final ApplyRepository applyRepository;
    private final RecruitService recruitService;

    RecruitServiceTest(NoticeRepository noticeRepository, ApplyRepository applyRepository, RecruitService recruitService) {
        this.noticeRepository = noticeRepository;
        this.applyRepository = applyRepository;
        this.recruitService = recruitService;
    }

    @Test
    void addNotice() {
    }

    @Test
    void modifyNotice() {
    }

    @Test
    void removeNotice() {
    }

    @Test
    void findNotice() {
    }

    @Test
    void searchNotice() {
    }

    @Test
    void findNoticeDetail() {
    }

    @Test
    void applyNotion() {
    }
}