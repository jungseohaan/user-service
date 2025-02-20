package com.clbee.admin.userservice.api.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import com.clbee.admin.userservice.domain.user.UserFindPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * com.clbee.admin.userservice.api.user.dto.UserFindPasswordSaveRequestDto
 *
 * 사용자 비밀번호 찾기 등록 요청 DTO 클래스
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
public class UserFindPasswordSaveRequestDto {

    /**
     * 사용자 명
     */
    @NotBlank(message = "{user.user_name}{valid.required}")
    private String userName;

    /**
     * 이메일 주소
     */
    @NotBlank(message = "{user.email}{valid.required}")
    @Email
    private String emailAddr;

    /**
     * 메인 주소
     */
    @NotBlank
    private String mainUrl;

    /**
     * 비밀번호 변경 주소
     */
    @NotBlank
    private String changePasswordUrl;

    /**
     * 사용자 비밀번호 찾기 등록 요청 DTO 속성 값으로 개인정보처리방침 엔티티 빌더를 사용하여 객체 생성
     *
     * @return UserFindPassword 사용자 비밀번호 찾기 엔티티
     */
    public UserFindPassword toEntity(Integer requestNo, String tokenValue) {
        return UserFindPassword.builder()
                .emailAddr(emailAddr)
                .requestNo(requestNo)
                .tokenValue(tokenValue)
                .build();
    }

}
