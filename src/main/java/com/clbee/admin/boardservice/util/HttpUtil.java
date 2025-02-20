package com.clbee.admin.boardservice.util;

import com.clbee.admin.common.domain.Role;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * com.clbee.admin.boardservice.util.HttpUtil
 * <p>
 * HTTP 관련 유틸 클래스
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
public class HttpUtil {

    /**
     * static method 만으로 구성된 유틸리티 클래스
     * 객체 생성 금지
     */
    private HttpUtil() throws IllegalStateException {
        throw new IllegalStateException("Http Utility Class");
    }

    /***
     * 관리자 권한 확인
     * @return boolean 관리자 여부
     */
    public static boolean isAdmin() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .anyMatch(r -> r.toString().equals(Role.ADMIN.getKey()));
    }

}
