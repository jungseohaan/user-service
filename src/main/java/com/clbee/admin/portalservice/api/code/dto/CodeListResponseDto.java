package com.clbee.admin.portalservice.api.code.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * com.clbee.admin.portalservice.api.code.dto.CodeListResponseDto
 * <p>
 * 공통코드 목록 조회 응답 dto
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
public class CodeListResponseDto {
    private String codeId; // 코드ID
    private String codeName; // 코드 명
    private String codeDescription; // 코드 설명
    private Boolean useAt; // 사용 여부
    private Boolean readonly; // 수정하면 안되는 읽기전용 공통코드
    private Long codeDetailCount; // 코드상세수
}
