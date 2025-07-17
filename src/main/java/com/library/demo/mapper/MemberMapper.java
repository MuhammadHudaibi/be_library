package com.library.demo.mapper;

import com.library.demo.dto.response.MemberResponse;
import com.library.demo.entity.Member;

public class MemberMapper {
    public static MemberResponse toMemberResponse(Member member){
        return MemberResponse.builder()
                .memberId(member.getId())
                .name(member.getName())
                .address(member.getAddress())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }
}
