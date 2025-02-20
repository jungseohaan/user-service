package com.clbee.admin.userservice.api.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * com.clbee.admin.userservice.api.user.dto.UserVerifyRequestDto
 *
 * 사용자 검증 요청 DTO 클래스
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
public class UserVerifyRequestDto {

    /**
     * 비밀번호
     */
    @Pattern(regexp = "((?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20})|()", message = "{valid.password}") // (숫자)(영문)(특수문자)(공백제거)(자리수)
    private String password;

    /**
     * 공급자
     */
    @NotBlank(message = "{common.provider}{valid.required}")
    private String provider;

    /**
     * 토큰
     */
    private String token;

}
