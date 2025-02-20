package com.clbee.admin.portalservice.domain.content;

import com.clbee.admin.common.dto.RequestDto;
import com.clbee.admin.portalservice.api.content.dto.ContentListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * com.clbee.admin.portalservice.domain.content.ContentRepositoryCustom
 * <p>
 * 컨텐츠 Querydsl 인터페이스
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
 *  2025/02/20    seohan jung       최초 생성
 * </pre>
 */
public interface ContentRepositoryCustom {

    /**
     * 컨텐츠 페이지 목록 조회
     *
     * @param requestDto 컨텐츠 목록 요청 DTO
     * @param pageable   페이지 정보
     * @return Page<ContentListResponseDto> 페이지 컨텐츠 목록 응답 DTO
     */
    Page<ContentListResponseDto> findPage(RequestDto requestDto, Pageable pageable);

}
