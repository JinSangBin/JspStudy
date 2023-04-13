# metadata-complete 속성

# Servlet 2.5
Servlet 2.5부터 web.xml의 <web-app> 태그에 설정할 수 있는 metadata-complete 속성이 있다.

Servlet 2.5 명세에 제시된 설명은 다음과 같다.
```
The metadata-complete attribute defines whether this deployment descriptor and other related deployment descriptors for this module (e.g., web service descriptors) are complete, or whether the class files available to this module and packaged with this application should be examined for annotations that specify deployment information.
If metadata-complete is set to "true", the deployment tool must ignore any annotations that specify deployment information, which might be present in the class files of the application.
If metadata-complete is not specified or is set to "false", the deployment tool must examine the class files of the application for annotations, as specified by the specifications.
```
<h2 style="color:green">서블릿 엔진이 구동될 때, 서블릿 관련 어노테이션들을 스캐닝할지 여부를 지정하는 것이다.

(true: 스캐닝 미수행, false: 스캐닝 수행, 기본값은 false)</h2>
스캐닝 대상 클래스는 서블릿 엔진에 디플로이된 클래스, 즉 웹어플리케이션 클래스로더에 로드되는 WEB-INF/classes 경로의 모든 클래스들과 WEB-INF/lib 경로의 모든 jar들이다. 이 클래스들 중에서 서블릿 엔진에 의해 라이프사이클이 관리되는 컴포넌트들에 설정된 어노테이션들이 스캐닝 여부 대상이 된다.
<h2>
예를 들어, 서블릿을 개발하면서 초기화 시점에 특정 동작을 수행하고자 메소드를 하나 정의해서 @PostConstruct 어노테이션을 사용했다면, metadata-complete="true"로 지정한 경우 스캐닝되지 않으므로 해당 메소드가 동작하지 않게 된다.
물론 GenericServlet의 init() 메소드를 오버라이드한 경우라면 어노테이션 스캐닝 여부에 관계없이 동작한다.
</h2>


# Servlet 3.0
Servlet 3.0부터는 서블릿 관련 어노테이션이 다수 추가되었고 web-fragment.xml 파일에 대한 스캐닝이 추가되었다. 3.0에 추가된 어노테이션들은 web.xml 파일 없이도 서블릿, 리스너, 필터 등을 개발 가능하게 해준다.