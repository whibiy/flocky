package ksmart.ks48team02.common.thymeleaf;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomThymeleaf {
	
	private HttpServletRequest request;
	private HttpServletResponse response;

	public CustomThymeleaf(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}
	
	public int total(int val1, int val2) {
		int totalValue = val1 + val2;
		return totalValue;
	}
	
}

/**
 * 사용 방법
 * <h2 th:text="${#ks.request.requestURI}"></h2>
 * <h2 th:text="${#ks.total(3,5)}"></h2>
 *
 */