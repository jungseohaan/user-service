package com.clbee.admin.portalservice.api.policy.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.clbee.admin.portalservice.domain.policy.Policy;

import java.time.ZonedDateTime;

/**
 * com.clbee.admin.portalservice.api.policy.dto.PolicyResponseDto
 * <p>
 * 이용약관/개인정보수집동의(Policy) 응답 dto
 *
 * @author 표준프레임워크센터 seohan jung
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
@NoArgsConstructor
@ToString
public class PolicyResponseDto {
    private Long id;
    private String type;
    private String title;
    private Boolean isUse;
    private ZonedDateTime regDate;
    private String contents;

    @Builder
    public PolicyResponseDto(Policy policy){
        this.id = policy.getId();
        this.type = policy.getType();
        this.title = policy.getTitle();
        this.isUse = policy.getIsUse();
        this.regDate = policy.getRegDate();
        this.contents = policy.getContents();
    }

}
