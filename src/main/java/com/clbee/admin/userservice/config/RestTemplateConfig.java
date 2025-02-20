package com.clbee.admin.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * com.clbee.admin.userservice.config.RestTemplateConfig
 *
 * REST Template 설정 클래스
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
@Configuration
public class RestTemplateConfig {

    /**
     * REST Template 빈 등록
     *
     * @return RestTemplate REST Template
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
