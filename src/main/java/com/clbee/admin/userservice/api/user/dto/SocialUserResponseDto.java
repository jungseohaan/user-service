package com.clbee.admin.userservice.api.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * com.clbee.admin.userservice.api.user.dto.SocialUserResponseDto
 * <p>
 * 소셜 사용자 응답 DTO 클래스
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
public class SocialUserResponseDto {

    /**
     * 아이디
     */
    private String id;

    /**
     * 이메일
     */
    private String email;

    /**
     * 이름
     */
    private String name;

    /**
     * 소셜 사용자 DTO 클래스 생성자
     * 빌더 패턴으로 객체 생성
     *
     * @param id    아이디
     * @param email 이메일
     * @param name  이름
     */
    @Builder
    public SocialUserResponseDto(String id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

}
