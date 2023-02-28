<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 페이지</title>
</head>
<script type="text/javascript">
	$j(document).ready(function(){
		$j("#submit").on("click", function(){
			if($j('#userId').val() == ''){
				alert("아이디를 입력하세요");
				$j('#userId').focus();
				return;
			}
			if($j('#userPw').val() == ''){
				alert("비밀번호를 입력하세요");
				$j('#userPw').focus();
				return;
			}
			
			$j.ajax({
				url : "/user/userLoginAction.do",
				dataType : "json",
				type : "POST",
				data: {userId:$j('#userId').val(), userPw:$j('#userPw').val()},
				success : function(data){
					if(data == true){
						location.reload();
					}else{
						alert("아이디나 비밀번호가 일치하지 않습니다");
						$j('#userId').focus();
					}
				},
				error : function(req, text){
					alert(text + ': ' + req.status);
				}
			});	
		})
	});
</script>

<body>
<form class="userLogin">
<table align="center">
	<tr>
		<td>
			<table id="boardTable" border="1">
				<tr>
					<td width="80" align="center">id</td>
					<td width="280" align="left"><input type="text" id="userId" name="userId"></td>
				</tr>
				<tr>
					<td width="80" align="center">pw</td>
					<td width="280" align="left"><input type="password" id="userPw" name="userPw"></td>
				</tr>
			</table>
		</td>
	</tr>	
	<tr>
		<td align="right">
			<button type="button" id="submit" name="submit">Login</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>