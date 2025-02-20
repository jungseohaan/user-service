package com.clbee.admin.portalservice.api.attachment.dto;


import lombok.*;

/**
 * com.clbee.admin.portalservice.api.attachment.dto.AttachmentUploadResponseDto
 * <p>
 * 첨부파일 업로드에 대한 응답 dto 추상 class
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
public class AttachmentUploadResponseDto {
    protected String originalFileName;
    protected String message;
    protected String fileType;
    protected long size;

}
