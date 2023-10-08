package kr.co.wanted.judy.wantedpreonboardingbackend.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "공고 ID")
    private long noticeId;
    
    @Schema(description = "지원일시")
    private String applyDtTm;

    @Column
    @Schema(description = "회사 ID")
    private long companyId;

    @Column
    @Schema(description = "접수번호")
    private long applyId;

    @Column
    @Schema(description = "지원자 ID")
    private String ApplicantId;
}
