package com.clbee.admin.userservice.service.role;

import lombok.RequiredArgsConstructor;
import com.clbee.admin.common.dto.RequestDto;
import com.clbee.admin.common.service.AbstractService;
import com.clbee.admin.userservice.api.role.dto.RoleListResponseDto;
import com.clbee.admin.userservice.domain.role.RoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * com.clbee.admin.userservice.service.role.RoleService
 * <p>
 * 권한 서비스 클래스
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
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class RoleService extends AbstractService {

    /**
     * 권한 레파지토리 인터페이스
     */
    private final RoleRepository roleRepository;

    /**
     * 조회 조건에 일치하는 권한 페이지 목록 조회
     *
     * @param requestDto 요청 DTO
     * @param pageable   페이지 정보
     * @return Page<RoleListResponseDto> 페이지 권한 목록 응답 DTO
     */
    public Page<RoleListResponseDto> findPage(RequestDto requestDto, Pageable pageable) {
        return roleRepository.findPage(requestDto, pageable);
    }

    /**
     * 권한 전체 조회
     *
     * @param sort 정렬
     * @return List<RoleListResponseDto> 권한 목록 응답 DTO
     */
    public List<RoleListResponseDto> findAllBySort(Sort sort) {
        return roleRepository.findAll(sort).stream()
                .map(m -> RoleListResponseDto.builder()
                        .roleId(m.getRoleId())
                        .roleName(m.getRoleName())
                        .roleContent(m.getRoleContent())
                        .createdDate(m.getCreatedDate())
                        .build())
                .collect(Collectors.toList());
    }

}
