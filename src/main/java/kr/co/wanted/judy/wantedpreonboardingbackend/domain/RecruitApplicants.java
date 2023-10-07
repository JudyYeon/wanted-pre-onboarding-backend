package kr.co.wanted.judy.wantedpreonboardingbackend.domain;

import io.swagger.v3.oas.annotations.media.Schema;

public class RecruitApplicants {

    @Schema(description = "지원자 ID")
    private String applicantId;

    @Schema(description = "이름")
    private String name;

    @Schema(description = "나이")
    private int age;

    @Schema(description = "보유기술")
    private String skill;

}
