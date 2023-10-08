package kr.co.wanted.judy.wantedpreonboardingbackend.model;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.data.EnumResponseResult;
import lombok.Data;

@Data
public class ApiResponse {

    // constructor
    public ApiResponse(EnumResponseResult result, String code, String message) {
        this.result = result;
        this.code = code;
        this.message = message;
    }

    @Schema(name = "응답 결과")
    EnumResponseResult result;

    @Schema(name = "응답 코드", required = true)
    String code;

    @Schema(name = "응답 메시지", required = true)
    String message;
}
