package kr.co.wanted.judy.wantedpreonboardingbackend.repository;

import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class NoticeRepositoryTest {

    @Autowired
    TestEntityManager em;

    @Autowired
    private NoticeRepository repository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByPositionContaining() {

        //Given
        Notice notice1 = new Notice();
        notice1.setPosition("frontend");
        notice1.setArea("서울");
        notice1.setSkill("react");
        notice1.setReward(300000);
        notice1.setCountry("us");
        notice1.setCompanyId(2);
        notice1.setDescription("(테스트케이스)실리콘밸리에서 리액트 개발자를 채용합니다...");

        em.persist(notice1);

        //When
        Page<Notice> result = repository.findByPositionContaining("frontend", PageRequest.of(0, 10));

        //Then
        assertEquals(1, result.getTotalElements()); // 예상한 총 엔티티의 수 (예: 3)
        assertEquals(1, result.getContent().size()); // 페이지 크기와 일치하는지 확인 (예: 3)
    }

    @Test
    void findByCompanyId() {
    }

//    @Test
//    void clearStore() {
//        //Test시 저장소의 정보들을 정리해주기 위한 메소드
//        em.clear();
//    }
}