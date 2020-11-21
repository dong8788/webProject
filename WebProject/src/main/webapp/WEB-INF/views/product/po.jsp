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
			<input type="hidden" name="prodSeq" value="${product.prodSeq }">
			<input type="hidden" name="poQuantity" value="${ poQuantity }">
			<input type="hidden" name="cusSeq" value="${login.cusSeq }">
			<input type="hidden" name="billingAmount" value="${(product.price + product.shippingCharge -product.discount)*poQuantity }">
			<input type="hidden" name="poStat" value="newOrder">
		<table>
			<tr>
				<td>제품 명</td><td>${ product.prodName }</td>
			<tr>
			<tr>
				<td>상품 가격</td><td>${ product.price - product.discount }원</td>
			<tr>
				<td>배송비</td><td>${product.shippingCharge }</td>
			</tr>
			<tr>
				<td>구매 수량</td><td>${poQuantity }개</td>
			</tr>
			<tr>
				<td>총 결제 금액 </td><td>${(product.price + product.shippingCharge -product.discount)*poQuantity }</td>
			</tr>
		</table>
		<br><br>
		배송 정보<br>
		<table>
			<tr>
				<td>수령인</td><td><input type="text" name="recipient" ></td>
			</tr>
			<tr>
				<td>수령인 연락처</td><td><input type="text" name="recipientPhone" ></td>
			</tr>
			<tr>
				<td>배송지 주소</td><td><input type="text" name="recipientAddr" ></td>
			</tr>
			<tr>
				<td>배송지 메모</td><td><input type="text" name="shipMemo" ></td>
			</tr>
		</table>
			<br><br>
			결제 수단<br>
		<table>
			<tr>
		    	<td colspan="2">
		        	<input type="radio" name="payMethod" value="easyaccount" checked>계좌 간편 결제
		    	</td>
		    </tr>
		    <tr>
		    	<td colspan="2">
		        	<input type="radio" name="payMethod" value="easycard">카드 간편 결제
		      	</td>
		    </tr>
		    <tr>
		      	<td colspan="2">
		      		<input type="radio" name="payMethod" value="normal">일반 결제
		      	</td>
   			</tr>
   		</table>
			<input type="submit" value="결제하기">
		</form>
	</div>

</body>
</html>
<jsp:include page="../include/footer.jsp" />