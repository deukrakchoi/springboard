<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입 페이지</title>
</head>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
//conflict test
function kakaopost(){
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
            document.querySelector("#userAddr1").value = data.zonecode;  //새 우편번호
            document.querySelector("#userAddr2").value = data.address;   //기본주소
        }
    }).open();
}
</script>
<script>
	$j(document).ready(function(){
		
		function kakaopost(){
		    new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            document.querySelector("#userAddr1").value = data.zonecode;  //새 우편번호
		            document.querySelector("#userAddr2").value = data.address;   //기본주소
		        }
		    }).open();
		}
		
		
		var status = "N";
		
		//아이디 중복 확인
		$j("#userIdChk").on("click", function(){
			var userId = $j('#userId').val();
			var param = { "userId": userId};
			$j.ajax({
				url : "/user/userIdChk.do",
				dataType : "json",
				type : "POST",
				data : param,
				success : function(data, textStatus, jqXHR)
				{
					console.log("성공" + data);	
					if(data == true){
						$j('#idChk').html('<b style="font-size: 14px; color: green">사용가능</b>');
						status = "T";
					}else{
						$j('#idChk').html('<b style="font-size: 14px; color: red">아이디 중복</b>');
						status = "F";
					}
				},
				error : function(jqXHR, textStatus, errorThrown){
					console.log("실패");
					console.log(status, error);
				}
			});
		});
		
		//비밀번호 일치여부 확인
		$j("#userPwChk").keyup(function(){
			if($j('#userPw').val() != $j('#userPwChk').val()){
				$j('#pwChk').html('<b style="font-size: 14px; color: red">일치하지 않음</b>');
			}else{
				$j('#pwChk').html('<b style="font-size: 14px; color: green">일치</b>');
			}
		});
		
		
		//회원가입
		$j("#submit").on("click", function(){
			//if : 필수입력 사항이 다 입력되었는지 확인하는 부분(포커스 처리!)
			//아이디
			if(status == "F"){
				alert("중복된 아이디입니다. 변경해주세요.");
				$j('#userId').focus();
				return;
			}
			if(status == "N"){
				alert("중복확인을 클릭해주세요.");
				$j('#userIdChk').css('background-color', 'red');
				return;
			}
			
			//패스워드 6자리 ~ 12자리
			if($j('#userPw').val().length < 6 || $j('#userPw').val().length > 12){
				alert("패스워드를 6~12자리로 입력해 주세요.");
				$j('#userPw').focus();
				return;
			}
			
			//패스워드 ! 패스워드 체크
			if($j('#userPw').val() != $j('#userPwChk').val()){
				//alert("일치하지 않은 경우");
				alert("입력된 비밀번호가 일치하지 않습니다.");
				$j('#userPwChk').focus();
				return;
			}
			//패스워드가 안적혀 있을 때 (포커스)
			if($j('#userPw').val().length < 1){
				//alert("패스워드가 안적혀있을 때");
				$j('#userPw').focus();
				return;
			}
			//패스워드 체크가 안적혀 있을 때(포커스)
			if($j('#userPwChk').val().length < 1){
				//alert("패스워드 체크가 안적혀 있을 때");
				$j('#userPwChk').focus();
				return;
			}
			//패스워드, 패스워드 체크 안적혀 있을 때(경고창 -> "비밀번호 안적었다 적어라!")
			if($j('#userPw').val().length < 1 && $j('#userPwChk').val().length <1){
				alert("비밀번호를 입력해 주세요.");
				return;
			}
			
			//else //체크 다 되었으면 ajax로 데이터 보내서 회원가입 완료
			var $frm = $j('.userJoin :input');
			var param = $frm.serialize();
			
			$j.ajax({
				url : "/user/userJoinAction.do",
				dataType: "json",
				type : "POST",
				data : param,
				success : function(data, textStatus, jqXHR)
				{
					alert("메시지 : " + data.success);
					
					location.href = "/board/boardList.do"
				},
				error: function(jqXHR, textStatus, errorThrown)
				{
					alert("실패");
				}
			});
		})
	});

</script>
<body>
<form class="userJoin">
<table align="center">
	<tr>
		<td align="left">
			<a href ="/board/boardList.do">List</a>
		</td>
	</tr>
	<tr>
		<td>
			<table id="boardTable" border="1">
				<tr>
					<td width="80" align="center">
						id
					</td>
					<td width="350" align="left">
						<input type="text" id="userId" name="userId">
						<button type="button" id="userIdChk" name="userIdChk">중복확인</button>
						<span id="idChk"></span>
					</td>
				</tr>
				<tr>
					<td width="80" align="center"> 
						pw
					</td>
					<td width="350" align="left">
						<input type="password" id="userPw" name="userPw">
					</td>
				</tr>
				<tr>
					<td width="80" align="center"> 
						pw check
					</td>
					<td width="350" align="left">
						<input type="password" id="userPwChk" name="userPwChk">
						<span id="pwChk"></span>
					</td>
				</tr>
				<tr>
					<td width="80" align="center">
						name
					</td>
					<td width="350" align="left">
						<input type="text" id="userName" name="userName">
					</td>
				</tr>
				<tr>
					<td width="80" align="center">
						phone
					</td>
					<td width="350" align="left">
						<select name="userPhone1" id="userPhone1">
							<c:forEach var="op" items="${optionList}">
								<option value="${op.userPhone}">${op.userPhone}</option>
							</c:forEach>
						</select> 
						<!-- oninput이벤트 사용하여 숫자만 입력할 수 있는 정규식 적용(숫자가 아닌값을 입력하면 공백으로 대체)-->
						- <input type="text" id="userPhone2" name="userPhone2" size=2 maxlength='4' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/> 
						- <input type="text" id="userPhone3" name="userPhone3" size=2 maxlength='4' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/>
					</td>
				</tr>
				<tr>
					<td width="80" align="center">
						postNo
					</td>
					<td width="350" align="left">
						<input type="text" id="userAddr1" name="userAddr1" readonly>
						<input type="button" value="우편번호찾기" onclick="kakaopost()">
					</td>
				</tr>
				<tr>
					<td width="80" align="center">
						address
					</td>
					<td width="350" align="left">
						<input type="text" id="userAddr2" name="userAddr2">
					</td>
				</tr>
				<tr>
					<td width="80" align="center">
						company
					</td>
					<td width="350" align="left">
						<input type="text" id="userCompany" name="userCompany">
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="right">
			<button type="button" id="submit" name="submit">join</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>