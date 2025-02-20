package com.clbee.admin.portalservice.api.attachment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * com.clbee.admin.portalservice.api.attachment.dto.AttachmentUploadRequestDto
 * <p>
 * 첨부파일 업로드 저장 시 요청 dto class
 *
 * @author 표준프레임워크센터 seohan jung
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
@ToString
public class AttachmentUploadRequestDto {

    private String entityName;
    private String entityId;

    @Builder
    public AttachmentUploadRequestDto(String entityName, String entityId) {
        this.entityName = entityName;
        this.entityId = entityId;
    }
}
