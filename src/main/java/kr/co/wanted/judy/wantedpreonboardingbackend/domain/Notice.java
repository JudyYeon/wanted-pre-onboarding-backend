package kr.co.wanted.judy.wantedpreonboardingbackend.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Schema(description = "Notice")
public class Notice {
    @Schema(description = "회사 ID", required = true)
    private int companyId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "공고 ID", hidden = true)
    private int noticeId;

    @Schema(description = "채용 포지션")
    private String position;

    @Schema(description = "채용 보상금")
    private int reward;

    @Schema(description = "채용 내용")
    private String description;

    @Schema(description = "사용 기술")
    private String skill;

    @Schema(description = "국가")
    private String country;

    @Schema(description = "지역")
    private String area;
}
