package com.clbee.admin.servlet.domain.log;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.clbee.admin.servlet.domain.BaseTimeEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * com.clbee.admin.servlet.domain.log.LoginLog
 * <p>
 * 로그인 로그 엔티티
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
@Getter
@NoArgsConstructor
@Entity
public class ApiLog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "log_id")
    private Long id;

    private Long siteId;

    private String userId;

    @Column(length = 10)
    private String httpMethod;

    @Column(length = 500)
    private String requestUrl;

    @Column(name = "ip_addr", length = 100)
    private String remoteIp;

    @Builder
    public ApiLog(Long siteId, String userId, String httpMethod, String requestUrl, String remoteIp) {
        this.siteId = siteId;
        this.userId = userId;
        this.httpMethod = httpMethod;
        this.requestUrl = requestUrl;
        this.remoteIp = remoteIp;
    }
}
