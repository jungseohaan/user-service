package com.clbee.admin.boardservice.api.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.clbee.admin.boardservice.domain.comment.Comment;
import com.clbee.admin.boardservice.domain.comment.CommentId;
import com.clbee.admin.boardservice.domain.posts.PostsId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * com.clbee.admin.boardservice.api.comment.dto.CommentSaveRequestDto
 *
 * 댓글 수정 요청 DTO 클래스
 *
 * @author seohan jung
 * @version 1.0
 * @since 2025/02/20
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일        수정자           수정내용
 *  ----------    --------    ---------------------------
 *  2025/02/20   seohan       최초 생성
 * </pre>
 */
@Getter
@NoArgsConstructor
public class CommentUpdateRequestDto {

    /**
     * 게시판 번호
     */
    @NotNull(message = "{board.board_no} {err.required}")
    private Integer boardNo;

    /**
     * 게시물 번호
     */
    @NotNull(message = "{posts.posts_no} {err.required}")
    private Integer postsNo;

    /**
     * 댓글 번호
     */
    @NotNull(message = "{comment.comment_no} {err.required}")
    private Integer commentNo;

    /**
     * 댓글 내용
     */
    @NotBlank(message = "{comment.comment_content} {err.required}")
    private String commentContent;

    /**
     * 댓글 수정 요청 DTO 클래스 생성자
     * 빌더 패턴으로 객체 생성
     *
     * @param commentContent  댓글 내용
     */
    @Builder
    public CommentUpdateRequestDto(Integer boardNo, Integer postsNo, Integer commentNo, String commentContent) {
        this.boardNo = boardNo;
        this.postsNo = postsNo;
        this.commentNo = commentNo;
        this.commentContent = commentContent;
    }

    /**
     * 댓글 수정 요청 DTO 속성 값으로 댓글 엔티티 빌더를 사용하여 객체 생성
     *
     * @return Comment 댓글 엔티티
     */
    public Comment toEntity() {
        return Comment.builder()
                .commentId(CommentId.builder()
                        .postsId(PostsId.builder()
                                .boardNo(boardNo)
                                .postsNo(postsNo)
                                .build())
                        .commentNo(commentNo)
                        .build())
                .commentContent(commentContent)
                .build();
    }

}
