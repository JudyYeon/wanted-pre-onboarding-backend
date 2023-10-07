package kr.co.wanted.judy.wantedpreonboardingbackend.domain;

import io.swagger.v3.oas.annotations.media.Schema;

public class RecruitApply {

    @Schema(description = "공고 ID")
    private int noticeId;

    @Schema(description = "회사 ID")
    private int companyId;

    @Schema(description = "접수번호")
    private int applyId;

    @Schema(description = "지원자 ID")
    private String ApplicantId;
}
