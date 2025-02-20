package com.clbee.admin.portalservice.api.menu.dto;

import java.util.Optional;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.clbee.admin.portalservice.domain.menu.Menu;

import com.clbee.admin.portalservice.domain.menu.Site;

/**
 * com.clbee.admin.portalservice.api.menu.dto.MenuTreeRequestDto
 * <p>
 * 메뉴관리 tree 추가 요청 dto class
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
public class MenuTreeRequestDto {
    private Long siteId;
    private String name;
    private Integer sortSeq;
    private Long parentId;
    private Integer level;
    private Boolean isShow;
    private Boolean isUse;

    @Builder
    public MenuTreeRequestDto(Long siteId, String name, Integer sortSeq, Long parentId, Integer level, Boolean isShow, Boolean isUse) {
        this.siteId = siteId;
        this.name = name;
        this.sortSeq = sortSeq;
        this.parentId = parentId;
        this.level = level;
        this.isShow = isShow;
        this.isUse = isUse;
    }

    public Menu toEntity(Optional<Menu> parent, Site site) {
        return Menu.builder()
            .parent(parent)
            .site(site)
            .menuKorName(name)
            .sortSeq(sortSeq)
            .level(level)
            .isShow(isShow)
            .isUse(isUse)
            .build();
    }
}
