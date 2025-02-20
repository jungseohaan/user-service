package com.clbee.admin.userservice.api.role;

import lombok.RequiredArgsConstructor;
import com.clbee.admin.userservice.api.role.dto.RoleAuthorizationDeleteRequestDto;
import com.clbee.admin.userservice.api.role.dto.RoleAuthorizationListRequestDto;
import com.clbee.admin.userservice.api.role.dto.RoleAuthorizationListResponseDto;
import com.clbee.admin.userservice.api.role.dto.RoleAuthorizationSaveRequestDto;
import com.clbee.admin.userservice.service.role.RoleAuthorizationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * com.clbee.admin.userservice.api.role.RoleAuthorizationApiController
 * <p>
 * 권한 인가 Rest API 컨트롤러 클래스
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
@RequiredArgsConstructor
@RestController
public class RoleAuthorizationApiController {

    /**
     * 권한 인가 서비스
     */
    private final RoleAuthorizationService roleAuthorizationService;

    /**
     * 권한 인가 페이지 목록 조회
     *
     * @param requestDto 요청 DTO
     * @param pageable 페이지 정보
     * @return Page<RoleAuthorizationListResponseDto> 페이지 권한 인가 목록 응답 DTO
     */
    @GetMapping("/api/v1/role-authorizations")
    public Page<RoleAuthorizationListResponseDto> findPageAuthorizationList(@Valid RoleAuthorizationListRequestDto requestDto,
                                                                            Pageable pageable) {
        return roleAuthorizationService.findPageAuthorizationList(requestDto, pageable);
    }

    /**
     * 권한 인가 다건 등록
     *
     * @param requestDtoList 권한 인가 등록 요청 DTO List
     * @return List<RoleAuthorizationListResponseDto> 등록한 권한 인가 목록 응답 DTO
     */
    @PostMapping("/api/v1/role-authorizations")
    @ResponseStatus(HttpStatus.CREATED)
    public List<RoleAuthorizationListResponseDto> save(@RequestBody @Valid List<RoleAuthorizationSaveRequestDto> requestDtoList) {
        return roleAuthorizationService.save(requestDtoList);
    }

    /**
     * 권한 인가 다건 삭제
     *
     * @param requestDtoList 권한 인가 삭제 요청 DTO List
     */
    @PutMapping("/api/v1/role-authorizations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody @Valid List<RoleAuthorizationDeleteRequestDto> requestDtoList) {
        roleAuthorizationService.delete(requestDtoList);
    }

}
