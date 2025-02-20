package com.clbee.admin.portalservice.domain.menu;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * com.clbee.admin.portalservice.domain.menu.MenuRoleRepository
 * <p>
 * 메뉴관리 > 권한별 메뉴 Repository interface
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
public interface MenuRoleRepository extends JpaRepository<MenuRole, Long>, MenuRoleRepositoryCustom {
}
