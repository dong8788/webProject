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
	<div style="max-width:70%;margin-top:250px;margin-left:auto;margin-right:auto">
		<table style="width:400px;margin-left:auto;margin-right:auto">
			<h4>회원가입</h4>
   				<form action="<c:url value='/user/sellerRegister'/>" method="post">
     			<tbody>
      				<tr style="height: 3em">
      				      <td>업체명</td>
      				      <td><input type="text" name="businessName" placeholder="업체명" max="20" required="required"></td>
      				      <td></td>
      				</tr>
				    <tr style="height: 3em">
           				<td>사업자 번호</td>
 				        <td><input type="text" name="businessNum" placeholder="사업자 번호" max="50" required="required"></td>
						<td><button class="buisinessnumcheck" style="width: 100%; height: 100%;">중복확인</button></td>
         			</tr>
         			<tr style="height: 3em">
            			<td>판매자 이름</td>
            			<td><input type="text" name="name" placeholder="판매자 이름" max="20" required="required"></td>
            			<td></td>
         			</tr>
         			<tr style="height: 3em">
            			<td>아이디</td>
            			<td><input type="text" name="id" placeholder="아이디" max="20" required="required"></td>
            			<td><button class="idcheck" style="width: 100%; height: 100%;">중복확인</button></td>
         			</tr>
         			<tr style="height: 3em">
            			<td>비밀번호</td>
            			<td><input type="password" name="password" placeholder="비밀번호" max="20" required="required"></td>
            			<td></td>
         			</tr>
         			<tr style="height: 3em">
            			<td>비밀번호 확인</td>
            			<td><input type="password" name="passwordCheck" placeholder="비밀번호 확인" max="20" required="required"></td>
            			<td></td>
         			</tr>
         			<tr style="height: 3em">
            			<td>휴대전화</td>
            			<td><input type="text" name="phone" placeholder="휴대 전화 번호" max="20" required="required"></td>
            			<td></td>
         			</tr>
         			<tr style="height: 3em">
            			<td>주소</td>
            			<td><input type="text" name="addr" placeholder="주소" max="50" required="required"></td>
            			<td></td>
         			</tr>
         			<tr style="height: 3em">
            			<td>이메일</td>
            			<td><input type="email" name="email" placeholder="이메일" max="20" required="required"></td>
            			<td><button class="authkey" style="width: 100%; height: 100%;">인증번호 받기</button></td>
         			</tr>
        			<tr style="height: 3em">
            			<td>인증번호</td>
            			<td><input type="text" name="authkey" placeholder="인증번호" max="20" required="required"></td>
            			<td><button class="authkey-confirm" style="width: 100%; height: 100%">인증확인</button></td>
         			</tr>
         			<tr style="height: 3em">
            			<td colspan="3" align="right"><input type="submit" value="가입하기"></td>
         			</tr>
      			</tbody>
   			</form>
		</table>
	</div>
</body>
</html>
<jsp:include page="../include/footer.jsp" />