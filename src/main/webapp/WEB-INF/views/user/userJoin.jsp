<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ ������</title>
</head>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
//conflict test
function kakaopost(){
    new daum.Postcode({
        oncomplete: function(data) {
            // �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ��Դϴ�.
            // ������ �����Ͽ� �پ��� Ȱ����� Ȯ���� ������.
            document.querySelector("#userAddr1").value = data.zonecode;  //�� �����ȣ
            document.querySelector("#userAddr2").value = data.address;   //�⺻�ּ�
        }
    }).open();
}
</script>
<script>
	$j(document).ready(function(){
		
		function kakaopost(){
		    new daum.Postcode({
		        oncomplete: function(data) {
		            // �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ��Դϴ�.
		            // ������ �����Ͽ� �پ��� Ȱ����� Ȯ���� ������.
		            document.querySelector("#userAddr1").value = data.zonecode;  //�� �����ȣ
		            document.querySelector("#userAddr2").value = data.address;   //�⺻�ּ�
		        }
		    }).open();
		}
		
		
		var status = "N";
		
		//���̵� �ߺ� Ȯ��
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
					console.log("����" + data);	
					if(data == true){
						$j('#idChk').html('<b style="font-size: 14px; color: green">��밡��</b>');
						status = "T";
					}else{
						$j('#idChk').html('<b style="font-size: 14px; color: red">���̵� �ߺ�</b>');
						status = "F";
					}
				},
				error : function(jqXHR, textStatus, errorThrown){
					console.log("����");
					console.log(status, error);
				}
			});
		});
		
		//��й�ȣ ��ġ���� Ȯ��
		$j("#userPwChk").keyup(function(){
			if($j('#userPw').val() != $j('#userPwChk').val()){
				$j('#pwChk').html('<b style="font-size: 14px; color: red">��ġ���� ����</b>');
			}else{
				$j('#pwChk').html('<b style="font-size: 14px; color: green">��ġ</b>');
			}
		});
		
		
		//ȸ������
		$j("#submit").on("click", function(){
			//if : �ʼ��Է� ������ �� �ԷµǾ����� Ȯ���ϴ� �κ�(��Ŀ�� ó��!)
			//���̵�
			if(status == "F"){
				alert("�ߺ��� ���̵��Դϴ�. �������ּ���.");
				$j('#userId').focus();
				return;
			}
			if(status == "N"){
				alert("�ߺ�Ȯ���� Ŭ�����ּ���.");
				$j('#userIdChk').css('background-color', 'red');
				return;
			}
			
			//�н����� 6�ڸ� ~ 12�ڸ�
			if($j('#userPw').val().length < 6 || $j('#userPw').val().length > 12){
				alert("�н����带 6~12�ڸ��� �Է��� �ּ���.");
				$j('#userPw').focus();
				return;
			}
			
			//�н����� ! �н����� üũ
			if($j('#userPw').val() != $j('#userPwChk').val()){
				//alert("��ġ���� ���� ���");
				alert("�Էµ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				$j('#userPwChk').focus();
				return;
			}
			//�н����尡 ������ ���� �� (��Ŀ��)
			if($j('#userPw').val().length < 1){
				//alert("�н����尡 ���������� ��");
				$j('#userPw').focus();
				return;
			}
			//�н����� üũ�� ������ ���� ��(��Ŀ��)
			if($j('#userPwChk').val().length < 1){
				//alert("�н����� üũ�� ������ ���� ��");
				$j('#userPwChk').focus();
				return;
			}
			//�н�����, �н����� üũ ������ ���� ��(���â -> "��й�ȣ �������� �����!")
			if($j('#userPw').val().length < 1 && $j('#userPwChk').val().length <1){
				alert("��й�ȣ�� �Է��� �ּ���.");
				return;
			}
			
			//else //üũ �� �Ǿ����� ajax�� ������ ������ ȸ������ �Ϸ�
			var $frm = $j('.userJoin :input');
			var param = $frm.serialize();
			
			$j.ajax({
				url : "/user/userJoinAction.do",
				dataType: "json",
				type : "POST",
				data : param,
				success : function(data, textStatus, jqXHR)
				{
					alert("�޽��� : " + data.success);
					
					location.href = "/board/boardList.do"
				},
				error: function(jqXHR, textStatus, errorThrown)
				{
					alert("����");
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
						<button type="button" id="userIdChk" name="userIdChk">�ߺ�Ȯ��</button>
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
						<!-- oninput�̺�Ʈ ����Ͽ� ���ڸ� �Է��� �� �ִ� ���Խ� ����(���ڰ� �ƴѰ��� �Է��ϸ� �������� ��ü)-->
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
						<input type="button" value="�����ȣã��" onclick="kakaopost()">
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