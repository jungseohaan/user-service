package com.clbee.admin.userservice.api.user.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import com.clbee.admin.common.domain.Role;
import com.clbee.admin.userservice.domain.user.User;
import com.clbee.admin.userservice.domain.user.UserStateCode;

import java.time.LocalDateTime;

/**
 * com.clbee.admin.userservice.api.user.dto.UserListResponseDto
 * <p>
 * 사용자 목록 요청시 사용되는 필요한 정보만 담긴 DTO
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
public class UserListResponseDto {
    private String userId;
    private String userName;
    private String email;
    private String roleId;
    private String roleName;
    private String userStateCode;
    private String userStateCodeName;
    private LocalDateTime lastLoginDate;
    private Integer loginFailCount;

    /**
     * UserListResponseDto 는 Entity의 필드 중 일부만 사용하므로 생성자로 Entity를 받아 필드에 값을 넣는다.
     * 굳이 모든 필드를 가진 생성자가 필요하지 않다.
     *
     * @param entity
     */
    public UserListResponseDto(User entity) {
        this.userId = entity.getUserId();
        this.userName = entity.getUserName();
        this.email = entity.getEmail();
    }

    /**
     * 사용자 목록 응답 DTO 생성자
     *
     * @param userId         사용자 id
     * @param userName       사용자 명
     * @param email          이메일 주소
     * @param role           권한
     * @param userStateCode  사용자 상태 코드
     * @param lastLoginDate  마지막 로그인 일시
     * @param loginFailCount 로그인 실패 수
     */
    @QueryProjection
    public UserListResponseDto(String userId, String userName, String email, Role role, String userStateCode, LocalDateTime lastLoginDate, Integer loginFailCount) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.roleId = role.getKey();
        this.roleName = role.getTitle();
        UserStateCode usc = UserStateCode.findByKey(userStateCode);
        this.userStateCode = usc.getKey();
        this.userStateCodeName = usc.getTitle();
        this.lastLoginDate = lastLoginDate;
        this.loginFailCount = loginFailCount;
    }

}
