package org.egovframe.cloud.common.config;

/**
 * org.egovframe.cloud.common.config.Constants
 *
 * 공통 전역 상수 정의
 *
 * @author 표준프레임워크센터 jaeyeolkim
 * @version 1.0
 * @since 2021/07/19
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일        수정자           수정내용
 *  ----------    --------    ---------------------------
 *  2021/07/19    jaeyeolkim  최초 생성
 * </pre>
 */
public interface GlobalConstant {
    String HEADER_SITE_ID = "X-Site-Id"; // header에 어떤 사이트에서 보내는 요청인지 구분하기 위한 정보
    String AUTHORIZATION_URI = "/api/v1/authorizations/check";
    String REFRESH_TOKEN_URI = "/api/v1/users/token/refresh";
    String MESSAGES_URI = "/api/v1/messages/**";
    String LOGIN_URI = "/login";
    String USERS = "/api/v1/users";
    String ROLES = "/api/v1/roles";
    String USER = "/api/v1/users/**";
    String MENUS = "/api/v1/menus";
    String MENU = "/api/v1/menus/**";

    String[] SECURITY_PERMITALL_ANTPATTERNS = {
            MENUS, MENU, ROLES, USERS, USER,
            AUTHORIZATION_URI, REFRESH_TOKEN_URI, MESSAGES_URI, LOGIN_URI,
            "/actuator/**", "/v3/api-docs/**", "/api/v1/images/**", "/swagger-ui.html", "/webjars/**"};
}
