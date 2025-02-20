package com.clbee.admin.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * com.clbee.admin.common.dto.RequestDto
 * <p>
 * 공통 조회조건 요청 파라미터 dto
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
@Getter
@NoArgsConstructor
@SuperBuilder
public class RequestDto {
    private String keywordType; // 검색조건
    private String keyword; // 검색어
}
