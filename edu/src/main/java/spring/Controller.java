package spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * FileName:Controller.java
 * -Controller��ü�� �Ϲ���, ������ ����(method)�� ���� �����ϴ�interface
 * -Controller��ü�� Control���� �����ϴ� ������, �ٽ��� ������ ����
 * -ServletAPI �ٽ�, �ֿ��� ��ü HttpServletRequest/HttpServletResponse ���ڸ� ���޹���
 */
public interface Controller {
	public void execute(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException;
}
