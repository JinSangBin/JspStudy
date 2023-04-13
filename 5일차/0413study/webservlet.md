# @WebServlet("/서블릿명")

을 볼 수 있는데 web.xml에서 url 매핑을 직접할수도있지만 번거로우므로 어노테이션 사용
어노테이션 지원으로 간편하게 URL매핑을 할수있음


URL매핑을 사용하는 이유로는 서블릿을 호출할때 서블릿명을 url에 입력해야하는데

서블릿명이 길면 다치기 귀찮으니까? 이건 제 생각이고

실제 서블릿 클래스를 공개하지 않기 위해서라고 합니다. (보안)

# @WebServlet("/hw") 

public class HelloWorld extends HttpServlet ~ 

위 서블릿을 호출할때 localhost:포트번호/프로젝트명(context path)/hw

hw로 요청하게되면 HelloWorld 클래스가 요청을받아서 처리함.


```java

@WebServlet(name = "MyServlet", urlPatterns = { "/servlets/myservlet" })
public class MyServlet extends HttpServlet {
  // servlet code here
}

```
위의 예시에서 @webservlet Annotation은 "MyServlet"이라는 이름으로 Servlet을 정의하고 "/servlets/myservlet" URL 매핑을 지정합니다. 이러한 매핑 정보는 웹 애플리케이션 서버가 클라이언트의 HTTP 요청을 수신할 때 Servlet을 실행하는 데 사용됩니다.

@webservlet Annotation을 사용하면 web.xml 파일에서 Servlet을 매핑하는 대신 Servlet 클래스 내에서 매핑 정보를 정의할 수 있으므로, 코드의 가독성과 유지보수성이 향상됩니다.





```java
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", "하위");
		req.getRequestDispatcher("/13Servlet/FirstServlet.jsp").forward(req, resp);
	} 
```

위의 코드는 HttpServlet 클래스를 상속받은 서블릿에서 GET 요청을 처리하는 메서드인 doGet() 메서드입니다.

HttpServletRequest 객체는 HTTP 요청 정보를 캡슐화한 객체이며, HttpServletResponse 객체는 HTTP 응답 정보를 캡슐화한 객체입니다. doGet() 메서드에서 이러한 객체들을 매개변수로 받아서 사용할 수 있습니다.

req.setAttribute("message", "하위");는 HTTP 요청에 "message"라는 이름으로 "하위"라는 값을 설정하는 코드입니다. 이렇게 설정된 값은 다른 서블릿이나 JSP에서 req.getAttribute("message")와 같은 코드를 사용하여 접근할 수 있습니다.

req.getRequestDispatcher("/13Servlet/FirstServlet.jsp").forward(req, resp);는 RequestDispatcher 객체를 사용하여 다른 JSP 페이지인 "FirstServlet.jsp"로 HTTP 요청을 전달하는 코드입니다. forward() 메서드를 사용하면 현재 서블릿에서 처리한 결과를 다른 서블릿이나 JSP 페이지로 전달할 수 있습니다. 이 경우, "FirstServlet.jsp" 페이지에서는 req.getAttribute("message")와 같은 코드를 사용하여 HTTP 요청에 설정된 "message" 값을 읽을 수 있습니다.

따라서, 위의 코드는 "message"라는 이름으로 "하위"라는 값을 HTTP 요청에 설정한 후, "FirstServlet.jsp" 페이지로 HTTP 요청을 전달하는 코드입니다.



```java
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() call");
		req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp);
	} 
```
req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp);는 

RequestDispatcher 객체를 사용하여 다른 JSP 페이지인 "LifeCycle.jsp"로 HTTP 요청을 전달하는 코드입니다. 

forward() 메서드를 사용하면 현재 서블릿에서 처리한 결과를 다른 서블릿이나 JSP 페이지로 전달할 수 있습니다. 

이 경우, "LifeCycle.jsp" 페이지에서는 현재 HTTP 요청에 대한 처리 결과를 화면에 출력할 수 있습니다.

따라서, 위의 코드는 POST 요청을 받았을 때 "doPost() call"이라는 문자열을 콘솔에 출력하고, "LifeCycle.jsp" 페이지로 HTTP 요청을 전달하여 해당 페이지에서 처리 결과를 출력하는 코드입니다.



```java
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() call");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() call");
		req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() call");
		req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp);
	}
```


<h3>service, doget, dopost 3가지 다 작성하게 되면 service가 먼저 돌기 떄문에 service만 출력됨.</h3>