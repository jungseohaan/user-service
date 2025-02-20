package com.clbee.admin.common.util;

import com.clbee.admin.common.config.GlobalConstant;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * com.clbee.admin.common.util.LogUtil
 * <p>
 * 로그인, 접속 로그 입력 시 필요한 정보 제공
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
public class LogUtil {

	/**
	 * 클라이언트 사용자의 IP 가져오기
	 *
	 * @return
	 */
	public static String getUserIp1() {

		String ip = null;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();

		ip = request.getHeader("X-Forwarded-For");

		if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-RealIP");
		}
		if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("REMOTE_ADDR");
		}
		if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return ip;
	}

	public static String getUserIp() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		// List of headers to check for the IP address
		String[] headers = {
				"X-Forwarded-For",
				"Proxy-Client-IP",
				"WL-Proxy-Client-IP",
				"HTTP_CLIENT_IP",
				"HTTP_X_FORWARDED_FOR",
				"X-Real-IP",
				"X-RealIP",
				"REMOTE_ADDR"
		};

		// Iterate through headers to find a valid IP
		for (String header : headers) {
			String ip = request.getHeader(header);
			if (isValidIp(ip)) {
				return ip;
			}
		}

		// Fallback to remote address if no valid IP is found in headers
		return request.getRemoteAddr();
	}

	// Helper method to check if the IP is valid
	private static boolean isValidIp(String ip) {
		return ip != null && !ip.isEmpty() && !"unknown".equalsIgnoreCase(ip);
	}

	/**
	 * 접속 사이트 정보를 넘긴다.
	 *
	 * @param request
	 * @return
	 */
	public static Long getSiteId(HttpServletRequest request) {
		String header = request.getHeader(GlobalConstant.HEADER_SITE_ID);
		if (!StringUtils.hasLength(header)) {
			return null;
		}
		return Long.valueOf(header);
	}

}
