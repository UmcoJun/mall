<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<body>
<div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">주문상세정보</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <h6>주문상세</h6>
        <table class="table table-bordered">
        	<tr>
        		<th>주문상품/이미지</th>
        		<th>수량</th>	
        		<th>주문금액</th>	
        		<th>배송비</th>	
        	</tr>
        	<c:forEach items="${odList }" var="orderDetailVOList">
        	<tr>
        		<td>
        		<img src="/admin/order/displayFile?folderName=${orderDetailVOList.productVO.pdt_img_folder }&fileName=s_${orderDetailVOList.productVO.pdt_img }" 
	      		alt="" style="width: 60px;height: 60px;" onerror="this.onerror=null; this.src='/image/no_images.png'">
	      		<a class="move" href="${orderDetailVOList.productVO.pdt_num }"><c:out value="${orderDetailVOList.productVO.pdt_name }" escapeXml="true" /></a>
        		</td>
        		<td>${orderDetailVOList.orderDetailVO.odr_amount }</td>
        		<td><span class="odr_price">${orderDetailVOList.orderDetailVO.odr_price }</span></td>
        		<td>무료</td>
        	</tr>
        	</c:forEach>
        </table>
    </div>
    <div class="modal-footer">
        <button type="button" name="btnDetailClose" class="btn btn-secondary" data-dismiss="modal">닫기</button>
    </div>
  </div>
</div>

  <script>
  $(document).ready(function() {

	  $("a.move").on("click", function(e) {
	    	e.preventDefault();
	    	
	  });
	  
  });

</script>


</body>
</html>