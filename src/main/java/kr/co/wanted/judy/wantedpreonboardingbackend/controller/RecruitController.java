package kr.co.wanted.judy.wantedpreonboardingbackend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(tags = {"Recruit Controller"})
@RequestMapping(value = "/api/v1/wanted-recruit/")
@RequiredArgsConstructor
public class RecruitController {

    @ApiOperation(value = "Adding notice")
    @RequestMapping(value = "/notice", method = RequestMethod.POST)
    public void noticeAdd(){

    }

    @ApiOperation(value = "Adding notice")
    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public void noticeList(){

    }

    @ApiOperation(value = "Adding notice")
    @RequestMapping(value = "/notice-detail", method = RequestMethod.GET)
    public void noticeDetail(){

    }


}
