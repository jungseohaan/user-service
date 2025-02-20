package com.clbee.admin.common.exception;

import com.clbee.admin.common.exception.dto.ErrorCode;

/**
 * com.clbee.admin.common.exception.InvalidValueException
 * <p>
 * 입력 받은 값이 잘못된 경우 사용자에게 알려준다.
 * ExceptionHandlerAdvice BusinessException 처리 메소드에서 잡아낸다.
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
public class InvalidValueException extends BusinessException {

    public InvalidValueException(String value) {
        super(value, ErrorCode.INVALID_INPUT_VALUE);
    }

    public InvalidValueException(String value, ErrorCode errorCode) {
        super(value, errorCode);
    }
}
