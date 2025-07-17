package com.library.demo.service;

import com.library.demo.dto.request.MemberRequest;
import com.library.demo.dto.response.MemberResponse;
import com.library.demo.entity.Member;

import java.util.List;
import java.util.UUID;

public interface MemberService {
    MemberResponse createMember(MemberRequest memberRequest);
    List<MemberResponse> getMembers();
    Member findById(UUID id);
}
