package kr.co.wanted.judy.wantedpreonboardingbackend.model;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.data.EnumResponseResult;
import lombok.Data;

@Data
public class ApiResponseData<T> {

    public ApiResponseData(){
        this(EnumResponseResult.ERROR, "", "", null);
    }

    public ApiResponseData(T data){
        this(EnumResponseResult.SUCCESS, "", "", data);
    }

    public ApiResponseData(EnumResponseResult result, String code, String message, T data) {
        try{
            this.result = result;
            this.code = code;
            this.message = message;
            this.data = data;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ApiResponseData(EnumResponseResult result, String code, String message) {
        try{
            this.result = result;
            this.code = code;
            this.message = message;
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
    T data;
}
