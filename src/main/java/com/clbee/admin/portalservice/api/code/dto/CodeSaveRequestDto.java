package com.clbee.admin.portalservice.api.code.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.clbee.admin.portalservice.domain.code.Code;

import javax.validation.constraints.NotBlank;

/**
 * com.clbee.admin.portalservice.api.code.dto.CodeSaveRequestDto
 * <p>
 * 공통코드 등록 요청 dto
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
@NoArgsConstructor
public class CodeSaveRequestDto {
    @NotBlank(message = "{code.code_id}{valid.required}")
    private String codeId; // 코드ID
    @NotBlank(message = "{code.code_name}{valid.required}")
    private String codeName; // 코드 명
    private String codeDescription; // 코드 설명
    private Integer sortSeq; // 정렬 순서
    private Boolean useAt; // 사용 여부
    private Boolean readonly; // 수정하면 안되는 읽기전용 공통코드

    @Builder
    public CodeSaveRequestDto(String codeId, String codeName, String codeDescription, Integer sortSeq, Boolean useAt, Boolean readonly) {
        this.codeId = codeId;
        this.codeName = codeName;
        this.codeDescription = codeDescription;
        this.sortSeq = sortSeq;
        this.useAt = useAt;
        this.readonly = readonly;
    }

    /**
     * SaveRequestDto 의 필드 값을 Entity 빌더를 사용하여 주입 후 Entity 를 리턴한다.
     * SaveRequestDto 가 가지고 있는 Entity 의 필드만 세팅할 수 있게 된다.
     *
     * @return
     */
    public Code toEntity() {
        return Code.builder()
                .codeId(codeId)
                .codeName(codeName)
                .codeDescription(codeDescription)
                .useAt(useAt)
                .sortSeq(sortSeq)
                .readonly(readonly != null && readonly) // readonly 값이 없으면 기본값은 false 로 설정한다
                .build();
    }
}
