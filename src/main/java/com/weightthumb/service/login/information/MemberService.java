package com.weightthumb.service.login.information;

import com.weightthumb.common.utils.GetMember;
import com.weightthumb.service.login.client.model.MemberRepository;
import com.weightthumb.service.login.client.model.Member;
import com.weightthumb.service.login.client.model.MemberDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
    public void createMember(MemberDto memberDto) {
        Optional<Member> member = memberRepository.findByEmail(GetMember.getCurrentMember().getEmail());

        member.ifPresent(m -> {
            member.get().setAge(memberDto.getAge());
            //멤버 추가
        });

        memberRepository.save(member.get());
    }
}
