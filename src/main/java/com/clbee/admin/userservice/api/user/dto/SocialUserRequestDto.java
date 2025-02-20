package com.clbee.admin.userservice.api.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * com.clbee.admin.userservice.api.user.dto.SocialUserRequestDto
 *
 * 소셜 사용자 요청 DTO 클래스
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
@Getter
@NoArgsConstructor
public class SocialUserRequestDto {

    /**
     * 공급자
     */
    private String provider;

    /**
     * 토큰
     */
    private String token;
}
