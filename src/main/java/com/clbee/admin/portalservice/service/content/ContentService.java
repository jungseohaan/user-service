package com.clbee.admin.portalservice.service.content;

import lombok.RequiredArgsConstructor;
import com.clbee.admin.common.dto.RequestDto;
import com.clbee.admin.common.exception.EntityNotFoundException;
import com.clbee.admin.common.service.AbstractService;
import com.clbee.admin.portalservice.api.content.dto.ContentListResponseDto;
import com.clbee.admin.portalservice.api.content.dto.ContentResponseDto;
import com.clbee.admin.portalservice.api.content.dto.ContentSaveRequestDto;
import com.clbee.admin.portalservice.api.content.dto.ContentUpdateRequestDto;
import com.clbee.admin.portalservice.domain.content.Content;
import com.clbee.admin.portalservice.domain.content.ContentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.clbee.admin.portalservice.service.content.ContentService
 * <p>
 * 컨텐츠 서비스 클래스
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
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ContentService extends AbstractService {

    /**
     * 컨텐츠 레파지토리 인터페이스
     */
    private final ContentRepository contentRepository;

    /**
     * 조회 조건에 일치하는 컨텐츠 페이지 목록 조회
     *
     * @param requestDto 요청 DTO
     * @param pageable   페이지 정보
     * @return Page<ContentListResponseDto> 페이지 컨텐츠 목록 응답 DTO
     */
    public Page<ContentListResponseDto> findPage(RequestDto requestDto, Pageable pageable) {
        return contentRepository.findPage(requestDto, pageable);
    }

    /**
     * 컨텐츠 단건 조회
     *
     * @param contentNo 컨텐츠 번호
     * @return ContentResponseDto 컨텐츠 응답 DTO
     */
    public ContentResponseDto findById(Integer contentNo) {
        Content entity = findContent(contentNo);

        return new ContentResponseDto(entity);
    }

    /**
     * 컨텐츠 등록
     *
     * @param requestDto 컨텐츠 등록 요청 DTO
     * @return ContentResponseDto 컨텐츠 응답 DTO
     */
    @Transactional
    public ContentResponseDto save(ContentSaveRequestDto requestDto) {
        Content entity = contentRepository.save(requestDto.toEntity());

        return new ContentResponseDto(entity);
    }

    /**
     * 컨텐츠 수정
     *
     * @param contentNo  컨텐츠 번호
     * @param requestDto 컨텐츠 수정 요청 DTO
     * @return ContentResponseDto 컨텐츠 응답 DTO
     */
    @Transactional
    public ContentResponseDto update(Integer contentNo, ContentUpdateRequestDto requestDto) {
        Content entity = findContent(contentNo);

        // 수정
        entity.update(requestDto.getContentName(), requestDto.getContentRemark(), requestDto.getContentValue());

        return new ContentResponseDto(entity);
    }

    /**
     * 컨텐츠 삭제
     *
     * @param contentNo 컨텐츠 번호
     */
    @Transactional
    public void delete(Integer contentNo) {
        Content entity = findContent(contentNo);

        // 삭제
        contentRepository.delete(entity);
    }

    /**
     * 컨텐츠 번호로 컨텐츠 엔티티 조회
     *
     * @param contentNo 컨텐츠 번호
     * @return Content 컨텐츠 엔티티
     */
    private Content findContent(Integer contentNo) {
        return contentRepository.findById(contentNo)
                .orElseThrow(() -> new EntityNotFoundException(getMessage("valid.notexists.format", new Object[]{getMessage("content")})));
    }

}
