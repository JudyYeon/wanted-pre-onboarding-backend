package kr.co.wanted.judy.wantedpreonboardingbackend.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "company")
@Schema(description = "Company")
public class Company {

    @Id
    @Column(updatable = false)
    @Schema(description = "회사 ID")
    private long companyId;

    @Column
    @Schema(description = "회사명")
    private String companyName;

    @Column
    @Schema(description = "회사 이메일")
    private String companyEmail;
}
