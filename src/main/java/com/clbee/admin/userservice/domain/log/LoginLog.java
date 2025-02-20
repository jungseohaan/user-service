package com.clbee.admin.userservice.domain.log;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.clbee.admin.servlet.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * com.clbee.admin.userservice.domain.log.LoginLog
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
public class LoginLog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "log_id")
    private Long id;

    private Long siteId;

    @Column(name = "email_addr", length = 100)
    private String email;

    @Column(name = "ip_addr", length = 100)
    private String remoteIp;

    private Boolean successAt;

    @Column(name = "fail_content", length = 200)
    private String failContent;

    @Builder
    public LoginLog(Long siteId, String email, Boolean successAt, String remoteIp, String failContent) {
        this.siteId = siteId;
        this.email = email;
        this.successAt = successAt;
        this.remoteIp = remoteIp;
        this.failContent = failContent;
    }
}
