package com.clbee.admin.portalservice.domain.policy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long>, PolicyRepositoryCustom {
}
