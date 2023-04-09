# JSP Scope 종류

프로그램상 사용되는 변수들은 사용 가능한 범위를 가지는데, 이 때 변수의 범위를 Scope 스코프라고 한다.

즉, 웹 서버에서 객체 또는 변수가 생성된 후 유효 할 수 있는 범위로 변수가 선언된 블럭이 그 변수의 사용범위이다.
#
![Scope](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F996FC3425B382DF536)

|Scope 종류  | 유지범위 | 활용방법 | JSP내장객체 |
|------------|---------|---------|------------|
| **Page Scope** |요청된 page 내부에서사용 | 지역 변수 처럼 활용 JSP에서 사용|pageContext|
| **Request Scope** |요청 부터 응답까지 Forward를 통해 데이터를 넘길때 | request | HttpServletRequest|
| **Session Scope** |Web Brower 종료 또는 설정 한 시간 동안 |사용자 별로 정보를 저장할(Ex:장바구니)| Session|
| **Application** | Web Application이 종료 될때 까지 |사용자에게 공통적으로 무엇가는 보여 주고자 할때| application| 
#

**[SCOPE의 함수]**

|함수|설명|
|--- |----|
|void **setAttribute**(string key,object value);| scope객에 key, value 형식으로 값을 할당한다. Ex) request("today","20180707");|
|Object **getAttribute**(string key);|scope객체에서 key값으로 value값을 리턴 받는다.    Ex) String date = (String)request.getAttribute("today");Object 형식으로 리턴 됨으로 Type casting이 필요하다. |
#






