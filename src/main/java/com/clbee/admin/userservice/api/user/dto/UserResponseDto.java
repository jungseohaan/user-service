package com.clbee.admin.userservice.api.user.dto;

import lombok.Getter;
import com.clbee.admin.userservice.domain.user.User;

/**
 * com.clbee.admin.userservice.api.user.dto.UserResponseDto
 * <p>
 * 사용자 정보 요청시 사용되는 필요한 정보만 담긴 DTO
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
public class UserResponseDto {

    private String userId;
    private String userName;
    private String email;
    private String roleId;
    private String userStateCode;
    private String googleId;
    private String kakaoId;
    private String naverId;
    private Boolean isSocialUser;
    private Boolean hasPassword;

    /**
     * UserResponseDto는 Entity의 필드 중 일부만 사용하므로 생성자로 Entity를 받아 필드에 값을 넣는다.
     * 굳이 모든 필드를 가진 생성자가 필요하지 않다.
     *
     * @param entity
     */
    public UserResponseDto(User entity) {
        this.userId = entity.getUserId();
        this.userName = entity.getUserName();
        this.email = entity.getEmail();
        this.roleId = entity.getRoleKey();
        this.userStateCode = entity.getUserStateCode();
        this.googleId = entity.getGoogleId();
        this.kakaoId = entity.getKakaoId();
        this.naverId = entity.getNaverId();
        this.isSocialUser = entity.isSocialUser();
        this.hasPassword = entity.getEncryptedPassword() != null && !"".equals(entity.getEncryptedPassword());
    }
}
