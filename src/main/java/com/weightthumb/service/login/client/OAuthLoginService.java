package com.weightthumb.service.login.client;

import com.weightthumb.common.jwt.token.AuthTokens;
import com.weightthumb.common.jwt.token.AuthTokensGenerator;
import com.weightthumb.common.oauth.OAuthInfoResponse;
import com.weightthumb.common.oauth.OAuthLoginParams;
import com.weightthumb.common.oauth.RequestOAuthInfoService;
import com.weightthumb.common.oauth.kakao.KakaoInfoResponse;
import com.weightthumb.service.login.client.model.Member;
import com.weightthumb.service.login.client.model.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class OAuthLoginService {
    private final MemberRepository memberRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;
    private final RestTemplate restTemplate;

    public void logout(String accessToken) {
        String url = "https://kapi.kakao.com/v1/user/logout";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.set("Authorization", "Bearer" +  accessToken);

        HttpEntity<?> request = new HttpEntity<>("", httpHeaders);
        restTemplate.postForObject(url, request, KakaoInfoResponse.class);
    }
    public AuthTokens login(OAuthLoginParams params) {
        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);
        Long memberId = findOrCreateMember(oAuthInfoResponse);
        return authTokensGenerator.generate(memberId);
    }

    private Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        return memberRepository.findByEmail(oAuthInfoResponse.getEmail())
                .map(Member::getId)
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }

    private Long newMember(OAuthInfoResponse oAuthInfoResponse) {
        Member member = Member.builder()
                .email(oAuthInfoResponse.getEmail())
                .nickname(oAuthInfoResponse.getNickname())
                .sex(oAuthInfoResponse.getGender())
                .age(oAuthInfoResponse.getAge_range())
                .birthday(oAuthInfoResponse.getBirthday())
                .profile(oAuthInfoResponse.getProfile_image_url())
                .weight(null)
                .goalWeight(null)
                .diet(null)
                .createdAt(Timestamp.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
                .updatedAt(Timestamp.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
                .oauthProvider(oAuthInfoResponse.getOAuthProvider())
                .build();

        return memberRepository.save(member).getId();
    }

}
