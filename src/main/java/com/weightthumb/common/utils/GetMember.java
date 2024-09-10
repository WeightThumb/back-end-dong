package com.weightthumb.common.utils;

import com.weightthumb.service.login.client.model.Member;
import com.weightthumb.service.login.client.model.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class GetMember {
    private static MemberRepository memberRepository;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        GetMember.memberRepository = memberRepository;
    }
    public static Member getCurrentMember() {
        return memberRepository
                .findByEmail(
                        SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getName()
                )
                .orElseThrow(() -> new IllegalStateException("다시 로그인 해주세요"));
    }
}
