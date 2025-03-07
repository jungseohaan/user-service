package com.clbee.admin.portalservice.domain.privacy;

import com.clbee.admin.common.dto.RequestDto;
import com.clbee.admin.portalservice.api.privacy.dto.PrivacyListResponseDto;
import com.clbee.admin.portalservice.api.privacy.dto.PrivacyResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * com.clbee.admin.portalservice.domain.privacy.PrivacyRepositoryCustom
 * <p>
 * 개인정보처리방침 Querydsl 인터페이스
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
public interface PrivacyRepositoryCustom {

    /**
     * 개인정보처리방침 페이지 목록 조회
     *
     * @param requestDto 개인정보처리방침 목록 요청 DTO
     * @param pageable   페이지 정보
     * @return Page<PrivacyListResponseDto> 페이지 개인정보처리방침 목록 응답 DTO
     */
    Page<PrivacyListResponseDto> findPage(RequestDto requestDto, Pageable pageable);

    /**
     * 사용여부로 개인정보처리방침 내림차순 전체 목록 조회
     *
     * @param useAt 사용 여부
     * @return List<PrivacyResponseDto> 개인정보처리방침 상세 응답 DTO
     */
    List<PrivacyResponseDto> findAllByUseAt(Boolean useAt);

}
