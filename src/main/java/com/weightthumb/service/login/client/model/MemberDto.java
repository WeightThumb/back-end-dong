package com.weightthumb.service.login.client.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
@Schema(description = "사용자 정보 DTO")
public class MemberDto {

    @Schema(description = "성별", example = "male|female")
    @NotBlank(message = "성별은 필수값 입니다.")
    @Pattern(regexp = "^(male|female)$", message = "성별은 남, 여 만 입력 가능 합니다")
    private String sex;

    @Schema(description = "나이", example = "30")
    @NotBlank(message = "나이를 필수값 입니다.")
    @Range(min = 1, max = 99)
    private String age;

    @Schema(description = "키(신장)", example = "160")
    @NotNull(message = "키는 필수값 입니다.")
    @Range(min = 100, max = 250)
    private Integer height;

    @Schema(description = "활동량", example = "little|less|moderately|much|more")
    @NotBlank(message = "활동량은 필수값 입니다.")
    @Pattern(regexp = "^(little|less|moderately|much|more)$")
    private String activityLevel;

    @Schema(description = "시작 체중", example = "55")
    @NotNull(message = "시작 체중은 필수값 입니다.")
    @Range(min = 10, max = 300)
    private Double weight;

    @Schema(description = "목표 체중", example = "50")
    @NotNull(message = "목표 체중은 필수값 입니다")
    @Range(min = 10, max = 300)
    private Double goalWeight;

    @Schema(description = "목표 칼로리", example = "1100")
    @NotNull(message = "목표 칼로리는 필수값 입니다.")
    @Range(min = 1, max = 9999)
    // 내활동대사량 계산
    private Integer goalCalorie;

    @Schema(description = "식단", example = "regular|exercise|keto|vegan")
    @NotBlank(message = "식단은 필수값 입니다.")
    @Pattern(regexp = "^(regular|exercise|keto|vegan)$")
    private String diet;

}
