package com.clbee.admin.portalservice.domain.statistics;

import com.clbee.admin.portalservice.api.statistics.dto.StatisticsResponseDto;
import com.clbee.admin.portalservice.api.statistics.dto.StatisticsYMRequestDto;

import java.util.List;

/**
 * com.clbee.admin.portalservice.domain.statistics.StatisticsRepositoryCustom
 * <p>
 * 접속통계 Querydsl interface
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
public interface StatisticsRepositoryCustom {
    List<StatisticsResponseDto> findMonthBySiteId(Long siteId);
    List<StatisticsResponseDto> findDayBySiteId(Long siteId, StatisticsYMRequestDto requestDto);
}
