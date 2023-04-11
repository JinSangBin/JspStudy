# Annotation
서블릿 클래스 메서드에 붙여지며 컴파일 시 사라지지 않는 주석.
어노테이션에 매핑정보를 남겨서 URL과 매핑 시킬 수 있음.

이미 만들어져있는 어노테이션
 - @Override - 메소드가 오버라이드 됐는지 검증.부모 클래스 또는 구현해야할 인터페이스에서 해당 메소드를 찾을 수 없다면 컴파일 오류.
 - @Deprecated - 메소드를 사용하지 말도록 유도. 만약 사용한다면 컴파일 경고.
 - @SuppressWarnings - 컴파일 경고를 무시.
 - @SafeVarargs - 제너릭 같은 가변인자 매개변수를 사용할 때 경고를 무시.(자바7 이상)
 - @FunctionalInterface - 람다 함수등을 위한 인터페이스를 지정. 메소드가 없거나 두개 이상 되면 컴파일 오류.(자바 8이상)

<h3>
[사용방법]

1. web.xml 파일에 metadata-complete = "false"로 설정
2. 어노테이션을 활용하여 URL매핑
​<img src="img/KakaoTalk_20230411_163016533.png" width="700" height="300" />

- web.xml : 하나의 공유파일에서 수정
- 어노테이션 : 각 서블릿에 매핑이 가능함

 web.xml과 어노테이션 둘다 가능하지만, 협업시에는 어노테이션 방식이 깔끔하기 때문에 주로 사용함

3. URL로 접속
​<img src="img/KakaoTalk_20230411_170335117.png" width="700" height="300" />

</h3>


​
<h3>

Servlet 작성 규칙
1. import javax.servlet
2. public 으로 만들어야함
3. 반드시 httpServlet 를 상속해야함
4. doGet doPost 반드시 오버라이딩(최소 한개라도 있어야함)

​<img src="img/KakaoTalk_20230411_163036454.png" width="700" height="300" />
반드시 상속을 해야함!! </h3>





service, doget, dopost 3가지 다 작성하게 되면 service만 출력됨.