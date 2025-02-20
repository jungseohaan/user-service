package com.clbee.admin.portalservice.domain.menu;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.clbee.admin.servlet.domain.BaseEntity;

import javax.persistence.*;

/**
 * com.clbee.admin.portalservice.domain.menu.MenuRole
 * <p>
 * 메뉴관리 > 권한별 메뉴 도메인 class
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
@Entity
public class MenuRole extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_role_id")
    private Long id;    // id

    @Column(nullable = false, length = 20)
    private String roleId;  //role id

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id")
    private Menu menu;  //menu

    @Builder
    public MenuRole(Long id, String roleId, Menu menu) {
        this.id = id;
        this.roleId = roleId;
        this.menu = menu;
    }

    /**
     * 연관관계 설정
     *
     * @param menu
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
        menu.getMenuRoles().add(this);
    }

}
