package com.clbee.admin.portalservice.domain.statistics;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * com.clbee.admin.portalservice.domain.statistics.StatisticsRepository
 * <p>
 * 통계 entity를 위한 repository class
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
 *  2025/02/20    seohan jung      최초 생성
 * </pre>
 */
public interface StatisticsRepository extends JpaRepository<Statistics, Long>, StatisticsRepositoryCustom {

}
