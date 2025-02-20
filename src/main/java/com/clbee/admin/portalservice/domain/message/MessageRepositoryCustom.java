package com.clbee.admin.portalservice.domain.message;

import com.clbee.admin.portalservice.api.message.dto.MessageListResponseDto;

import java.util.List;
import java.util.Map;

/**
 * com.clbee.admin.portalservice.domain.message.CodeRepositoryCustom
 * <p>
 * Message Querydsl interface
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
public interface MessageRepositoryCustom {
    List<MessageListResponseDto> findAllMessages(String lang);
    Map<String, String> findAllMessagesMap(String lang);
}
