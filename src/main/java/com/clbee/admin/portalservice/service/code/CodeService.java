package com.clbee.admin.portalservice.service.code;

import lombok.RequiredArgsConstructor;
import com.clbee.admin.common.exception.BusinessException;
import com.clbee.admin.common.exception.BusinessMessageException;
import com.clbee.admin.common.exception.EntityNotFoundException;
import com.clbee.admin.common.exception.dto.ErrorCode;
import com.clbee.admin.common.service.AbstractService;
import com.clbee.admin.portalservice.api.code.dto.CodeResponseDto;
import com.clbee.admin.portalservice.api.code.dto.CodeSaveRequestDto;
import com.clbee.admin.portalservice.api.code.dto.CodeUpdateRequestDto;
import com.clbee.admin.portalservice.domain.code.Code;
import com.clbee.admin.portalservice.domain.code.CodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * com.clbee.admin.portalservice.service.code.CodeService
 * <p>
 * 공통코드 CRUD 요청을 처리하는 Service
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
public class CodeService extends AbstractService {
    private final CodeRepository codeRepository;

    /**
     * 단건 조회
     *
     * @param codeId
     * @return
     */
    public CodeResponseDto findByCodeId(String codeId) throws EntityNotFoundException {
        Code code = codeRepository.findByCodeId(codeId)
                .orElseThrow(() -> new EntityNotFoundException("해당 데이터가 존재하지 않습니다. ID =" + codeId));
        return new CodeResponseDto(code);
    }

    /**
     * 등록
     *
     * @param saveRequestDto
     * @return
     */
    @Transactional
    public String save(CodeSaveRequestDto saveRequestDto) throws BusinessException {
        Optional<Code> byCodeId = codeRepository.findByCodeId(saveRequestDto.getCodeId());
        if (byCodeId.isPresent()) {
            throw new BusinessException("코드ID 중복 : " + byCodeId, ErrorCode.DUPLICATE_INPUT_INVALID);
        }
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
    public String update(String codeId, CodeUpdateRequestDto requestDto) throws EntityNotFoundException {
        Code code = codeRepository.findByCodeId(codeId)
                .orElseThrow(() -> new EntityNotFoundException("해당 데이터가 존재하지 않습니다. ID =" + codeId));

        code.update(requestDto.getCodeName(), requestDto.getCodeDescription(), requestDto.getSortSeq(), requestDto.getUseAt());

        return codeId;
    }

    /**
     * 삭제 - parentCodeId 에서 참조하지 않는 경우에만 삭제할 수 있다
     *
     * @param codeId
     */
    @Transactional
    public void delete(String codeId) throws BusinessMessageException {
        Code code = codeRepository.findByCodeId(codeId)
                .orElseThrow(() -> new EntityNotFoundException("해당 데이터가 존재하지 않습니다. ID =" + codeId));

        long parentCount = codeRepository.countByParentCodeId(codeId);
        if (parentCount > 0) {
            // 참조하는 데이터가 있어 삭제할 수 없습니다
            throw new BusinessMessageException(getMessage("err.db.constraint.delete"));
        }

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
    public String updateUseAt(String codeId, boolean useAt) throws EntityNotFoundException {
        Code code = codeRepository.findByCodeId(codeId)
                .orElseThrow(() -> new EntityNotFoundException("해당 데이터가 존재하지 않습니다. ID =" + codeId));

        code.updateUseAt(useAt);

        return codeId;
    }
}
