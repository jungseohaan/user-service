package com.clbee.admin.portalservice.api.code;

import lombok.RequiredArgsConstructor;
import com.clbee.admin.common.dto.RequestDto;
import com.clbee.admin.portalservice.api.code.dto.CodeListResponseDto;
import com.clbee.admin.portalservice.api.code.dto.CodeResponseDto;
import com.clbee.admin.portalservice.api.code.dto.CodeSaveRequestDto;
import com.clbee.admin.portalservice.api.code.dto.CodeUpdateRequestDto;
import com.clbee.admin.portalservice.domain.code.CodeRepository;
import com.clbee.admin.portalservice.service.code.CodeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * com.clbee.admin.portalservice.api.code.CodeApiController
 * <p>
 * 공통코드 CRUD 요청을 처리하는 REST API Controller
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
@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성하여, 빈을 생성자로 주입받게 한다.
@RestController
public class CodeApiController {

    private final CodeService codeService;
    private final CodeRepository codeRepository;

    /**
     * 공통코드 목록 조회
     *
     * @param requestDto
     * @param pageable
     * @return
     */
    @GetMapping("/api/v1/codes")
    public Page<CodeListResponseDto> findAllByKeyword(RequestDto requestDto, Pageable pageable) {
        return codeRepository.findAllByKeyword(requestDto, pageable);
    }

    /**
     * 공통코드 목록 - parentCodeId 가 없는 상위공통코드
     *
     * @return
     */
    @GetMapping("/api/v1/codes-parent")
    public List<CodeResponseDto> findAllParent() {
        return codeRepository.findAllParent();
    }

    /**
     * 공통코드 단건 조회
     *
     * @param codeId
     * @return
     */
    @GetMapping("/api/v1/codes/{codeId}")
    public CodeResponseDto findByCodeId(@PathVariable String codeId) {
        return codeService.findByCodeId(codeId);
    }

    /**
     * 공통코드 등록
     *
     * @param requestDto
     * @return
     */
    @PostMapping("/api/v1/codes")
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody @Valid CodeSaveRequestDto requestDto) {
        return codeService.save(requestDto);
    }

    /**
     * 공통코드 수정
     *
     * @param codeId
     * @param requestDto
     * @return
     */
    @PutMapping("/api/v1/codes/{codeId}")
    public String update(@PathVariable String codeId, @RequestBody CodeUpdateRequestDto requestDto) {
        return codeService.update(codeId, requestDto);
    }

    /**
     * 사용여부 toggle
     *
     * @param codeId
     * @param useAt
     * @return
     */
    @PutMapping("/api/v1/codes/{codeId}/toggle-use")
    public String updateUseAt(@PathVariable String codeId, @RequestParam boolean useAt) {
        return codeService.updateUseAt(codeId, useAt);
    }

    /**
     * 공통코드 삭제
     *
     * @param codeId
     */
    @DeleteMapping("/api/v1/codes/{codeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String codeId) {
        codeService.delete(codeId);
    }

}
