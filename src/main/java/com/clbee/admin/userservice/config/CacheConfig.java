package com.clbee.admin.userservice.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * com.clbee.admin.userservice.config.CacheConfig
 *
 * 캐시 설정 클래스
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
@Configuration
@EnableCaching
@EnableAspectJAutoProxy(exposeProxy=true) // AopContext.currentProxy() 사용 옵션
public class CacheConfig {
}
