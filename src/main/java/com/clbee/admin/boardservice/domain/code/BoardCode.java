package com.clbee.admin.boardservice.domain.code;

import lombok.NoArgsConstructor;
import com.clbee.admin.servlet.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * com.clbee.admin.boardservice.domain.code.Code
 * <p>
 * 공통코드 엔티티
 *
 * @author seohan jung
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
@NoArgsConstructor
@Entity
public class BoardCode extends BaseEntity {

    @Id
    @Column(insertable = false, updatable = false)
    private String codeId; // 코드ID

    @Column(insertable = false, updatable = false)
    private String parentCodeId; // 상위 코드ID

    @Column(insertable = false, updatable = false)
    private String codeName; // 코드 명

}
