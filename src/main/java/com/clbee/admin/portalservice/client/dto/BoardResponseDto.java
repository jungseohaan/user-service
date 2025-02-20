package com.clbee.admin.portalservice.client.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * com.clbee.admin.boardservice.api.board.dto.BoardResponseDto
 * <p>
 * 게시판 상세 응답 DTO 클래스
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
 *  2025/02/20    seohan       최초 생성
 * </pre>
 */
@Getter
@NoArgsConstructor
public class BoardResponseDto implements Serializable {

    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = -7139346671431363426L;

    /**
     * 게시판 번호
     */
    private Integer boardNo;

    /**
     * 게시판 제목
     */
    private String boardName;

    /**
     * 스킨 유형 코드
     */
    private String skinTypeCode;

    /**
     * 제목 표시 길이
     */
    private Integer titleDisplayLength;

    /**
     * 게시물 표시 수
     */
    private Integer postDisplayCount;

    /**
     * 페이지 표시 수
     */
    private Integer pageDisplayCount;

    /**
     * 표시 신규 수
     */
    private Integer newDisplayDayCount;

    /**
     * 에디터 사용 여부
     */
    private Boolean editorUseAt;

    /**
     * 댓글 사용 여부
     */
    private Boolean commentUseAt;

    /**
     * 업로드 사용 여부
     */
    private Boolean uploadUseAt;

    /**
     * 업로드 제한 수
     */
    private Integer uploadLimitCount;

    /**
     * 업로드 제한 크기
     */
    private Integer uploadLimitSize;

}
