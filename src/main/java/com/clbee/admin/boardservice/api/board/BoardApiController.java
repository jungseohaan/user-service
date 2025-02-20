package com.clbee.admin.boardservice.api.board;

import lombok.RequiredArgsConstructor;
import com.clbee.admin.common.dto.RequestDto;
import com.clbee.admin.boardservice.api.board.dto.BoardListResponseDto;
import com.clbee.admin.boardservice.api.board.dto.BoardResponseDto;
import com.clbee.admin.boardservice.api.board.dto.BoardSaveRequestDto;
import com.clbee.admin.boardservice.api.board.dto.BoardUpdateRequestDto;
import com.clbee.admin.boardservice.service.board.BoardService;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * com.clbee.admin.boardservice.api.board.BoardApiController
 * <p>
 * 게시판 Rest API 컨트롤러 클래스
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
 *  2025/02/20    seohan       최초 생성
 * </pre>
 */
@RequiredArgsConstructor
@RestController
public class BoardApiController {

    /**
     * 게시판 서비스
     */
    private final BoardService boardService;

    private final Environment env;

    /**
     * 게시판 페이지 목록 조회
     *
     * @param requestDto 요청 DTO
     * @param pageable   페이지 정보
     * @return Page<BoardListResponseDto> 페이지 게시판 목록 응답 DTO
     */
    @GetMapping("/api/v1/boards")
    public Page<BoardListResponseDto> findPage(RequestDto requestDto,
                                               @PageableDefault(sort = "board_no", direction = Sort.Direction.DESC) Pageable pageable) {
        return boardService.findPage(requestDto, pageable);
    }

    /**
     * 게시판 단건 조회
     *
     * @param boardNo 게시판 번호
     * @return BoardResponseDto 게시판 상세 응답 DTO
     */
    @GetMapping("/api/v1/boards/{boardNo}")
    public BoardResponseDto findById(@PathVariable Integer boardNo) {
        return boardService.findById(boardNo);
    }

    /**
     * 게시판 등록
     *
     * @param requestDto 게시판 등록 요청 DTO
     * @return BoardResponseDto 게시판 상세 응답 DTO
     */
    @PostMapping("/api/v1/boards")
    @ResponseStatus(HttpStatus.CREATED)
    public BoardResponseDto save(@RequestBody @Valid BoardSaveRequestDto requestDto) {
        return boardService.save(requestDto);
    }

    /**
     * 게시판 수정
     *
     * @param boardNo    게시판 번호
     * @param requestDto 게시판 수정 요청 DTO
     * @return BoardResponseDto 게시판 상세 응답 DTO
     */
    @PutMapping("/api/v1/boards/{boardNo}")
    public BoardResponseDto update(@PathVariable Integer boardNo, @RequestBody @Valid BoardUpdateRequestDto requestDto) {
        return boardService.update(boardNo, requestDto);
    }

    /**
     * 게시판 삭제
     *
     * @param boardNo 게시판 번호
     */
    @DeleteMapping("/api/v1/boards/{boardNo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer boardNo) {
        boardService.delete(boardNo);
    }

}
