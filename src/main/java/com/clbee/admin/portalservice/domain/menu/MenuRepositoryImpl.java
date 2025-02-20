package com.clbee.admin.portalservice.domain.menu;

import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import com.clbee.admin.portalservice.api.menu.dto.MenuResponseDto;
import com.clbee.admin.portalservice.api.menu.dto.MenuTreeResponseDto;

import java.util.List;

import static com.querydsl.core.types.Projections.constructor;
import static com.querydsl.core.types.Projections.fields;
import static com.clbee.admin.boardservice.domain.board.QBoard.board;
import static com.clbee.admin.portalservice.domain.content.QContent.content;
import static com.clbee.admin.portalservice.domain.menu.QMenu.menu;

/**
 * com.clbee.admin.portalservice.domain.menu.MenuRepositoryImpl
 * <p>
 * 메뉴관리 > Menu querydsl 구현체
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
public class MenuRepositoryImpl implements MenuRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    /**
     * 메뉴관리 tree 조회
     *
     * @param siteId
     * @return
     */
    @Override
    public List<MenuTreeResponseDto> findTreeBySiteId(Long siteId) {
        return jpaQueryFactory.select(
                constructor(MenuTreeResponseDto.class, menu))
                .from(menu)
                .where(menu.site.id.eq(siteId), menu.parent.isNull())
                .orderBy(menu.sortSeq.asc())
                .fetch();
    }

    /**
     * 메뉴 상세 정보 조회
     *
     * @param menuId
     * @return
     */
    @Override
    public MenuResponseDto findByIdWithConnectName(Long menuId) {

        return jpaQueryFactory.select(
                fields(MenuResponseDto.class,
                        menu.id.as("menuId"),
                        menu.menuKorName,
                        menu.menuEngName,
                        menu.menuType,
                        menu.connectId,
                        new CaseBuilder()
                                .when(
                                        menu.menuType.eq("contents")
                                ).then(
                                        JPAExpressions.select(content.contentName)
                                                .from(content)
                                                .where(content.contentNo.eq(menu.connectId)))
                                .when(
                                        menu.menuType.eq("board")
                                ).then(
                                        JPAExpressions.select(board.boardName)
                                                .from(board)
                                                .where(board.boardNo.eq(menu.connectId)))
                                .otherwise("").as("connectName"),
                        menu.urlPath,
                        menu.isUse,
                        menu.isShow,
                        menu.isBlank,
                        menu.subName,
                        menu.description,
                        menu.icon
                        )
        )
                .from(menu)
                .where(menu.id.eq(menuId))
                .fetchOne();

    }


}
