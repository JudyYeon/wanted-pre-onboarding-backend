package kr.co.wanted.judy.wantedpreonboardingbackend.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "notice")
@Schema(description = "Notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "공고 ID", hidden = true)
    private long noticeId;

    @Column(updatable = false)
    @Schema(description = "회사 ID", required = true)
    private long companyId;

    @Column
    @Schema(description = "채용 포지션")
    private String position;

    @Column
    @Schema(description = "채용 보상금")
    private int reward;

    @Column
    @Schema(description = "채용 내용")
    private String description;

    @Column
    @Schema(description = "사용 기술")
    private String skill;

    @Column
    @Schema(description = "국가")
    private String country;

    @Column
    @Schema(description = "지역")
    private String area;
}
