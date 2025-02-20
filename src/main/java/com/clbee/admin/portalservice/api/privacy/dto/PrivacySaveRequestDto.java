package com.clbee.admin.portalservice.api.privacy.dto;

import lombok.Getter;
import com.clbee.admin.portalservice.domain.privacy.Privacy;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * com.clbee.admin.portalservice.api.privacy.dto.PrivacySaveRequestDto
 * <p>
 * 개인정보처리방침 등록 요청 DTO 클래스
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
public class PrivacySaveRequestDto {

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

    /**
     * 개인정보처리방침 등록 요청 DTO 속성 값으로 개인정보처리방침 엔티티 빌더를 사용하여 객체 생성
     *
     * @return Privacy 개인정보처리방침 엔티티
     */
    public Privacy toEntity() {
        return Privacy.builder()
                .privacyTitle(privacyTitle)
                .privacyContent(privacyContent)
                .useAt(useAt)
                .build();
    }

}
