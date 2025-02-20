package com.clbee.admin.portalservice.domain.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import com.clbee.admin.servlet.domain.BaseEntity;

import javax.persistence.*;

/**
 * com.clbee.admin.boardservice.domain.board.Board
 * <p>
 * 게시판 엔티티 클래스
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
@Entity
public class PortalBoard extends BaseEntity {

    /**
     * 게시판 번호
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardNo;

    /**
     * 게시판 제목
     */
    @Column(nullable = false, length = 100)
    private String boardName;

    /**
     * 스킨 유형 코드
     */
    @Column(nullable = false, length = 20)
    private String skinTypeCode;


}
