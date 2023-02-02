<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    <title>Pricing example Â· Bootstrap v4.6</title>

    <!-- 
    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/pricing/">
	 -->
    
<%@include file="/WEB-INF/views/include/common.jsp" %>



    <!-- Favicons 
<link rel="apple-touch-icon" href="/docs/4.6/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/4.6/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/4.6/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/4.6/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/4.6/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
<link rel="icon" href="/docs/4.6/assets/img/favicons/favicon.ico">
<meta name="msapplication-config" content="/docs/4.6/assets/img/favicons/browserconfig.xml">
<meta name="theme-color" content="#563d7c">
-->

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    <script>
      let msg = '${msg}';
      if(msg != '') {
        alert(msg);
      }


    </script>
    

  </head>
  <body>
    
<%@include file="/WEB-INF/views/include/header.jsp" %>

<div class="container">
  <h3>로그인정보</h3>
	<div class="mb-3 text-center row">
		 <!-- 아이디찾기 -->
		 <div class="col-sm-6">
		 	<h5>아이디 찾기</h5>
		 	<form id="searchForm" action="searchID" method="post">
			  <div class="form-group row">
			    <label for="mem_name" class="col-sm-4 col-form-label">이름</label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control" id="mem_name" name="mem_name" placeholder="NAME">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="mem_email" class="col-sm-4 col-form-label">이메일</label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control" id="mem_email" name="mem_email" placeholder="EMAIL">
			    </div>
			  </div>
			  <div class="form-group row">
				  <div class="col-sm-12 text-center">
				  	<button type="submit" class="btn btn-dark" id="btnLogin">아이디 찾기</button>
				  	<button type="button" class="btn btn-dark" id="btnSearchIDPW">로그인</button>
				  </div>			
			  </div>
		 	</form>
		 </div>
		 <!-- 임시비밀번호 발급 -->
		 <div class="col-sm-6">
		 	<h5>임시비밀번호 발급</h5>
		 	<form id="loginForm" action="searchPw" method="post">
			  <div class="form-group row">
			    <label for="mem_id" class="col-sm-4 col-form-label">아이디</label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control" id="mem_id" name="mem_id" placeholder="ID" required>
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="mem_pw" class="col-sm-4 col-form-label">이메일</label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control" id="mem_email" name="mem_email" placeholder="EMAIL" required>
			    </div>
			  </div>
			  <div class="form-group row">
				  <div class="col-sm-12 text-center">
				  	<button type="submit" class="btn btn-dark" id="btnLogin">임시 비밀번호 발급</button>
				  	<!-- <button type="button" class="btn btn-dark" id="btnSearchIDPW">로그인</button>  -->
				  </div>			
			  </div>
		 	</form>
		 </div>
	  </div>
  
  
    <!--  footer.jsp -->
    <%@include file="/WEB-INF/views/include/footer.jsp" %>
  </div>
    
  </body>
</html>
