package com.clbee.admin.portalservice.domain.attachment;

import com.clbee.admin.common.dto.RequestDto;
import com.clbee.admin.portalservice.api.attachment.dto.AttachmentResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * com.clbee.admin.portalservice.domain.attachment.AttachmentRepositoryCustom
 * <p>
 * 첨부파일 querydsl interface
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
public interface AttachmentRepositoryCustom {
    List<Attachment> findByCode(String attachmentCode);
    AttachmentId getId(String attachmentCode);
    Page<AttachmentResponseDto> search(RequestDto searchRequestDto, Pageable pageable);
}
