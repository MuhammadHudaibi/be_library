package com.library.demo.service.impl;

import com.library.demo.dto.request.MemberRequest;
import com.library.demo.dto.response.MemberResponse;
import com.library.demo.entity.Member;
import com.library.demo.mapper.MemberMapper;
import com.library.demo.repository.MemberRepository;
import com.library.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberResponse createMember(MemberRequest memberRequest) {
        Member member = Member.builder()
                .name(memberRequest.getName())
                .address(memberRequest.getAddress())
                .phoneNumber(memberRequest.getPhoneNumber())
                .build();
        memberRepository.save(member);
        return MemberMapper.toMemberResponse(member);
    }

    @Override
    public List<MemberResponse> getMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(MemberMapper::toMemberResponse).collect(Collectors.toList());
    }

    @Override
    public Member findById(UUID id) {
        return memberRepository.findById(id).orElse(null);
    }
}
