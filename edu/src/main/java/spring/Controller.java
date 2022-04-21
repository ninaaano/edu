package spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * FileName:Controller.java
 * -Controller객체의 일반적, 공통적 행위(method)을 정의 규정하는interface
 * -Controller객체는 Control에서 수행하는 실질적, 핵심적 역할을 수행
 * -ServletAPI 핵심, 주요한 객체 HttpServletRequest/HttpServletResponse 인자를 전달받음
 */
public interface Controller {
	public void execute(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException;
}
