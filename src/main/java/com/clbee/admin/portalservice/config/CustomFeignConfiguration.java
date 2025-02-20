package com.clbee.admin.portalservice.config;

import feign.Logger;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import com.clbee.admin.portalservice.client.decoder.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;

/**
 * com.clbee.admin.portalservice.config.CustomFeignConfiguration
 * <p>
 *  feign client custom 설정 클래스
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
public class CustomFeignConfiguration {

    /**
     * log level 설정
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    /**
     * 에러 핸들링
     *
     * @return
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    /**
     * retryer 설정
     *
     * @return
     */
    @Bean
    public Retryer retryer() {
        return new Retryer.Default();
    }

}
