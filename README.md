<h3>건강음식 헬스푸드 HFMall 1인 프로젝트입니다.</h3>
<hr>
<b>작업기간 : 2022-12-10 ~ 2023.02.10</b>
<hr>
<b>사용 기술 : Java, Spring, Jsp, Js/Jquery, Oracle, Json</b><br>
ORACLE - 데이터모델링 CRUD에 맞는 데이터타입을 선정하고 기본키, 외래키등으로 관계형 데이터베이스를 구축하고 서브쿼리와 조인을 활용했습니다. 

JSP - MVC모델 기반의 CRUD, 댓글, 페이징 가능한 후기, 회원관리, 파일업로드를 구현하였고, EL/JSTL을 이용하여 화면 구현을 하였습니다. 
<hr>
<b>이슈관리</b> - 1인작업으로 혼자 확인하기 때문에 기능을 1개씩 추가할 때마다 모두 동작여부를 직접 확인했습니다. 
<hr>

<b>프로젝트 느낀점</b> -

국비 수료 후 배운 기술로 처음 만들어 본 프로젝트였고, 어떠한 방식이 어떻게 더 무리없이 작동될까라는 생각 후에 하루 하루 짜아둔 코드에 새로 짠 코드를 녹이는 작업이 생각보다 쉽지 않았습니다.
어떤 부분에서는 비동기방식이 훨씬 좋고, 어떤 부분에서는 단순 API만으로도 작업이 되고 하다보니 이번 프로젝트는 최적의 동작보다는 100% 동작이라는 것에 대한 포커스를 맞추고 작업을 한거 같습니다.

<hr>
<h3>간단한 코드 보기</h3>



<b>로그인관리</b> - 세션작업을 통하여 정보를 저장할 수 있게 작업하였습니다. 

    String mem_id = ((MemberVO) session.getAttribute("loginStatus")).getMem_id(); // 유저가 로그인한 아이디

<hr>
<b>상품후기(AJAX)</b>

대부분 컨트롤러 방식을 GET, POST 방식으로만 사용을 하였습니다만, 상품의 후기 작업은 모든 데이터를 불러올 필요가 없다고 판단을 했기 때문에 AJAX방식을 이용하여 
RESTAPI를 구현하였습니다.


    @GetMapping("/list/{pdt_num}/{page}")
   	public ResponseEntity<Map<String, Object>> reviewList(@PathVariable("pdt_num") Integer pdt_num, @PathVariable("page") Integer page) {
		
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 1) 댓글리스트 목록 : List<ReviewVO>
		Criteria cri = new Criteria();
		cri.setPageNum(page);
		
		List<ReviewVO> list = reviewService.list(pdt_num, cri);
		map.put("list", list);
		
		// 2) 댓글페이지 정보 : PageDTO
		PageDTO pageMaker = new PageDTO(cri, reviewService.listCount(pdt_num));
		map.put("pageMaker", pageMaker);
		
		entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return entity;
	}
	
	  상품정보 JSP 코드 작업
	
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


<hr>
<b>DTO관리(page)</b> 

	private int startPage;  // 각 블럭의 시작페이지 번호저장
	private int endPage;    // 각 블럭의 마지막페이지 번호저장
	
	//이전, 다음 표시여부
	private boolean prev, next;
	
	//총 데이타 개수
	private int total; 
	
	// 페이징과검색 필드 : page, amount, type, keyword
	private Criteria cri;

	//매개변수가 있는 생성자 정의
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		//데이터수 42
		int pageSize = 5; //블록에 표시될 페이지 개수.	
		int endPageInfo = pageSize - 1; // 5 - 1 = 4
		
		/*
		startPage, endPage 변수의 목적? 목록에서 블럭의 번호를 출력
		첫번째 블럭  	1	2	3	4	5  
		두번째 블럭		6	7	8	9	10
		
		첫번째 블럭계산 Math.ceil(1 / 5.0) = (int) 1.0 -> 1 * 5 = 5.		endPage = 5, startPage = 1
		두번째 블럭계산 Math.ceil(6 / 5.0) = (int) 2.0 -> 2 * 5 = 10		endPage = 10, startPage = 6
		 */
		
		
		// pageNum 이 1~5범위에 해당되면, endPage변수의 값이 동일하게된다.  1   2	 3	 4	 5
		// pageNum이 6이면, endPage변수의 값이 다르게 된다. 6	 7	 8	 9   10
		// (int) (ceil( 1 / 5.0)) * 5,  (int) (ceil( 2 / 5.0)) * 5, (int) (ceil( 3 / 5.0)) * 5
		this.endPage = (int) (Math.ceil(cri.getPageNum() / (double) pageSize)) * pageSize;
		this.startPage = this.endPage - endPageInfo; // 첫번째블럭 5 - 4 = 1, 두번째블럭 10 - 4 = 6
		
		//실제 데이터수를 사용한 전체페이지수를 구한다.		게시판 중 데이터 개수 13. 페이지당 출력 게시물건수 5.
		// realEnd = Math.ceil(13.0 / 5) -> (int) 3.0 -> 3
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(realEnd <= this.endPage) {
			this.endPage = realEnd; // 실제 데이터수에 의한 페이지수만큼 출력을 하기위해서는 
		}
		
		//이전, 다음 표시여부
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
	


