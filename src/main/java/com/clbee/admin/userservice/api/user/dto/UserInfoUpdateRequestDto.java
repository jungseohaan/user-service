package com.clbee.admin.userservice.api.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * com.clbee.admin.userservice.api.user.dto.UserInfoUpdateRequestDto
 *
 * 사용자 정보 수정 요청 DTO 클래스
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
public class UserInfoUpdateRequestDto {

    /**
     * 이메일
     */
    @NotBlank(message = "{user.email}{valid.required}")
    @Email
    private String email;

    /**
     * 사용자 명
     */
    @NotBlank(message = "{user.user_name}{valid.required}")
    private String userName;

}
