package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 *
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start");

        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }

        response.getWriter().write("ok");
    }
}
/**
 * 복수 파라미터에서 단일 파라미터 조회
 * username=hello&username=kim 과 같이 파라미터 이름은 하나인데, 값이 중복이면 어떻게 될까?
 * request.getParameter() 는 하나의 파라미터 이름에 대해서 단 하나의 값만 있을 때 사용해야 한다.
 * 지금처럼 중복일 때는 request.getParameterValues() 를 사용해야 한다.
 * 참고로 이렇게 중복일 때 request.getParameter() 를 사용하면 request.getParameterValues() 의 첫 번째 값을 반환한다.
 */






/**
 * HTTP 요청 메시지를 통해 클라이언트에서 서버로 데이터를 전달하는 방법을 알아보자.
 *
 * GET - 쿼리 파라미터
 *   * /url?username=hello&age=20
 *   * 메시지 바디 없이, URL의 쿼리 파라미터에 데이터를 포함해서 전달
 *   * 예) 검색, 필터, 페이징등에서 많이 사용하는 방식
 *
 * POST - HTML Form
 *   * content-type: application/x-www-form-urlencoded
 *   * 메시지 바디에 쿼리 파리미터 형식으로 전달 username=hello&age=20
 *   * 예) 회원 가입, 상품 주문, HTML Form 사용
 *
 * HTTP message body에 데이터를 직접 담아서 요청
 *   * HTTP API에서 주로 사용, JSON, XML, TEXT
 *   * 데이터 형식은 주로 JSON 사용
 *   * POST, PUT, PATCH
 */