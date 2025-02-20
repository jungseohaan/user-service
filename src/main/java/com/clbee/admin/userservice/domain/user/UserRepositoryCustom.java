package com.clbee.admin.userservice.domain.user;

import com.clbee.admin.common.dto.RequestDto;
import com.clbee.admin.userservice.api.user.dto.UserListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * com.clbee.admin.userservice.domain.user.UserRepositoryCustom
 * <p>
 * 사용자 Querydsl 인터페이스
 *
 * @author seohan jung
 * @version 1.0
 * @since 2025/02/20
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *    수정일       수정자              수정내용
 *  ----------    --------    ---------------------------
 *  2025/02/20    seohan jung       최초 생성
 * </pre>
 */
public interface UserRepositoryCustom {

    /**
     * 사용자 페이지 목록 조회
     *
     * @param requestDto 사용자 목록 요청 DTO
     * @param pageable   페이지 정보
     * @return Page<UserListResponseDto> 페이지 사용자 목록 응답 DTO
     */
    Page<UserListResponseDto> findPage(RequestDto requestDto, Pageable pageable);

}
