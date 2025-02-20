package com.clbee.admin.portalservice.api.menu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.clbee.admin.portalservice.domain.menu.Menu;

/**
 * com.clbee.admin.portalservice.api.menu.dto.MenuResponseDto
 * <p>
 * 메뉴관리 상세 정보 응답 dto class
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
public class MenuResponseDto {
    private Long menuId;
    private String menuKorName;
    private String menuEngName;
    private String menuType;
    private Integer connectId;
    private String connectName;
    private String urlPath;
    private Boolean isUse;
    private Boolean isShow;
    private Boolean isBlank;
    private String subName;
    private String description;
    private String icon;

    @Builder
    public MenuResponseDto(Menu entity) {
        this.menuId = entity.getId();
        this.menuKorName = entity.getMenuKorName();
        this.menuEngName = entity.getMenuEngName();
        this.menuType = entity.getMenuType();
        this.connectId = entity.getConnectId();
        this.urlPath = entity.getUrlPath();
        this.isUse = entity.getIsUse();
        this.isShow = entity.getIsShow();
        this.isBlank = entity.getIsBlank();
        this.subName = entity.getSubName();
        this.description = entity.getDescription();
        this.icon = entity.getIcon();
    }
}
