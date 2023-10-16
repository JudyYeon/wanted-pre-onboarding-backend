package kr.co.wanted.judy.wantedpreonboardingbackend.model;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.type.EnumResponseResult;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiResponseList<T> {

    public ApiResponseList(EnumResponseResult result, String code, String message, List<T> data) {
        try{
            this.result = result;
            this.code = code;
            this.message = message;

            if(data == null)
                this.data = new ArrayList<>();
            else
                this.data = data;

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ApiResponseList(EnumResponseResult result, String code, String message) {
        try{
            this.result = result;
            this.code = code;
            this.message = message;
            this.data = null;

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Schema(description = "응답 결과", required = true)
    EnumResponseResult result = EnumResponseResult.ERROR;

    @Schema(description = "응답 코드", required = true)
    String code;

    @Schema(description = "응답 메새지", required = true)
    String message;

    @Schema(description = "데이터", required = true)
    List<T> data;
}
