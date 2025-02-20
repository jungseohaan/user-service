package com.clbee.admin.portalservice.domain.menu;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.clbee.admin.servlet.domain.BaseEntity;

import javax.persistence.*;

/**
 * com.clbee.admin.portalservice.domain.menu.Site
 * <p>
 * 메뉴관리 > 사이트 도메인 class
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
public class Site extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_id")
    private Long id;

    @Column(name = "site_name", length = 50)
    private String name;

    @Column(name = "use_at", columnDefinition = "boolean default true")
    private Boolean isUse;

    @Column(columnDefinition = "SMALLINT(3)")
    private Integer sortSeq;

    @Builder
    public Site(String name, Boolean isUse, Integer sortSeq) {
        this.name = name;
        this.isUse = isUse;
        this.sortSeq = sortSeq;
    }

}
