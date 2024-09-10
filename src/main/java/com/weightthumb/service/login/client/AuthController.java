package com.weightthumb.service.login.client;

import com.weightthumb.common.jwt.token.AuthTokens;
import com.weightthumb.common.oauth.kakao.KakaoLoginParams;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "카카오 코드 입력")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final OAuthLoginService oAuthLoginService;

    @Operation(summary = "카카오 code 입력 API",
            description = "body 에 authorizationCode 값 넣어라",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "카카오 로그인 파라미터",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = KakaoLoginParams.class),
                            examples = @ExampleObject(
                                    name = "인가 코드",
                                    value = "{\"authorizationCode\": \"String\"}"
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "ok",
                            content = @Content(schema = @Schema(implementation = AuthTokens.class),
                                    examples = @ExampleObject(
                                            name = "엑세스 토큰",
                                            value = "{\"accessToken\": \"String\"}"
                                    )
                            )
                    )
            })
    @PostMapping("/kakao")
    public ResponseEntity<AuthTokens> loginKakao(
            @Parameter(description = "authorizationCode가 키값임")
            @RequestBody KakaoLoginParams params
    ) {
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }
}
