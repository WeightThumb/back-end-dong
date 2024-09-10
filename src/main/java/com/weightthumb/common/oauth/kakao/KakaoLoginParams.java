package com.weightthumb.common.oauth.kakao;

import com.weightthumb.common.oauth.OAuthLoginParams;
import com.weightthumb.common.oauth.OAuthProvider;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@NoArgsConstructor
@Getter
@Schema(description = "카카오 인가 코드")
public class KakaoLoginParams implements OAuthLoginParams {
    @Schema(description = "카카오 인가 코드", example = "sadofijasofiaweofih")
    private String authorizationCode;

    @Override
    public OAuthProvider oAuthProvider() {
        return OAuthProvider.KAKAO;
    }
    @Override
    public MultiValueMap<String, String> makeBody() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("code", authorizationCode);
        return body;
    }
}
