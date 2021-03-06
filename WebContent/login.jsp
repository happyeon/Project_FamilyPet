<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Family|Pet</title>
<link rel="icon" href="resources/images/logo/favicon.ico" type="image/x-icon">
<style>
#semi_login_mid {
	width: 600px;
	margin: 0 auto;
	min-height: 1000px;
	padding-top: 50px;
}
#semi_login_mid_input {
	text-align: center;
	width: 600px;
	margin: 0px auto;
	height: 500px;
}
.semi_login_text {
	float: left;
	height: 50px;
}
.semi_login_mid_input_form {
	height: 100%;
}
.semi_login_mid_div {
	margin-left: 100px;
	margin-bottom: 15px;
}
.semi_login_mid_div:first-child{
	margin-right:100px;
}
.semi_login_idpw {
	display: block;
	margin-bottom: 10px;
	height: 50px;
	width: 400px;
	text-align: center;
	border: solid 1px #dadada;
}
.semi_login_idpw_text {
	height: 100%;
	padding-left: 10px;
	width: 90%;
	font-size: 15px;
	border: none;
}
.semi_login_mid_idpwfind {
	display: inline-block;
	text-align:center;
	font-size: 13px;
	width: 180px;
	padding-bottom: 10px;
}
.semi_login_mid_idpwfind:hover{
	text-decoration : underline;
}
.g-recaptcha{
	margin-top: 20px;
}
.g-recaptcha-error {
	border-radius: 5px;
	padding: 5px;
}
.semi_login_mid_input_btn {
	display: block;
	width: 400px;
	height: 60px;
	background-color: #f0f0f0;
	color: black;
	padding: 14px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	margin-bottom: 10px;
	font-weight: bolder;
}
.hr-sect {
	display: flex;
	flex-basis: 100%;
	align-items: center;
	color: rgba(0, 0, 0, 0.35);
	font-size: 12px;
	margin: 8px 0px;
}
.hr-sect::before, .hr-sect::after {
	content: "";
	flex-grow: 1;
	background: rgba(0, 0, 0, 0.35);
	height: 1px;
	font-size: 0px;
	line-height: 0px;
	margin: 0px 16px;
}
#kakao_id_login {
	padding: 0;
	width: 400px;
	height: 60px;
}
#kakao-login-btn {
	width: 400px;
	height: 60px;
}
#kakao_padding {
	margin-top : 10px;
	padding-bottom: 20px;
	margin-bottom: 20px;
	height: 60px;
}
#naver_id_login {
	padding: 0;
	width: 400px;
	height: 60px;
}
#naver_id_login_img {
	width: 400px;
	height: 60px;
}
</style>
<script type="text/javascript" src="resources/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://www.google.com/recaptcha/api.js" defer></script>
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">
	$(function() {
		Kakao.init('5c95aa7ad857e55475bed627ba9faf99');
		Kakao.isInitialized();
		console.log("Kakao.isInitialized()", Kakao.isInitialized());
		Kakao.Auth.createLoginButton({
			container : '#kakao_id_login',
			success : function(authObj) {
				Kakao.API.request({
					url : '/v2/user/me',
					success : function(response) {
						var userID = response.id;
						var useEmail = response.kakao_account.email;
						var userNickName = response.properties.nickname;
						var form = document.createElement('form');
						var objs_1;
						objs_1 = document.createElement('input');
						objs_1.setAttribute('type', 'hidden');
						objs_1.setAttribute('name', 'member_id');
						objs_1.setAttribute('value', userID);
						form.appendChild(objs_1);
						var objs_4 = document.createElement('input');
						objs_4.setAttribute('type', 'hidden');
						objs_4.setAttribute('name', 'command');
						objs_4.setAttribute('value', 'sns_signup');
						form.appendChild(objs_4);
						form.setAttribute('method', 'post');
						form.setAttribute('action', "semi.do");
						document.body.appendChild(form);
						form.submit();
					},
					fail : function(error) {
						console.log("request fail", error);
					}
				});
			},
			fail : function(err) {
				alert(JSON.stringify(err));
			},
		});
	});
</script>
</head>
<body>
		<jsp:include page="header.jsp" />
		
		<div id="semi_login_mid">
			<div id="semi_login_mid_input">	
				<form action="semi.do" class="semi_login_mid_input_form" method="post" onsubmit="return submitUserForm();">
					<div class="semi_login_mid_div">
						<input type="hidden" name="command" value="loginres" />
						<span class="semi_login_idpw"> <input type="text" class="semi_login_idpw_text" name="member_id" placeholder="????????? ??????" required="required">
						</span> <span class="semi_login_idpw"> <input type="password" class="semi_login_idpw_text" name="member_password" placeholder="???????????? ??????" required="required">
						</span>

						<div id="g-recaptcha-error"></div>
						<button class="semi_login_mid_input_btn" type="submit">?????????</button>
						<a class="semi_login_mid_idpwfind" href="semi.do?command=findidpw">????????? ??????????????????</a>
						<a class="semi_login_mid_idpwfind" href="semi.do?command=signup">????????????</a>
					</div>
					<div class="hr-sect">SNS?????????</div>
					<!-- ?????????api????????? ?????? -->
					<div class="semi_login_mid_div">
						<div id="kakao_padding">
							<div id="kakao_id_login"></div>
						</div>
						<!-- ?????????????????????????????? ?????? ?????? ?????? -->
						<div id="naver_id_login"></div>
						<!-- google reCaptcha -->
						<div class="g-recaptcha" data-sitekey="6LfGNrAaAAAAACnlQAb1RFvF-DQJApSARniYjGki" data-callback="verifyCaptcha"></div>
					</div>
					<!-- //?????????????????????????????? ?????? ?????? ?????? -->
					<script type="text/javascript">
						var naver_id_login = new naver_id_login(
								"3FogXXVNeg3aYw15VPrY",
								"http://qclass.iptime.org:8585/semi/naver_callback.jsp");
						var state = naver_id_login.getUniqState();
						naver_id_login.setButton("green", 10, 40);
						naver_id_login
								.setDomain("http://qclass.iptime.org:8585/semi/naver_callback.jsp");
						naver_id_login.setState(state);
						//naver_id_login.setPopup();
						naver_id_login.init_naver_id_login();
					</script>
					
				</form>
			</div>

			<script type="text/javascript">
				function submitUserForm() {
					var response = grecaptcha.getResponse();
					if (response.length == 0) {
						document.getElementById('g-recaptcha-error').innerHTML = '<span style="color:red;">reCaptcha ????????????</span>';
						return false;
					}
					return true;
				}
				function verifyCaptcha() {
					document.getElementById('g-recaptcha-error').innerHTML = '';
				}
			</script>
		</div>
	<jsp:include page="bottom.jsp" />
</body>
</html>