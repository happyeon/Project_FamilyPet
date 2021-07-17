<%@page import="com.project.fp.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="com.project.fp.biz.ProductBiz"%>
<%@page import="com.project.fp.biz.ProductBizImpl"%>
<%@page import="com.project.fp.dto.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Family|Pet</title>
<link rel="icon" href="resources/images/logo/favicon.ico" type="image/x-icon">
</head>
<style>


#paging {
	text-align: center;
	font-size: 20pt;
}
#paging a {
	font-size: 20pt;
}
.category {
	float: left;
	padding: 15px 30px 15px 30px;
}
#mobile-filter{
	width: 100%;
	height: 50px;
}
.s-btn {
	border: none;
	display: inline-block;
	padding: 5px 5px 5px 8px;
	background: #f45d96;
	font-size: 14px;
	color: #ffffff;
	font-weight: 600;
	letter-spacing: 4px;
	text-transform: uppercase;
	margin-left: 5px;
}
#recommend_product{
	width:1200px;
	margin: 0 auto;
	height: 400px;
}
.recommend_div{
	width: 18%;
	margin-left: 10px;
	margin-right: 10px;
	float: left;
	border: 1px solid #dadada;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

function searchname() {
	var s_t = $(".search_text").val();
	location.href = "semi.do?command=shopping&s_t="+ s_t;
}

</script>

<jsp:include page="header.jsp" />
<body>
	<%
	MemberDto dto = (MemberDto) session.getAttribute("dto");
	%>
	<form action="semi.do" method="post">
		<input type="hidden" name="command" value="shopping">
		
		<nav class="navbar navbar-expand-sm navbar-light bg-white border-bottom"> <a class="navbar-brand ml-2 font-weight-bold" href="#">MENU</a> <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor" aria-controls="navbarColor" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
    <div class="collapse navbar-collapse" id="navbarColor">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="semi.do?command=shopping<%if(dto!=null){%>&member_id=<%=dto.getMember_id()%><%}%>">Home</a> </li>
        </ul>
    </div>
 		<input id="search" type="text" class="search_text" value="" placeholder="상품명을 입력하세요" style="width:200px; float: right;"/>
  	  <button type="button" class="s-btn" style="float: right;" onclick="searchname();" >검색</button>
</nav>
		
<div id="mobile-filter">
    <div>
        <ul style="list-style: none;">
           					 <li class="category"><a href="semi.do?command=category&prod_category=feed">사료/간식</a>
							 <li class="category"><a href="semi.do?command=category&prod_category=care">케어</a></li>
							 <li class="category"><a href="semi.do?command=category&prod_category=living">리빙</a></li>
							 <li class="category"><a href="semi.do?command=category&prod_category=outing">외출</a></li>
							 <li class="category"><a href="semi.do?command=category&prod_category=toy">장난감</a></li>
							 <li class="category"><a href="semi.do?command=category&prod_category=fashion">패션</a></li>
        </ul>
      
    </div>
</div>
<hr>
<section id="products">
    <div class="container">
    	
        <div class="row">
<%if(request.getAttribute("re_list") != null){ %>        
        <div style="width:100%; height: 50px;">
		<h3>추천 상품</h3>
		</div>
		<c:forEach items="${re_list }" var="re_dto"> 
		<div class="col-2 col-sm-2 col-11 offset-sm-0 offset-1" style="margin: 0px 14px;">
		<div class="card"><a href="semi.do?command=shopping_detail&prod_num=${re_dto.prod_num }"><img class="card-img-top" src="fileupload/${re_dto.file_new_name }" alt="shopimage"></a>
		<div class="card-body">
                        <p><fmt:formatNumber value="${re_dto.prod_price }" pattern="#,###.##"/>원
		</div>
		</div>
		</div>
		</c:forEach>
		
		
<%} %>		
		<div style="width:100%; height: 50px; margin: 30px;">
		<h3>상품</h3>
		</div>
		<c:forEach items="${list }" var="dto"> 
            <div class="col-lg-3 col-sm-4 col-11 offset-sm-0 offset-1">
                <div class="card"> <img class="card-img-top" src="fileupload/${dto.file_new_name }" alt="shopimage">
                    <div class="card-body">
                        <p class="card-text" style="height:40px;"><a href="semi.do?command=shopping_detail&prod_num=${dto.prod_num }">${dto.prod_name }</a></p>
                        <p><fmt:formatNumber value="${dto.prod_price }" pattern="#,###.##"/>원</p>
                    </div>
                </div>
            </div>
        </c:forEach>
        </div>
    </div>
</section>

		<jsp:include page="/shopping_paging.jsp">
			<jsp:param value="${BoardCommand }" name="command" />
			<jsp:param value="${Pdto.nowBlock}" name="nowBlock" />
			<jsp:param value="${Pdto.blockBegin }" name="blockBegin" />
			<jsp:param value="${Pdto.blockEnd }" name="blockEnd" />
			<jsp:param value="${Pdto.nowPage}" name="nowPage" />
			<jsp:param value="${Pdto.blockBegin}" name="blockBegin" />
			<jsp:param value="${Pdto.blockEnd}" name="blockEnd" />
			<jsp:param value="${Pdto.totalBlock}" name="totalBlock" />
		</jsp:include>

	</form>

	<jsp:include page="bottom.jsp" />

</body>
</html>