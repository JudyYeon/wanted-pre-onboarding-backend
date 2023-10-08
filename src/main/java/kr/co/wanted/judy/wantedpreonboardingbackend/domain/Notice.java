package kr.co.wanted.judy.wantedpreonboardingbackend.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Schema(description = "Notice")
public class Notice {

    public void update(Notice request){
        this.area = request.getArea();
        this.country = request.getCountry();
        this.reward = request.getReward();
        this.companyId = request.getCompanyId();

    }

    @Column(updatable = false)
    @Schema(description = "회사 ID", required = true)
    private long companyId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "공고 ID", hidden = true)
    private long noticeId;

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
