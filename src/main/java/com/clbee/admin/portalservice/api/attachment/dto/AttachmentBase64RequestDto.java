package com.clbee.admin.portalservice.api.attachment.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * com.clbee.admin.portalservice.api.attachment.dto.AttachmentBase64RequestDto
 * <p>
 * 첨부파일 Base64 업로드 요청 dto class
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
public class AttachmentBase64RequestDto {

    private String fieldName;
    private String fileType;
    private String fileBase64;
    private String originalName;
    private Long size;

    @Builder
    public AttachmentBase64RequestDto(String fieldName, String fileType, String fileBase64, String originalName, Long size) {
        this.fieldName = fieldName;
        this.fileType = fileType;
        this.fileBase64 = fileBase64;
        this.originalName = originalName;
        this.size = size;
    }
}
