package com.clbee.admin.portalservice.api.message.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * com.clbee.admin.portalservice.api.message.dto.MessageListResponseDto
 * <p>
 * Message 목록 조회 응답 dto
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
@Getter
@NoArgsConstructor
public class MessageListResponseDto {
    private String messageId;
    private String messageName;
}
