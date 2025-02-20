package com.clbee.admin.portalservice.api.privacy.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * com.clbee.admin.portalservice.api.privacy.dto.PrivacyUpdateRequestDto
 * <p>
 * 개인정보처리방침 수정 요청 DTO 클래스
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
public class PrivacyUpdateRequestDto {

    /**
     * 개인정보처리방침 제목
     */
    @NotBlank(message = "{privacy.privacy_title} {err.required}")
    private String privacyTitle;

    /**
     * 개인정보처리방침 내용
     */
    @NotBlank(message = "{privacy.privacy_content} {err.required}")
    private String privacyContent;

    /**
     * 사용 여부
     */
    @NotNull(message = "{common.use_at} {err.required}")
    private Boolean useAt;

}
