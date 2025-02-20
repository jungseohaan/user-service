package com.clbee.admin.portalservice.service.policy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.clbee.admin.common.dto.RequestDto;
import com.clbee.admin.common.exception.EntityNotFoundException;
import com.clbee.admin.common.service.AbstractService;
import com.clbee.admin.portalservice.api.policy.dto.PolicyResponseDto;
import com.clbee.admin.portalservice.api.policy.dto.PolicySaveRequestDto;
import com.clbee.admin.portalservice.api.policy.dto.PolicyUpdateRequestDto;
import com.clbee.admin.portalservice.domain.policy.Policy;
import com.clbee.admin.portalservice.domain.policy.PolicyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.clbee.admin.portalservice.service.policy.PolicyService
 * <p>
 * 이용약관/개인정보수집동의(Policy) service class
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
@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PolicyService extends AbstractService {
    private final PolicyRepository policyRepository;

    /**
     * 목록 조회
     *
     * @param requestDto
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    public Page<PolicyResponseDto> search(RequestDto requestDto, Pageable pageable){
        return policyRepository.search(requestDto, pageable);
    }

    /**
     * 회원가입시 가장 최근에 등록한 한건 조회
     *
     * @param type
     * @return
     */
    @Transactional(readOnly = true)
    public PolicyResponseDto searchOne(String type) {
        return policyRepository.searchOne(type);
    }

    /**
     * 단건 조회
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public PolicyResponseDto findById(Long id) {
        Policy policy = findPolicy(id);
        return new PolicyResponseDto(policy);
    }

    /**
     * 등록
     *
     * @param saveRequestDto
     * @return
     */
    public Long save(PolicySaveRequestDto saveRequestDto) {
        return policyRepository.save(saveRequestDto.toEntity()).getId();
    }

    /**
     * 수정
     *
     * @param id
     * @param updateRequestDto
     * @return
     */
    public Long update(Long id, PolicyUpdateRequestDto updateRequestDto) {
        Policy policy = findPolicy(id);

        policy.update(updateRequestDto.getTitle(), updateRequestDto.getIsUse(), updateRequestDto.getContents());

        return id;
    }

    /**
     * 삭제
     *
     * @param id
     */
    public void delete(Long id) {
        Policy policy = findPolicy(id);
        policyRepository.delete(policy);
    }

    /**
     * 사용여부 toggle
     *
     * @param id
     * @param isUse
     * @return
     */
    public Long updateIsUse(Long id, boolean isUse) {
        Policy policy = findPolicy(id);

        policy.updateIsUSe(isUse);

        return id;
    }

    private Policy findPolicy(Long id) {
        return policyRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(getMessage("valid.notexists.format", new Object[]{getMessage("policy")}) + " ID= " + id));
    }



}
