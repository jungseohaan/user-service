package com.clbee.admin.userservice.domain.log;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * com.clbee.admin.userservice.domain.log.LoginLogRepository
 * <p>
 * Spring Data JPA 에서 제공되는 JpaRepository 를 상속하는 인터페이스
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
public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {
}
