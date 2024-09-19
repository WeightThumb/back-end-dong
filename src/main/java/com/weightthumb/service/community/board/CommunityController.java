package com.weightthumb.service.community.board;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/community/board")
@Tag(name = "대나무 숲 API")
public class CommunityController {
    private final CommunityService communityService;

    @Operation(summary = "게시글 작성 API", description = "선택된 카테고리, 제목, 내용, 이미지(Optional)")
    @PostMapping("/created")
    public ResponseEntity<?> createdBoard() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "게시글 조회 API", description = "선택된 카테고리(선택되지 않으면 모든 주제), 게시글 제목, 조회수, 좋아요 수, 댓글 수 -> 무한 스크롤")
    @GetMapping("/read")
    public ResponseEntity<?> readBoard() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "카테고리 조회 API", description = "카테고리 리스트")
    @GetMapping("/category/read")
    public ResponseEntity<?> readCategoryBoard() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "게시글 상세 조회 API", description = "카테고리, 익명 이름, 조회수, 좋아요 수, 댓글 수, 게시글 내용")
    @GetMapping("/info/read")
    public ResponseEntity<?> readInfoBoard() {
        return ResponseEntity.ok().build();
    }
}
