package com.clbee.admin.portalservice.api.banner.dto;

import com.clbee.admin.common.dto.RequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * com.clbee.admin.portalservice.api.content.dto.BannerRequestDto
 * <p>
 * 배너 목록 요청 DTO 클래스
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
 *  2025/02/20    seohan jung       최초 생성
 * </pre>
 */
@Getter
@NoArgsConstructor
public class BannerRequestDto extends RequestDto {
	private Long siteId;
}
