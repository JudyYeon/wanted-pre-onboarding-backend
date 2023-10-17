package kr.co.wanted.judy.wantedpreonboardingbackend.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Schema(description = "Applicants")
@Table(name = "applicants")
public class Applicants {

    @Id
    @Schema(description = "지원자 ID")
    private long applicantId;

    @Column
    @Schema(description = "지원자 명")
    private String name;

    @Column
    @Schema(description = "지원자 나이")
    private int age;

    @Column
    @Schema(description = "지원자 보유기술")
    private String skill;

}
