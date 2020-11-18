<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="po" style="width:500px;margin-top:200px;margin-left:auto;margin-right:auto">
		결제 내역<br>
		<br>
		<form action="<c:url value='/product/po'/>" method="post">
		제품 명 : 점퍼<br>
		상품 가격 : 10,000원<br>
		배송비 : 2,500원<br>
		총 결제 금액 : 12,500원<br>
		<br><br>
		배송 정보<br>
		
			<input type="hidden" name="prodSeq" value=26>
			<input type="hidden" name="poQuantity" value=1>
			<input type="hidden" name="payNum" value=1>
			<input type="hidden" name="cusSeq" value="${login.cusSeq }">
			<input type="hidden" name="billingAmount" value=12500>
			<input type="hidden" name="poStat" value="newOrder">
			
			수령인 : <input type="text" name="recipient" ><br>
			수령인 연락처 : <input type="text" name="recipientPhone" ><br>
			배송지 주소 : <input type="text" name="recipientAddr" ><br>
			배송지 메모 : <input type="text" name="shipMemo" ><br><br>
			<br><br>
			결제 수단<br>
			<ul>
		    	<li>
		        	<input type="radio" name="payMethod" value="easyaccount" checked>계좌 간편 결제
		    	</li>
		    	<li>
		        	<input type="radio" name="payMethod" value="easycard">카드 간편 결제
		      	</li>
		      	<li>
		      		<input type="radio" name="payMethod" value="normal">일반 결제
		      	</li>
   			</ul>
			<input type="submit" value="결제하기">
		
		</form>
	</div>

</body>
</html>
<jsp:include page="../include/footer.jsp" />