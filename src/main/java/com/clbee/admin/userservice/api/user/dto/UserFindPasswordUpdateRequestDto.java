package com.clbee.admin.userservice.api.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * com.clbee.admin.userservice.api.user.dto.UserFindPasswordUpdateRequestDto
 *
 * 사용자 비밀번호 찾기 수정 요청 DTO 클래스
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
public class UserFindPasswordUpdateRequestDto {

    /**
     * 토큰 값
     */
    @NotBlank(message = "{common.token}{valid.required}")
    private String tokenValue;

    /**
     * 비밀번호
     */
    @NotBlank(message = "{user.password}{valid.required}")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}", message = "{valid.password}") // (숫자)(영문)(특수문자)(공백제거)(자리수)
    private String password;

}
