package com.clbee.admin.userservice.api.role.dto;

import lombok.Getter;
import com.clbee.admin.common.dto.RequestDto;

import javax.validation.constraints.NotBlank;

/**
 * com.clbee.admin.userservice.api.role.dto.RoleAuthorizationListRequestDto
 * <p>
 * 권한 인가 목록 요청 DTO 클래스
 * 인가 목록 요청 DTO 클래스(com.clbee.admin.portalservice.api.authorization.dto.AuthorizationListRequestDto) 상속?
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
public class RoleAuthorizationListRequestDto extends RequestDto {

    /**
     * 권한 id
     */
    @NotBlank(message = "{role.roleId} {err.required}")
    private String roleId;

}
