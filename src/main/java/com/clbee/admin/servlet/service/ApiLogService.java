package com.clbee.admin.servlet.service;

import lombok.extern.slf4j.Slf4j;
import com.clbee.admin.servlet.domain.log.ApiLog;
import com.clbee.admin.common.service.AbstractService;
import com.clbee.admin.servlet.domain.log.ApiLogRepository;
import com.clbee.admin.common.util.LogUtil;
import com.clbee.admin.servlet.interceptor.ApiLogInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * com.clbee.admin.servlet.service.ApiLogService
 * <p>
 * API Log 처리 서비스
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
@Slf4j
@Service
public class ApiLogService extends AbstractService {

    private final ApiLogRepository apiLogRepository;

    public ApiLogService(ApiLogRepository apiLogRepository) {
        this.apiLogRepository = apiLogRepository;
    }

    /**
     * API log 입력
     * LogInterceptor 에서 호출된다
     *
     * @param request
     * @see ApiLogInterceptor
     */
    @Transactional
    public void saveApiLog(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        apiLogRepository.save(
                ApiLog.builder()
                        .siteId(LogUtil.getSiteId(request))
                        .httpMethod(request.getMethod())
                        .requestUrl(request.getRequestURI())
                        .userId(authentication.getName())
                        .remoteIp(LogUtil.getUserIp())
                        .build()
        );
    }
}
