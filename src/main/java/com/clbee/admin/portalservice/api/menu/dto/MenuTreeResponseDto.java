package com.clbee.admin.portalservice.api.menu.dto;

import java.util.Comparator;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.clbee.admin.portalservice.domain.menu.Menu;

import java.util.List;
import java.util.stream.Collectors;

/**
 * com.clbee.admin.portalservice.api.menu.dto.MenuTreeResponseDto
 * <p>
 * 메뉴관리 tree 응답 dto class
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
public class MenuTreeResponseDto {
    private Long menuId;
    private String name;
    private Long parentId;
    private Integer sortSeq;
    private String icon;
    @ToString.Exclude
    private List<MenuTreeResponseDto> children;
    private Integer level;

    @Builder
    public MenuTreeResponseDto(Menu entity) {
        this.menuId = entity.getId();
        this.name = entity.getMenuKorName();
        if (entity.getParent() != null) {
            this.parentId = entity.getParent().getId();
        }

        this.sortSeq = entity.getSortSeq();
        this.icon = entity.getIcon();
        this.level = entity.getLevel();
        this.children = entity.getChildren().stream()
                .map(children -> new MenuTreeResponseDto(children))
                .sorted(Comparator.comparing(MenuTreeResponseDto::getSortSeq))
                .collect(Collectors.toList());

    }

}
