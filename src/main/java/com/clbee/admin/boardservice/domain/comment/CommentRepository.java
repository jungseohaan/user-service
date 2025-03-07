package com.clbee.admin.boardservice.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * com.clbee.admin.boardservice.domain.comment.CommentRepository
 *
 * 댓글 레파지토리 인터페이스
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
public interface CommentRepository extends JpaRepository<Comment, CommentId>, CommentRepositoryCustom {

}
