package kr.co.wanted.judy.wantedpreonboardingbackend.controller;


import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import kr.co.wanted.judy.wantedpreonboardingbackend.Exception.NoticeException;
import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.ApiResponse;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.ApiResponseData;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.ApiResponseList;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.data.EnumResponseResult;
import kr.co.wanted.judy.wantedpreonboardingbackend.service.RecruitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Api(tags = {"Recruit"})
@RequestMapping(value = "/api/v1/wanted-recruit/")
@RequiredArgsConstructor
public class RecruitController {

    private final RecruitService recruitService;

    @Operation(summary = "채용정보 등록")
    @RequestMapping(value = "/notice", method = RequestMethod.POST)
    public ApiResponse noticeRegister(
            @Parameter(name = "채용 정보", required = true) @RequestBody Notice notice){

        try{
            recruitService.addNotice(notice);   // 공고등록 Api call
            return new ApiResponse(EnumResponseResult.SUCCESS, "SC001", "등록성공");

        }catch (NoticeException e){
            // 저장 중 오류 발생
            return new ApiResponse(EnumResponseResult.ERROR, "ER001", e.getMessage());
        }
    }

    @Operation(summary = "채용정보 목록")
    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public ApiResponseList<Notice> noticeList(){

        List<Notice> rs;
        try{
            rs = recruitService.findNotice();   // 목록조회 Api call
            return new ApiResponseList<>(EnumResponseResult.SUCCESS, "SC001", "조회성공", rs);

        }catch (NoticeException e){
            rs = null;
            return new ApiResponseList<>(EnumResponseResult.ERROR, "ER001", e.getMessage(), rs);
        }
    }

    @Operation(summary = "채용정보 상세")
    @RequestMapping(value = "/notice-detail", method = RequestMethod.GET)
    public ApiResponseData<Notice> noticeDetail(int id){

        Notice rs;
        try{
            rs = recruitService.findNoticeDetail(id);   // 상세조회 Api call
            return new ApiResponseData<>(EnumResponseResult.SUCCESS, "SC001", "조회성공", rs);

        }catch (NoticeException e){
            rs = null;
            return new ApiResponseData<>(EnumResponseResult.ERROR, "ER001", e.getMessage(), rs);
        }
    }


}
