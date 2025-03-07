package com.clbee.admin.portalservice.api.menu.dto;

import java.util.Objects;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * com.clbee.admin.portalservice.api.menu.dto.MenuDnDRequestDto
 * <p>
 * 메뉴관리 Tree Drag and Drop 저장 요청 dto class
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
public class MenuDnDRequestDto {

    private Long menuId;
    private String name;
    private Integer sortSeq;
    private Long parentId;
    private Integer level;
    private String icon;
    private List<MenuDnDRequestDto> children = new ArrayList<>();


    @Builder
    public MenuDnDRequestDto(Long menuId, String name, Integer sortSeq, Long parentId, Integer level, String icon, List<MenuDnDRequestDto> children) {
        this.menuId = menuId;
        this.name = name;
        this.sortSeq = sortSeq;
        this.parentId = parentId;
        this.level = level;
        this.icon = icon;
        this.children = children == null ? null : new ArrayList<>(children);
    }

    public boolean hasParentId() {
        return Objects.nonNull(parentId);
    }
}
