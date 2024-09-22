package com.weightthumb.service.login.information;

import com.weightthumb.service.BaseResponse;
import com.weightthumb.service.login.client.model.MemberDto;
import com.weightthumb.service.login.client.model.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
@Tag(name = "사용자 정보 API")
public class MemberController {
    private final MemberService memberService;

    //BindingResult 확인
    @Operation(summary = "사용 정보 API", description = "사용자 정보 저장")
    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createMember(@RequestBody @Validated MemberDto memberDto) {
        memberService.createMember(memberDto);
        return ResponseEntity.ok(
                BaseResponse.builder()
                        .resultCode("200")
                        .resultMessage(null)
                        .result(null)
                        .build()
        );
    }
}
