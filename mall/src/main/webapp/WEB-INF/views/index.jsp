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
    <title>Pricing example · Bootstrap v4.6</title>

	
    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/pricing/">
	
    <%@include file="/WEB-INF/views/include/common.jsp" %>

    <!-- <link href="https://getbootstrap.com/docs/4.6/examples/carousel/carousel.css" rel="stylesheet"> -->
    <link href="/css/carousel.css" rel="stylesheet">



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
<%@include file="/WEB-INF/views/include/categoryMenu.jsp" %>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
  <h1 class="display-4">H.F Mall</h1>
  <p class="lead">맛과 건강을 챙기는 식단.</p>
</div>
  
 
<div class="container">
  <div class="card-deck mb-3 text-center">
    <div class="card mb-4 shadow-sm">
      <div class="card-header" style="background-color: #81c147; color: white;">
        <h4 class="my-0 font-weight-normal">무료가입</h4>
      </div>
      <div class="card-body">
        <h1 class="card-title pricing-card-title">지금 <small class="text-muted">바로</small></h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>건강한 음식을</li>
          <li>건강한 몸을 위해</li>
          <li>날씬한 몸을 위해</li>
          <li>투자하세요.</li>
        </ul>
        <a href="/member/join">
        <button type="button" class="btn btn-outline-success">회원가입하러 가기</button>
      	</a>
      </div>
    </div>
  </div>

 <%@include file="/WEB-INF/views/include/footer.jsp" %>
	
</div>


    
  </body>
</html>
