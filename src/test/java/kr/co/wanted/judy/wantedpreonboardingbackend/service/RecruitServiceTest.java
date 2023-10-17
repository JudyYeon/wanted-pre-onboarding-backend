package kr.co.wanted.judy.wantedpreonboardingbackend.service;

import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Apply;
import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import kr.co.wanted.judy.wantedpreonboardingbackend.repository.ApplyRepository;
import kr.co.wanted.judy.wantedpreonboardingbackend.repository.NoticeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RecruitServiceTest {

    @InjectMocks
    private RecruitService recruitService;

    @Mock
    private NoticeRepository noticeRepository;

    @Mock
    private ApplyRepository applyRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addNotice() {

        //Given
        Notice notice = new Notice();
        notice.setPosition("frontend");
        notice.setArea("서울");
        notice.setSkill("vue");
        notice.setReward(300000);
        notice.setCountry("us");
        notice.setCompanyId(4);
        notice.setDescription("(테스트케이스)실리콘밸리에서 리액트 개발자를 채용합니다...");

        //Stub
        BDDMockito.given(noticeRepository.save(notice)).willReturn(new Notice());

        //When
        Notice result = recruitService.addNotice(notice);

        //Then
        assertEquals(notice.getNoticeId(), result.getNoticeId());
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
    void addApply() {
        //Given
        LocalDate now = LocalDate.now();
        Apply apply = new Apply();
        apply.setApplicantId("2018100123");
        apply.setCompanyId(1);
        apply.setNoticeId(4);
        apply.setApplyDtTm(now.toString());

        //Stub
        BDDMockito.given(applyRepository.save(apply)).willReturn(new Apply());

        //When
        Apply result = recruitService.addApply(apply);

        //Then
        assertEquals(apply.getApplyId(), result.getNoticeId());

    }
}