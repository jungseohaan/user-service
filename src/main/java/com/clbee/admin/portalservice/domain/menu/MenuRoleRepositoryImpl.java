package com.clbee.admin.portalservice.domain.menu;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import com.clbee.admin.portalservice.api.menu.dto.MenuRoleResponseDto;
import com.clbee.admin.portalservice.api.menu.dto.MenuSideResponseDto;

import java.util.List;

import static com.clbee.admin.portalservice.domain.menu.QMenu.menu;

/**
 * com.clbee.admin.portalservice.domain.menu.MenuRoleRepositoryImpl
 * <p>
 * 메뉴관리 > 권한별 메뉴 querydsl 구현체
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
@RequiredArgsConstructor
public class MenuRoleRepositoryImpl implements MenuRoleRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    /**
     * 권한별 메뉴 트리 조회
     *
     * @param roleId
     * @param siteId
     * @return
     */
    @Override
    public List<MenuRoleResponseDto> findTree(String roleId, Long siteId) {
        return jpaQueryFactory.select(
                Projections.constructor(MenuRoleResponseDto.class, menu, Expressions.constant(roleId)))
                .from(menu)
                .where(menu.site.id.eq(siteId), menu.parent.isNull())
                .orderBy(menu.sortSeq.asc())
                .fetch();
    }

    @Override
    public List<MenuSideResponseDto> findMenu(String roleId, Long siteId) {
        return jpaQueryFactory.select(
                Projections.constructor(MenuSideResponseDto.class, menu, Expressions.constant(roleId)))
                .from(menu)
                .where(menu.site.id.eq(siteId),
                        menu.parent.isNull(),
                        menu.menuRoles.any().roleId.eq(roleId),
                        menu.isUse.isTrue())
                .orderBy(menu.sortSeq.asc())

                .fetch();
    }

}
