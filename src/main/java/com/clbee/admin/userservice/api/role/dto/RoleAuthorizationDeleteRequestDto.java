package com.clbee.admin.userservice.api.role.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.clbee.admin.userservice.domain.role.RoleAuthorization;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * com.clbee.admin.userservice.api.role.dto.RoleAuthorizationDeleteRequestDto
 * <p>
 * 권한 인가 삭제 요청 DTO 클래스
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
@Getter
@NoArgsConstructor
public class RoleAuthorizationDeleteRequestDto {

    /**
     * 권한 id
     */
    @NotBlank(message = "{role.roleId} {err.required}")
    private String roleId;

    /**
     * 인가 번호
     */
    @NotNull(message = "{authorization.authorizationNo} {err.required}")
    private Integer authorizationNo;

    /**
     * 권한 인가 삭제 요청 DTO 클래스 생성자
     * 빌더 패턴으로 객체 생성
     *
     * @param roleId          권한 id
     * @param authorizationNo 인가 번호
     */
    @Builder
    public RoleAuthorizationDeleteRequestDto(String roleId, Integer authorizationNo) {
        this.roleId = roleId;
        this.authorizationNo = authorizationNo;
    }

    /**
     * 권한 인가 삭제 DTO 속성 값으로 권한 인가 엔티티 빌더를 사용하여 객체 생성
     *
     * @return RoleAuthorization 권한 인가 엔티티
     */
    public RoleAuthorization toEntity() {
        return RoleAuthorization.builder()
                .roleId(roleId)
                .authorizationNo(authorizationNo)
                .build();
    }

}
