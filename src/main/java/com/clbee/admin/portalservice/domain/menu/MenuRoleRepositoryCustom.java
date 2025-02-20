package com.clbee.admin.portalservice.domain.menu;

import com.clbee.admin.portalservice.api.menu.dto.MenuRoleResponseDto;
import com.clbee.admin.portalservice.api.menu.dto.MenuSideResponseDto;

import java.util.List;

/**
 * com.clbee.admin.portalservice.domain.menu.MenuRoleRepositoryCustom
 * <p>
 * 메뉴관리 > 권한별 메뉴 querydsl interface
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
public interface MenuRoleRepositoryCustom {
    List<MenuRoleResponseDto> findTree(String roleId, Long siteId);
    List<MenuSideResponseDto> findMenu(String roleId, Long siteId);
}
