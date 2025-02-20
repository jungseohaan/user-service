package com.clbee.admin.portalservice.domain.policy;

import com.clbee.admin.common.dto.RequestDto;
import com.clbee.admin.portalservice.api.policy.dto.PolicyResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PolicyRepositoryCustom {
    Page<PolicyResponseDto> search(RequestDto requestDto, Pageable pageable);
    PolicyResponseDto searchOne(String type);
}
