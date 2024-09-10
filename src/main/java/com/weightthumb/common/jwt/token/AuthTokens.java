package com.weightthumb.common.jwt.token;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "토큰")
public class AuthTokens {
    @Schema(description = "액세스 토큰")
    private String accessToken;

    public static AuthTokens of(String accessToken) {
        return new AuthTokens(accessToken);
    }
}

