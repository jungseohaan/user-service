package com.clbee.admin.portalservice.service.code;

import lombok.RequiredArgsConstructor;
import com.clbee.admin.common.exception.EntityNotFoundException;
import com.clbee.admin.portalservice.api.code.dto.CodeDetailResponseDto;
import com.clbee.admin.portalservice.api.code.dto.CodeDetailSaveRequestDto;
import com.clbee.admin.portalservice.api.code.dto.CodeDetailUpdateRequestDto;
import com.clbee.admin.portalservice.domain.code.Code;
import com.clbee.admin.portalservice.domain.code.CodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.clbee.admin.portalservice.service.code.CodeDetailService
 * <p>
 * 공통코드 상세 CRUD 요청을 처리하는 Service
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
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CodeDetailService {
    private final CodeRepository codeRepository;

    /**
     * 단건 조회
     *
     * @param codeId
     * @return
     */
    public CodeDetailResponseDto findByCodeId(String codeId) {
        Code code = codeRepository.findByCodeId(codeId)
                .orElseThrow(() -> new EntityNotFoundException("해당 데이터가 존재하지 않습니다. ID =" + codeId));
        return new CodeDetailResponseDto(code);
    }

    /**
     * 등록
     *
     * @param saveRequestDto
     * @return
     */
    @Transactional
    public String save(CodeDetailSaveRequestDto saveRequestDto) {
        return codeRepository.save(saveRequestDto.toEntity()).getCodeId();
    }

    /**
     * 수정
     *
     * @param codeId
     * @param requestDto
     * @return
     */
    @Transactional
    public String update(String codeId, CodeDetailUpdateRequestDto requestDto) {
        Code code = codeRepository.findByCodeId(codeId)
                .orElseThrow(() -> new EntityNotFoundException("해당 데이터가 존재하지 않습니다. ID =" + codeId));

        code.updateDetail(requestDto.getParentCodeId(), requestDto.getCodeName(), requestDto.getCodeDescription(), requestDto.getSortSeq(), requestDto.getUseAt());

        return codeId;
    }

    /**
     * 삭제
     *
     * @param codeId
     */
    @Transactional
    public void delete(String codeId) {
        Code code = codeRepository.findByCodeId(codeId)
                .orElseThrow(() -> new EntityNotFoundException("해당 데이터가 존재하지 않습니다. ID =" + codeId));
        codeRepository.delete(code);
    }

    /**
     * 사용여부 toggle
     *
     * @param codeId
     * @param useAt
     * @return
     */
    @Transactional
    public String updateUseAt(String codeId, boolean useAt) {
        Code code = codeRepository.findByCodeId(codeId)
                .orElseThrow(() -> new EntityNotFoundException("해당 데이터가 존재하지 않습니다. ID =" + codeId));

        code.updateUseAt(useAt);

        return codeId;
    }
}
