package kr.co.wanted.judy.wantedpreonboardingbackend.repository;

import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import org.springframework.data.repository.CrudRepository;

public interface RecruitRepository extends CrudRepository<Notice, Integer> {
}
