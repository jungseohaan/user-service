package com.clbee.admin.portalservice.domain.message;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * com.clbee.admin.portalservice.domain.message.CodeRepositoryCustom
 * <p>
 * Message 엔티티를 위한 Repository
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
 *  2025/02/20    seohan jung  최초 생성
 * </pre>
 */
public interface MessageRepository extends JpaRepository<Message, String>, MessageRepositoryCustom {
}
