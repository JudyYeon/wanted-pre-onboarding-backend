package kr.co.wanted.judy.wantedpreonboardingbackend.repository;

import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Apply;
import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecruitRepository extends CrudRepository<Apply, Long> {

    void save(Notice notice);
    List<Notice> findAll(Long aLong);
}
