package kr.co.wanted.judy.wantedpreonboardingbackend.controller;


import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Apply;
import kr.co.wanted.judy.wantedpreonboardingbackend.domain.Notice;
import kr.co.wanted.judy.wantedpreonboardingbackend.exception.RecruitException;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.ApiResponse;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.ApiResponseList;
import kr.co.wanted.judy.wantedpreonboardingbackend.model.type.EnumResponseResult;
import kr.co.wanted.judy.wantedpreonboardingbackend.service.RecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = {"Recruit"})
@RequestMapping(value = "/api/v1/wanted-recruit/")
@RequiredArgsConstructor
public class RecruitController {

    private final RecruitService recruitService;

    @Operation(summary = "채용정보 등록")
    @RequestMapping(value = "/notice", method = RequestMethod.POST)
    public ApiResponse noticeRegister(
            @Parameter(name = "채용 정보", required = true)
            @RequestBody Notice notice){

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
            @Parameter(name = "id", required = true)
            @PathVariable("id") Long id){

        try{
            this.recruitService.removeNotice(id);   // 공고삭제 Api call
            return new ApiResponse(EnumResponseResult.SUCCESS, "SC001", "삭제성공");

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
            // 저장 중 오류 발생
            rs = null;
            return new ApiResponseList<>(EnumResponseResult.ERROR, "ER001", e.getMessage(), rs);
        }
    }

    @Operation(summary = "채용정보 상세")
    @RequestMapping(value = "/notice-detail/{companyId}", method = RequestMethod.GET)
    public ApiResponseList<Notice> noticeDetail(
            @Parameter(name = "companyId")
            @PathVariable("companyId") long companyId, Pageable pageable){

        Page<Notice> rs;
        try{
            rs = recruitService.findNoticeDetail(companyId, pageable);   // 상세조회 Api call
            return new ApiResponseList<>(EnumResponseResult.SUCCESS, "SC001", "조회성공", rs.getContent());

        }catch (RecruitException e){
            // 저장 중 오류 발생
            return new ApiResponseList<>(EnumResponseResult.ERROR, "ER001", e.getMessage());
        }
    }

    @Operation(summary = "채용정보 키워드 검색")
    @RequestMapping(value = "/notice-search/{keyword}", method = RequestMethod.GET)
    public ApiResponseList<Notice> noticeFindKeyword(
            @Parameter(name = "keyword", required = true)
            @PathVariable("keyword") String keyword, Pageable pageable){

        Page<Notice> rs;
        try{
            rs = recruitService.searchNotice(keyword, pageable);   // 키워드 조회 Api call
            return new ApiResponseList<>(EnumResponseResult.SUCCESS, "SC001", "조회성공", rs.getContent());

        }catch (RecruitException e){
            // 저장 중 오류 발생
            return new ApiResponseList<>(EnumResponseResult.ERROR, "ER001", e.getMessage());
        }
    }

    @Operation(summary = "지원정보 등록")
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public ApiResponse applyRegister(
            @Parameter(name = "지원 정보", required = true)
            @RequestBody Apply apply){

        try{
            recruitService.addApply(apply);   // 공고등록 Api call
            return new ApiResponse(EnumResponseResult.SUCCESS, "SC001", "등록성공");

        }catch (RecruitException e){
            // 저장 중 오류 발생
            return new ApiResponse(EnumResponseResult.ERROR, "ER001", e.getMessage());
        }
    }

}
