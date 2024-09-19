package com.weightthumb.service.community.board.comment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/community/comment")
@Tag(name = "대나무 숲 API")
public class CommentController {

    @Operation(summary = "댓글 작성 API", description = "댓글 내용, 댓글 이모션")
    @PostMapping("/created")
    public ResponseEntity<?> createdComment() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "댓글 조회 API", description = "댓글 내용, 작성자, 댓글 이모션, 시간(프론트에서 계산해라)")
    @GetMapping("/read")
    public ResponseEntity<?> readComment() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "댓글 수정 API", description = "댓글 내용, 댓글 이모션")
    @PutMapping("/update")
    public ResponseEntity<?> updateComment() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "댓글 삭제 API")
    @DeleteMapping(value = "delete")
    public ResponseEntity<?> deleteComment() {
        return ResponseEntity.ok().build();
    }
}
