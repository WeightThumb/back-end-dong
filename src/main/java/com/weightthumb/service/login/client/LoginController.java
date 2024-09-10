package com.weightthumb.service.login.client;

import com.weightthumb.common.jwt.JwtTokenProvider;
import com.weightthumb.common.jwt.token.AuthTokens;
import com.weightthumb.common.jwt.token.AuthTokensGenerator;
import com.weightthumb.service.login.client.model.Member;
import com.weightthumb.service.login.client.model.MemberRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "카카오 로그인")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
@CrossOrigin
public class LoginController {
    private final MemberRepository memberRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final JwtTokenProvider jwtTokenProvider;

    @Operation(summary = "액세스 토큰에 해당하는 멤버 API",
            description = "토큰을 보내주면 토근에 저장되어 있는 멤버의 정보를 응답한다.",

            responses = {
            @ApiResponse(
                    responseCode = "200", description = "ok"
            )}
    )
    @GetMapping("/{accessToken}")
    public ResponseEntity<Member> findByAccessToken(@PathVariable String accessToken) {
        Long memberId = authTokensGenerator.extractMemberId(accessToken);
        return ResponseEntity.ok(memberRepository.findById(memberId).get());
    }
}
