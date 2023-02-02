<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    <title>Pricing example · Bootstrap v4.6</title>

	<!-- 
    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/pricing/">
	 -->
        
	<%@include file="/WEB-INF/views/include/common.jsp" %>
    
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
    <script id="reviewTemplate" type="text/x-handlebars-template">
    {{#each .}}
      <p>{{rv_content}}</p>
      <div class="row">
        <div class="col-md-3">{{idThreeDisplay mem_id}}</div>
        <div class="col-md-9">{{prettifyDate rv_date_reg}}</div>
      </div>
      <div class="row">
        <div class="col-md-3">
          {{displayStar rv_score}}
          <input type="hidden" name="rv_score" value="{{rv_score}}">
        </div>
        <div class="col-md-9">{{authorityview mem_id rv_num}}</div>
      </div>
      <hr>
    {{/each}}
    </script>
        <!-- Favicons -->
<!-- 
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

      #star_rv_score a.rv_score {
      	font-size: 22px;
      	text-decoration: none;
      	color: lightgray;
      }
      
      #star_rv_score a.rv_score.on {
      	color: black;
      }
    
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
  <h1 class="display-4">${cate_name }</h1>
</div>

<div class="container">
      <div class="row mb-3">
		    <div class="col-md-6">
		      <img src="/product/displayFile?folderName=${productVO.pdt_img_folder }&fileName=${productVO.pdt_img}" width="450" height="450" alt="">
		    </div>
		    <div class="col-md-6">
		      <div class="card-body" style="text-align: center;">
		        <h3 class="card-title">${productVO.pdt_name }</h3>
            <input type="hidden" name="pdt_num" value="${productVO.pdt_num }">
		        <br>
            <input type="text" name="odr_amount" value="1">
		      </div>
          <div class="card-body" style="text-align: center;">
            <button type="button" name="btnDirectOrder" class="btn btn-outline-success">바로구매</button>
            <button type="button" name="btnCart" class="btn btn-outline-success">장바구니</button>
          </div>
		    </div>
      		</div>


      <div class="row">
      	<div class="col-md-12">
      		<div id="tabs">
      			<ul class="nav nav-tabs" id="myTab" role="tablist">
      				<li class="nav-item" role="presentation">
      					<a href="#product_desc" class="btn btn-success">상품설명</a>
      				</li>
      				<li class="nav-item" role="presentation">
      					<a href="#product_rev"  class="btn btn-success">상품후기</a>
      				</li>
      				<li class="nav-item" role="presentation">
      					<a href="#product_qna"  class="btn btn-success">상품문의</a>
      				</li>
      			</ul>
      			<div id="product_desc">
      				${productVO.pdt_detail }
      			</div>
      			<div id="product_rev">
      				<b>상품후기</b>
      				<div class="form-group row">
      					<div class="col-md-12">
      						<p id="star_rv_score">
      							평점 :
      							<a class="rv_score" href="#">★</a>
      							<a class="rv_score" href="#">★</a>
      							<a class="rv_score" href="#">★</a>
      							<a class="rv_score" href="#">★</a>
      							<a class="rv_score" href="#">★</a>
      						</p>
      					</div>
      				</div>
      				<div class="form-group row">
      					<div class="col-md-12">
      						<textarea rows="3" cols="80" id="rv_content" class="form-control"></textarea>
      						<button type="button" id="btn_review_write" class="btn btn-outline-success">등록</button>
                  <button type="button" id="btn_review_edit" class="btn btn-outline-success" style="display:none">수정</button>
      					</div>
      				</div>
              <!-- 상품후기 삽입위치 -->
              <div class="row" id="reviewList">
                <div class="col-md-12" id="reviewItem">
                </div>
              </div>
              <!-- 상품후기 페이징 삽입위치 -->
              <div class="row" id="reviewPaging">
                <div class="col-md-12" id="reviewPagingItem">
                  <nav aria-label="Page navigation example">
                    <ul class="pagination"></ul>
                  </nav>
                </div>
      			</div>
      		</div>
      		</div>
      	</div>
      </div>

 <%@include file="/WEB-INF/views/include/footer.jsp" %>
	
