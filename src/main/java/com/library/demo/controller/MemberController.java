package com.library.demo.controller;

import com.library.demo.dto.request.MemberRequest;
import com.library.demo.dto.response.CommonResponse;
import com.library.demo.dto.response.MemberResponse;
import com.library.demo.service.MemberService;
import com.library.demo.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<CommonResponse<MemberResponse>> createMember(@RequestBody MemberRequest memberRequest) {
        return ResponseUtil.createResponse(
                HttpStatus.CREATED,
                "Berhasil menambahkan member.",
                memberService.createMember(memberRequest)
        );
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<MemberResponse>>> getMembers() {
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Daftar member didapatkan",
                memberService.getMembers()
        );
    }
}
