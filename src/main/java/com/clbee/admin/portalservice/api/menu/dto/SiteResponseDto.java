package com.clbee.admin.portalservice.api.menu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.clbee.admin.portalservice.domain.menu.Site;

/**
 * com.clbee.admin.portalservice.api.menu.dto.SiteResponseDto
 * <p>
 * 메뉴관리 사이트 응답 dto class
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
public class SiteResponseDto {
    private Long id;
    private String name;
    private Boolean isUse;

    @Builder
    public SiteResponseDto(Site entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.isUse = entity.getIsUse();
    }
}
