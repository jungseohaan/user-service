package com.clbee.admin.portalservice.api.content.dto;

import lombok.Getter;
import com.clbee.admin.portalservice.domain.content.Content;

import javax.validation.constraints.NotBlank;

/**
 * com.clbee.admin.portalservice.api.content.dto.ContentSaveRequestDto
 * <p>
 * 컨텐츠 등록 요청 DTO 클래스
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
 *  2025/02/20    seohan jung       최초 생성
 * </pre>
 */
@Getter
public class ContentSaveRequestDto {

    /**
     * 컨텐츠 명
     */
    @NotBlank(message = "{content.content_name} {err.required}")
    private String contentName;

    /**
     * 컨텐츠 비고
     */
    private String contentRemark;

    /**
     * 컨텐츠 값
     */
    @NotBlank(message = "{content.content_value} {err.required}")
    private String contentValue;

    /**
     * 컨텐츠 등록 요청 DTO 속성 값으로 컨텐츠 엔티티 빌더를 사용하여 객체 생성
     *
     * @return Content 컨텐츠 엔티티
     */
    public Content toEntity() {
        return Content.builder()
                .contentName(contentName)
                .contentRemark(contentRemark)
                .contentValue(contentValue)
                .build();
    }

}
