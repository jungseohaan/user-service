package com.clbee.admin.boardservice.api.posts.dto;

import lombok.Getter;
import com.clbee.admin.boardservice.domain.board.Board;
import com.clbee.admin.boardservice.domain.posts.Posts;
import com.clbee.admin.boardservice.domain.posts.PostsId;

import javax.validation.constraints.NotBlank;

/**
 * com.clbee.admin.boardservice.api.posts.dto.PostsDeleteRequestDto
 * <p>
 * 게시물 삭제 요청 DTO 클래스
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
 *  2025/02/20    seohan jung       최초 생성
 * </pre>
 */
@Getter
public class PostsDeleteRequestDto {

    /**
     * 게시판 번호
     */
    @NotBlank(message = "{board.board_no} {err.required}")
    private Integer boardNo;

    /**
     * 게시물 번호
     */
    @NotBlank(message = "{posts.posts_no} {err.required}")
    private Integer postsNo;

    /**
     * 게시물 삭제 요청 DTO 속성 값으로 게시물 엔티티 빌더를 사용하여 객체 생성
     *
     * @return Posts 게시물 엔티티
     */
    public Posts toEntity() {
        return Posts.builder()
                .postsId(PostsId.builder()
                        .boardNo(boardNo)
                        .postsNo(postsNo)
                        .build())
                .board(Board.builder()
                    .boardNo(boardNo)
                    .build())
                .build();
    }

}
