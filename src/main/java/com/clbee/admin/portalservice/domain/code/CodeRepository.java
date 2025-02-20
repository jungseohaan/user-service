package com.clbee.admin.portalservice.domain.code;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * com.clbee.admin.portalservice.domain.code.CodeRepository
 * <p>
 * 공통코드 엔티티를 위한 Repository
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
public interface CodeRepository extends JpaRepository<Code, String>, CodeRepositoryCustom {
    Optional<Code> findByCodeId(String codeId);
}
