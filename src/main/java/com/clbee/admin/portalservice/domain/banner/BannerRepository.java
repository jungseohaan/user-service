package com.clbee.admin.portalservice.domain.banner;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * com.clbee.admin.portalservice.domain.banner.BannerRepository
 * <p>
 * 배너 레파지토리 인터페이스
 *
 * @author seohan jung
 * @version 1.0
 * @since 2025/02/20
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *    수정일       수정자              수정내용
 *  ----------    --------    ---------------------------
 *  2025/02/20    seohan jung       최초 생성
 * </pre>
 */
public interface BannerRepository extends JpaRepository<Banner, Integer>, BannerRepositoryCustom {

}
