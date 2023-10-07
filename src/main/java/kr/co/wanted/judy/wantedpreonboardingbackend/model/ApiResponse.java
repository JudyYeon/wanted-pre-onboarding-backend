package kr.co.wanted.judy.wantedpreonboardingbackend.model;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "응답 결과", dataType = "kr.co.wanted.judy.wantedpreonboardingbackend.model.data.EnumResponseResult", required = true)
    EnumResponseResult result;

    @ApiModelProperty(value = "응답 코드", dataType = "java.lang.String", required = true)
    String code;

    @ApiModelProperty(value = "응답 메시지", dataType = "java.lang.String", required = true)
    String message;
}
