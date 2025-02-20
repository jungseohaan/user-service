package com.clbee.admin.portalservice.api.attachment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * com.clbee.admin.portalservice.api.attachment.dto.AttachmentEditorResponseDto
 * <p>
 * 첨부파일 에디터 업로드 응답 dto class
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
public class AttachmentEditorResponseDto extends AttachmentUploadResponseDto {
    private int uploaded;
    private String url;


    @Builder
    public AttachmentEditorResponseDto(String originalFileName, String message, String fileType, long size, int uploaded, String url) {
        this.originalFileName = originalFileName;
        this.message = message;
        this.fileType = fileType;
        this.size = size;
        this.uploaded = uploaded;
        this.url = url;
    }
}
