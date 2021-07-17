# Family | Pet



### 프로젝트 개요

<hr/>

> **프로젝트 명**

​	Family | pet



> **개발 기간**

​	2021년 04월 26일 ~ 2021년 05월 07일



> **팀원**

​	이수연, 김현정, 남민혁, 한동규, 최태준


> [발표자료](https://github.com/happyeon/Project_FamilyPet/blob/master/presentation.pdf)


> **주제 선정 배경**

1. 증가하는 반려동물 가구 비율

   2020년 기준 반려동물 양육 가구는 638만 가구

   반려견•반려묘를 860만 마리 키우는 것으로 추정된다.

2. 반려동물에 대한 전문성 부족

   반려동물에 대한 전문적인 지식 부족으로 인해 양육에 어려움을 느끼는 가구가 많다.



> **개발 목표**

​	반려동물을 위한 전문 포털 사이트 제작

​	쇼핑몰뿐만 아니라 커뮤니티, 전문의와의 상담, 등을 통해 폭 넓은 정보의 창을 제공한다.



> **개발 환경**

​	운영체제 - Windows OS

​	개발도구 - Eclipse

​	DBMS - Oracle DB

​	Server - Apache Tomcat

​	Language - Java, HTML5, CSS3, Javascript, jQuery, Servlet

​	디자인툴 - Bootstrap



### 프로젝트 기능

<hr/>

> 주요 기능 

1. **회원 관리**
   - 이용자의 로그인, 프로필 등록 및 변경을 지원
   - 타 SNS (naver, kakao) 로그인 연동
   - 로그인 세션 처리
   - 관리자 / 전문의 / 일반회원으로 나누어 관리
2. **보안** 
   - 개인정보 암호화 (aes256)
   - 회원가입시 인증번호 검사 (naver sens, gmail)
   - 로그인시 보안문자 입력 (reCaptcha)
3. **추천**
   - 해당 유저에게 알맞은 상품 추천 (mahout)
4. **게시판**
   - 게시판 등록, 수정, 보기, 삭제 (CRUD) 지원
   - 텍스트 에디터 CKEditor 사용
   - 검색, 페이징, 대댓글
5. **위치**
   - 반려동물 실종신고 시 자세한 위치 등록 (kakao)
   - 동물병원 위치 제공 (kakao)
6. **알림**
   - 알림 메세지 전송 (naver sens)
7. **채팅**
   - 실시간 채팅 (web socket)
   - 번역 (papago)
8. **결제**
   - 아임포트를 이용한 kg이니시스



> **맡은 기능**

1. **게시판**

   - 실종게시판 CRUD
   - 텍스트 에디터 CKEditor을 사용하여 게시글을 작성
   - 검색, 페이징, 대댓글

   

2. **페이징**

   - 모든 게시판에 쉽게 적용할 수 있도록 모듈화하여 구현
   - 서블릿에서 게시판별로 다른  command 값을 보내줘서 해당 게시판에 맞게 페이징 처리
   - 검색 기능을 사용했을 때 검색한 내용에 해당하는 게시글에 한해 페이징 처리

   

3. **대댓글**

   - 자바스크립트 클릭 이벤트를 이용하여 버튼을 클릭했을 때 작성자의 닉네임, 댓글 내용, 댓글을 작성한 게시글no를 받아준다.
   - ajax를 이용하여 서블릿으로 데이터를 보내고 받아준다.

   

4. **캘린더**

   - java.util.Calendar를 사용하여 캘린더를 구현하였다.
   - Calendar의 자체 메소드를 이용하여 현재의 month 값을 받아와서 사용자가 캘린더를 접속했을 때 해당 월을 출력할 수 있도록 했다.

   - 마이페이지 안에 캘린더 이외에도 여러 가지 기능이 포함되어 있어 다른 페이지로 이동하는 것 보다는 팝업 창을 이용하여 일정을 등록할 수 있도록 구현
   - 정기 검진의 경우에는 사용자 별로 차이가 있기 때문에 정기검진 날짜, 다음 정기검진까지의 주기를 입력 받아 해당 날짜 하루 전에 알림을 보내주도록 구현하였다.

   

5. **권한 관리**

   - 게시글 작성/수정/삭제 권한

   - 대댓글 작성/수정/삭제 권한

   - 권한이 있을 경우에만 화면에 버튼을 출력

   - 체크박스로 여러 게시글을 동시에 삭제할 때 서블릿에서 유효성 검사를 통해 해당 사용자의 게시글이 아닐 경우 삭제할 수 없도록 구현

     

6. **지도**

   - 카카오 지도 API를 사용

   - 사용자가 편하게 위치 등록을 할 수 있도록 지도위에 원하는 위치를 클릭하면 마커가 생성되도록 만든다.
   - 생성된 마커의 위도와 경도의 값을 받아 화면에 출력
   - 서블릿에서 위도와 경도의 값을 받아준 다음 메인 게시판에서 반복문을 통해서 출력한다.

