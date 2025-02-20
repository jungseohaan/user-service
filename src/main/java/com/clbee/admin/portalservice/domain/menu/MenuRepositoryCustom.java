package com.clbee.admin.portalservice.domain.menu;

import com.clbee.admin.portalservice.api.menu.dto.MenuResponseDto;
import com.clbee.admin.portalservice.api.menu.dto.MenuTreeResponseDto;

import java.util.List;

/**
 * com.clbee.admin.portalservice.domain.menu.MenuRepositoryCustom
 * <p>
 * 메뉴관리 > Menu querydsl interface
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
public interface MenuRepositoryCustom {
    List<MenuTreeResponseDto> findTreeBySiteId(Long siteId);
    MenuResponseDto findByIdWithConnectName(Long menuId);
}
