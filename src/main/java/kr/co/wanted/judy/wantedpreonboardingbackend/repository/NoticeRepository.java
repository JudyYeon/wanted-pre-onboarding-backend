package kr.co.wanted.judy.wantedpreonboardingbackend.repository;

import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Page<Notice> findByPositionContaining(String keyword, Pageable pageable);
    Page<Notice> findByCompanyId(long id, Pageable pageable);
}
