package com.clbee.admin.userservice.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

/**
 * com.clbee.admin.userservice.util.RestResponsePage
 * <p>
 * 페이지 API 조회 시 JSON 형식의 응답 데이터를 페이지 객체를 구현하여 마이그레이션 해주는 클래스
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
public class RestResponsePage<T> extends PageImpl<T> {

    /**
     * 
     */
    private static final long serialVersionUID = -5737360124251098346L;

	/**
     * Rest 응답 페이지 생성자
     *
     * @param content          목록
     * @param number           페이지 번호
     * @param size             조회할 데이터 수
     * @param totalElements    총 데이터 수
     * @param pageable         페이지 정보
     * @param last             마지막
     * @param totalPages       총 페이지
     * @param sort             정렬
     * @param first            처음
     * @param numberOfElements 조회된 데이터 수
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RestResponsePage(@JsonProperty("content") List<T> content,
                            @JsonProperty("number") int number,
                            @JsonProperty("size") int size,
                            @JsonProperty("totalElements") Long totalElements,
                            @JsonProperty("pageable") JsonNode pageable,
                            @JsonProperty("last") boolean last,
                            @JsonProperty("totalPages") int totalPages,
                            @JsonProperty("sort") JsonNode sort,
                            @JsonProperty("first") boolean first,
                            @JsonProperty("numberOfElements") int numberOfElements) {
        super(content, PageRequest.of(number, size), totalElements);
    }

    /**
     * Rest 응답 페이지 생성자
     *
     * @param content  목록
     * @param pageable 페이지 정보
     * @param total    총 데이터 수
     */
    public RestResponsePage(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    /**
     * Rest 응답 페이지 생성자
     *
     * @param content 목록
     */
    public RestResponsePage(List<T> content) {
        super(content);
    }

    /**
     * Rest 응답 페이지 생성자
     */
    public RestResponsePage() {
        super(Collections.emptyList());
    }

}
