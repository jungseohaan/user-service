package com.clbee.admin.userservice.domain.user;

/**
 * com.clbee.admin.userservice.domain.user.UserFindPasswordRepositoryCustom
 * <p>
 * 사용자 비밀번호 찾기 Querydsl 인터페이스
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
public interface UserFindPasswordRepositoryCustom {

    /**
     * 다음 요청 번호 조회
     *
     * @param emailAddr 이메일 주소
     * @return Integer 다음 요청 번호
     */
    Integer findNextRequestNo(String emailAddr);

}