</div>

  <script>

    $(document).ready(function() {

      //$("#tabs").tabs();	
      
      $('#myTab li:last-child button').tab('show')

      /*
      $("#tabs").on('shown.bs.tab', function (event) {
        event.target // newly activated tab
        event.relatedTarget // previous active tab
      })
      */
    	
      // 장바구니 클릭
      $("button[name='btnCart']").on("click", function() {

        $.ajax({
          url:  '/cart/cart_add',
          data: {pdt_num: $("input[name='pdt_num']").val(), cart_amount : $("input[name='odr_amount']").val()}, // javascript object구문
          success:  function(result) {
            if(result == "success") {
              alert("장바구니에 추가됨.");
              if(confirm("장바구니로 이동하시겠습니까?")) {
                location.href = "/cart/cart_list";
              }
            }
          }
        })
      });

      // 바로구매 버튼 1개
      $("button[name='btnDirectOrder']").on("click", function() {

        // 주문작성 페이지
        // 상품코드, 수량: 기본값 1
        let pdt_num = $("input[name='pdt_num']").val(); 
        let odr_amount = $("input[name='odr_amount']").val();

        let url = "/order/orderListInfo?pdt_num=" + pdt_num + "&odr_amount=" + odr_amount + "&type=direct";
      
        console.log("주문작성: " + url);

        location.href = url;
      });

      // 평점 별 클릭
      $("#star_rv_score a.rv_score").on("click", function(e) {
        e.preventDefault();

        $(this).parent().children().removeClass("on");
        $(this).addClass("on").prevAll("a").addClass("on");
      });

      // 리뷰후기 쓰기 
      $("#btn_review_write").on("click", function() {

    	let mem_id = '${sessionScope.loginStatus.mem_id}';
        let rv_score = 0;
        let rv_content = $("#rv_content").val();

        $("#star_rv_score a.rv_score").each(function(index, elem) {
          if($(this).attr("class") == "rv_score on") {
            rv_score += 1;
          }
        });

        if(rv_score == 0) {
          alert("별 평점을 선택해주세요,");
          return;
        }

        if(rv_content == "") {
          alert("후기내용을 입력해주세요.")
          return;
        }
        
        if(mem_id == "") {
          alert("로그인 후 이용해주세요.")
          return;
        }

        // javascript Object문법
        let review_data = {pdt_num : $("input[name='pdt_num']").val(), rv_content : rv_content, rv_score : rv_score};

        $.ajax({
          url: '/review/new',
          headers: {
            "Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"
          },
          type: 'post',
          dataType: 'text',
          data: JSON.stringify(review_data), // JSON문자열로 변환
          success: function(result) {
            if(result == "success") {
              alert("상품후기 등록 성공");
              getPage(url);

              // 수정버튼 클릭 후 초기화
              $("#star_rv_score a.rv_score").removeClass("on")
              $("#rv_content").val("");
              
            }
          }
        });
      });

    });

    // 댓글 목록요청
    let reviewPage = 1; // 상품후기 페이지번호
    let url = "/review/list/" + $("input[name='pdt_num']").val() + "/" + reviewPage;

    getPage(url);

    function getPage(pageInfo) {

      $.getJSON(pageInfo, function(data) {

        //console.log("댓글목록: " + data.list);
        //console.log("댓글페이징정보: " + data.pageMaker);
        printReviewList(data.list, $("div#reviewList div#reviewItem"), $("#reviewTemplate"));
        printreviewPaging(data.pageMaker, $("div#reviewPaging  ul.pagination"));
      });
    }

    // 1) 상품후기 목록 출력함수
    let printReviewList = function(reviewData, target, templateObj) {

      let template = Handlebars.compile(templateObj.html());

      let reviewHtml = template(reviewData); // 후기목록 데이터와 핸들바템플릿 결합(바인딩)
    
      target.children().remove();
      target.append(reviewHtml);
    }

    // 상품후기 등록일 날짜 출력. 자바스크립트 날짜객체참조 https://www.w3schools.com/js/js_dates.asp
    // 사용자정의 Helper함수. 템플릿에서 호출
    Handlebars.registerHelper("prettifyDate", function(timeValue) {

      let dateObj = new Date(timeValue);
      let year = dateObj.getFullYear();
      let month = dateObj.getMonth() + 1;
      let date = dateObj.getDate();
      let hour = dateObj.getHours();
      let minute = dateObj.getMinutes();
      let second = dateObj.getSeconds();

      return year + "/" + month + "/" + date + " " + hour + ":" + minute + ":" + second;
    });

    // 평점 별표시하기
    Handlebars.registerHelper("displayStar", function(rating){ 

      let starStr = "";
      switch(rating) {
        case 1:
          starStr = "★☆☆☆☆";
          break;
        case 2:
          starStr = "★★☆☆☆";
          break;
        case 3:
          starStr = "★★★☆☆";
          break;
        case 4:
          starStr = "★★★★☆";
          break;
        case 5:
          starStr = "★★★★★";
          break;
      }
      return starStr;
    });

    // 아이디 3글자 표시하기
    Handlebars.registerHelper("idThreeDisplay", function(userid) {

      return userid.substring(0, 3) + "******";
    });

    // 댓글작성자 로그인시 수정, 삭제버튼 표시
    Handlebars.registerHelper("authorityview", function(mem_id, rv_num) {

      let str = "";
      let login_id = '${sessionScope.loginStatus.mem_id}';
      if(mem_id == login_id) {
        str += "<button type='button' class='btn btn-outline-success' name='review_edit' data-rv_num='" + rv_num + "'>수정</button>";
        str += "<button type='button' class='btn btn-outline-success' name='review_delete' data-rv_num='" + rv_num + "'>삭제</button>";
      }

      return new Handlebars.SafeString(str);
    });

    // 2) 상품후기 페이징 출력함수
    let printreviewPaging = function(pageMaker, target) {

      let pagingStr = "";
    
      // 이전표시
      if(pageMaker.prev) {
        pagingStr += "<li class='page-item'><a class='page-link' href='" + (pageMaker.startPage - 1) + "'aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>";
      }

      // 페이지번호 표시
      for(let i = pageMaker.startPage; i <= pageMaker.endPage; i++) {
        let classStr = pageMaker.cri.pageNum == i ? "active" : "";
        pagingStr += "<li class='page-item " + classStr + "'><a class='page-link' href='" + i + "'>" + i + "</a></li>";
      }

      // 다음표시 
      if(pageMaker.next) {
        pagingStr += "<li class='page-item'><a class='page-link' href='" + (pageMaker.endPage + 1) + "'aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>";
      }
    
      //console.log(pagingStr);
      target.children().remove();
      target.append(pagingStr);
    }
    
  </script>
  <script>

    $(document).ready(function() {

      // 리뷰 이전, 페이지번호, 다음 클릭
      $("nav ul.pagination").on("click", "li a.page-link", function(e) {
        e.preventDefault();

        reviewPage = $(this).attr("href");
        url = "/review/list/" + $("input[name='pdt_num']").val() + "/" + reviewPage;
        
        getPage(url);
        
        //console.log(url);

      });
      
      // 상품 후기 삭제
      $("div#reviewList div#reviewItem").on("click", "button[name='review_delete']", function() {

        let rv_num = $(this).data("rv_num");

        if(!confirm("상품후기" + rv_num + " 번을 삭제할까요?")) return;

        $.ajax({
          url: '/review/delete/' + rv_num,
          headers: {
            "Content-Type" : "application/json", "X-HTTP-Method-Override" : "DELETE"
          },
          type: 'delete',
          dataType: 'text',
          success: function(result) {
            if(result == "success") {
              alert("상품후기 삭제성공");

              url = "/review/list/" + $("input[name='pdt_num']").val() + "/" + reviewPage;
              getPage(url);
            }
          }
        });
      });

      // 상품후기 수정폼. 
      $("div#reviewList div#reviewItem").on("click", "button[name='review_edit']", function() {

        $("#btn_review_write").hide();
        $("#btn_review_edit").show();

        let rv_score = $(this).parent().parent().find("input[name='rv_score']").val();
        let rv_num = $(this).data("rv_num");
        let rv_content = $(this).parent().parent().prev().prev().html();

        console.log("평점:" + rv_score);
        console.log("후기번호:" + rv_num);
        console.log("후기내용:" + rv_content);

        $("textarea#rv_content").val(rv_content);

        $("textarea#rv_content").parent().find("input[name='rv_num']").remove();
        $("textarea#rv_content").parent().append("<input type='text' name='rv_num' id='rv_num' readonly value='" + rv_num + "'>");
        
        $("#star_rv_score a.rv_score").each(function(index, item) {
          if(index < rv_score) {
            $(item).addClass("on");
          }else {
            $(item).removeClass("on");
          }
        });
      });

      // 후기 수정버튼 클릭 
      $("#btn_review_edit").on("click", function() {

        let rv_score = 0;
        let rv_content = $("#rv_content").val();

        $("#star_rv_score a.rv_score").each(function(index, elem) {
          if($(this).attr("class") == "rv_score on") {
            rv_score += 1;
          }
        });

        if(rv_score == 0) {
          alert("별 평점을 선택해주세요,");
          return;
        }

        if(rv_content == "") {
          alert("후기내용을 입력해주세요.")
          return;
        }

        // javascript Object문법
        let review_data = {rv_num : $("input[name='rv_num']").val(), rv_content : rv_content, rv_score : rv_score};

        $.ajax({
          url: '/review/modify',
          headers: {
            "Content-Type" : "application/json", "X-HTTP-Method-Override" : "PATCH"
          },
          type: 'patch',
          dataType: 'text',
          data: JSON.stringify(review_data), // JSON문자열로 변환
          success: function(result) {
            if(result == "success") {
              alert("상품후기 수정 성공");

              url = "/review/list/" + $("input[name='pdt_num']").val() + "/" + reviewPage;
              getPage(url);

              // 수정버튼 클릭 후 초기화
              $("#star_rv_score a.rv_score").removeClass("on")
              $("#rv_content").val("");
              $("#btn_review_edit").parent().find("input[name='rv_num']").remove();
              $("#btn_review_edit").hide();
              $("#btn_review_write").show();
            }
          }
        });
      });
      
	 });
      
  </script>
  
  </body>
</html>