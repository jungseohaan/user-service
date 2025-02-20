package com.clbee.admin.boardservice.api.posts.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.clbee.admin.boardservice.domain.board.Board;
import com.clbee.admin.boardservice.domain.posts.Posts;
import com.clbee.admin.boardservice.domain.posts.PostsId;

import javax.validation.constraints.NotBlank;

/**
 * com.clbee.admin.boardservice.api.posts.dto.PostsSimpleSaveRequestDto
 *
 * 게시물 등록 요청 DTO 클래스
 *
 * @author seohan jung
 * @version 1.0
 * @since 2025/02/20
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *    수정일       수정자              수정내용
 *  ----------    --------    ---------------------------
 *  2025/02/20    seohan jung       최초 생성
 * </pre>
 */
@Getter
@NoArgsConstructor
public class PostsSimpleSaveRequestDto {

    /**
     * 게시물 제목
     */
    @NotBlank(message = "{posts.posts_title} {err.required}")
    private String postsTitle;

    /**
     * 게시물 내용
     */
    @NotBlank(message = "{posts.posts_content} {err.required}")
    private String postsContent;

    /**
     * 첨부파일 코드
     */
    private String attachmentCode;

    /**
     * 게시물 등록 요청 DTO 클래스 생성자
     * 빌더 패턴으로 객체 생성
     *
     * @param postsTitle     게시물 제목
     * @param postsContent   게시물 내용
     * @param attachmentCode 첨부파일 코드
     */
    @Builder
    public PostsSimpleSaveRequestDto(String postsTitle, String postsContent, String attachmentCode) {
        this.postsTitle = postsTitle;
        this.postsContent = postsContent;
        this.attachmentCode = attachmentCode;
    }

    /**
     * 게시물 등록 요청 DTO 속성 값으로 게시물 엔티티 빌더를 사용하여 객체 생성
     *
     * @param boardNo 게시판 번호
     * @param postsNo 게시물 번호
     * @return Posts 게시물 엔티티
     */
    public Posts toEntity(Integer boardNo, Integer postsNo) {
        return Posts.builder()
                .board(Board.builder()
                        .boardNo(boardNo)
                        .build())
                .postsId(PostsId.builder()
                        .boardNo(boardNo)
                        .postsNo(postsNo)
                        .build())
                .postsTitle(postsTitle)
                .postsContent(postsContent)
                .attachmentCode(attachmentCode)
                .build();
    }

}
