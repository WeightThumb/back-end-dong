package com.weightthumb.service.login.client;

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

    @Operation(summary = "사용 정보 API", description = "사용자 정보 저장"
            /*requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "사용자 정보 저장 요청 파라미터",
            required = true
            content = @Content(mediaType = "application/json"
                    examples = @ExampleObject(
                            name = "요청 파라미터",
                            value = "{\"sex\": \"String\"" +
                                    ", \"age\": \"Int\"" +
                                    ", \"height\": \"Int\"" +
                                    ", \"activity\": \"String\"" +
                                    ", \"goalCalorie\": \"Int\"" +
                                    ", \"diet\": \"String\"}"
                    )
            )

    )
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(ref = "#/components/schemas/MemberDto"


            )))*/

    )
    @PostMapping("/create")
    public ResponseEntity createMember(@RequestBody @Validated MemberDto memberDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.warn("오류발생  {}",bindingResult);
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        Optional<Member> member = memberService.createMember(memberDto);

        return ResponseEntity.ok(member.get());
    }
}
