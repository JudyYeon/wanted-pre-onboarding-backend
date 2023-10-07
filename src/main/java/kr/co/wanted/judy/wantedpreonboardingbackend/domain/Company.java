package kr.co.wanted.judy.wantedpreonboardingbackend.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Company {
    @Schema(description = "회사 ID")
    private int companyId;

    @Schema(description = "회사명")
    private int companyName;

    @Schema(description = "회사 이메일")
    private int companyEmail;
}
