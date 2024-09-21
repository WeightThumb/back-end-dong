package com.weightthumb.service.login.client;

import com.weightthumb.service.login.client.model.MemberRepository;
import com.weightthumb.service.login.client.model.Member;
import com.weightthumb.service.login.client.model.MemberDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    @Transactional
    public Optional<Member> createMember(MemberDto memberDto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("해당 사용자가 존재하지 않습니다"));

        member.change(memberDto);
        return Optional.of(member);
    }

}
