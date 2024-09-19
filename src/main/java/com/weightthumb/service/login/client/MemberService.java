package com.weightthumb.service.login.client;

import com.weightthumb.service.login.client.model.MemberRepository;
import com.weightthumb.service.login.client.model.Member;
import com.weightthumb.service.login.client.model.MemberDto;
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


    public Optional<Member> createMember(MemberDto memberDto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("해당 사용자가 존재하지 않습니다"));

        createMember(memberDto, member);
        return Optional.of(member);
    }

    private void createMember(MemberDto memberDto, Member member) {
        Member updateMember = Member.builder()
                .id(member.getId())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .sex(memberDto.getSex())
                .age(memberDto.getAge())
                .height(memberDto.getHeight())
                .activityLevel(memberDto.getActivityLevel())
                .weight(memberDto.getWeight())
                .goalWeight(memberDto.getGoalWeight())
                .goalCalorie(memberDto.getGoalCalorie())
                .diet(memberDto.getDiet())
                .profile(member.getProfile())
                .birthday(member.getBirthday())
                .oauthProvider(member.getOauthProvider())
                .createdAt(member.getCreatedAt())
                .updatedAt(Timestamp.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
                .build();
        memberRepository.save(updateMember);
    }
}
