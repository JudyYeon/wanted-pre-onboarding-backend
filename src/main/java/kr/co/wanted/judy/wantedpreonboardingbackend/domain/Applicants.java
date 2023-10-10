package kr.co.wanted.judy.wantedpreonboardingbackend.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Schema(description = "Applicants")
public class Applicants {

    @Id
    @Schema(description = "지원자 ID")
    private long applicantId;

    @Schema(description = "지원자 명")
    private String name;

    @Schema(description = "지원자 나이")
    private int age;

    @Schema(description = "지원자 보유기술")
    private String skill;

}
