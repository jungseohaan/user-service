package com.clbee.admin.userservice.api.role.dto;

import lombok.Getter;
import com.clbee.admin.userservice.domain.role.Authorization;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * com.clbee.admin.userservice.api.role.dto.AuthorizationSaveRequestDto
 * <p>
 * 인가 등록 요청 DTO 클래스
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
public class AuthorizationSaveRequestDto {

    /**
     * 인가 명
     */
    @NotBlank(message = "{authorization.authorizationName} {err.required}")
    private String authorizationName;

    /**
     * URL 패턴 값
     */
    @NotBlank(message = "{authorization.urlPatternValue} {err.required}")
    private String urlPatternValue;

    /**
     * Http Method 코드
     */
    @NotBlank(message = "{authorization.httpMethodCode} {err.required}")
    private String httpMethodCode;

    /**
     * 정렬 순서
     */
    @NotNull(message = "{authorization.sortSeq} {err.required}")
    private Integer sortSeq;

    /**
     * 인가 등록 요청 DTO 속성 값으로 인가 엔티티 빌더를 사용하여 객체 생성
     *
     * @return Authorization 인가 엔티티
     */
    public Authorization toEntity() {
        return Authorization.builder()
                .authorizationName(authorizationName)
                .urlPatternValue(urlPatternValue)
                .httpMethodCode(httpMethodCode)
                .sortSeq(sortSeq)
                .build();
    }

}
