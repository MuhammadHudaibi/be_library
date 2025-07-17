package com.library.demo.controller;

import com.library.demo.dto.request.MemberRequest;
import com.library.demo.dto.response.MemberResponse;
import com.library.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public MemberResponse createMember(@RequestBody MemberRequest memberRequest) {
        return memberService.createMember(memberRequest);
    }

    @GetMapping
    public List<MemberResponse> getMembers() {
        return memberService.getMembers();
    }
}
