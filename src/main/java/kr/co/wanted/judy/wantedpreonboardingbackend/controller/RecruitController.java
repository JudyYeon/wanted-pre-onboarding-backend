package kr.co.wanted.judy.wantedpreonboardingbackend.controller;


import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import kr.co.wanted.judy.wantedpreonboardingbackend.exception.RecruitException;
import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.ApiResponse;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.ApiResponseData;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.ApiResponseList;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.data.EnumResponseResult;
import kr.co.wanted.judy.wantedpreonboardingbackend.service.RecruitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

        }catch (RecruitException e){
            // 저장 중 오류 발생
            return new ApiResponse(EnumResponseResult.ERROR, "ER001", e.getMessage());
        }
    }

    @Operation(summary = "채용정보 수정")
    @RequestMapping(value = "/notice/{id}", method = RequestMethod.PUT)
    public ApiResponse noticeEdit(
            @Parameter(name = "채용 정보", required = true)
            @RequestBody @Validated final Notice updateList,
            @Parameter(name = "id", required = true)
            @PathVariable("id") Long id){

        try{
            recruitService.modifyNotice(id, updateList);   // 공고수정 Api call
            return new ApiResponse(EnumResponseResult.SUCCESS, "SC001", "수정성공");

        }catch (RecruitException e){
            // 저장 중 오류 발생
            return new ApiResponse(EnumResponseResult.ERROR, "ER001", e.getMessage());
        }
    }

    @Operation(summary = "채용정보 삭제")
    @RequestMapping(value = "/notice/{id}", method = RequestMethod.DELETE)
    public ApiResponse noticeDeletion(
            @Parameter(name = "삭제할 채용공고 번호", required = true)
            @PathVariable("id") Long id){

        try{
            this.recruitService.removeNotice(id);   // 공고삭제 Api call
            return new ApiResponse(EnumResponseResult.SUCCESS, "SC001", "수정성공");

        }catch (RecruitException e){
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

        }catch (RecruitException e){
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

        }catch (RecruitException e){
            rs = null;
            return new ApiResponseData<>(EnumResponseResult.ERROR, "ER001", e.getMessage(), rs);
        }
    }

}
