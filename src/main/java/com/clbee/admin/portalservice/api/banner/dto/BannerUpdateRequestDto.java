package com.clbee.admin.portalservice.api.banner.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * com.clbee.admin.portalservice.api.content.dto.BannerUpdateRequestDto
 * <p>
 * 배너 수정 요청 DTO 클래스
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
public class BannerUpdateRequestDto {

    /**
     * 배너 구분 코드
     */
    @NotBlank(message = "{banner.banner_type_code} {err.required}")
    private String bannerTypeCode;

    /**
     * 배너 제목
     */
    @NotBlank(message = "{banner.banner_title} {err.required}")
    private String bannerTitle;

    /**
     * 첨부파일 코드
     */
    @NotBlank(message = "{banner.attachment_code} {err.required}")
    private String attachmentCode;

    /**
     * url 주소
     */
    private String urlAddr;

    /**
     * 새 창 여부
     */
    private Boolean newWindowAt;

    /**
     * 배너 내용
     */
    private String bannerContent;

    /**
     * 정렬 순서
     */
    private Integer sortSeq;

    /**
     * site Id
     */
    private Long siteId;

}
