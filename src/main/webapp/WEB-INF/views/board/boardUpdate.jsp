<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������Ʈ ������</title>
</head>
<script>
//Ư������ �Է� ����
function characterCheck(obj){
	var regExp = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+��<>@\#$%&\'\"\\\(\=]/;
	if(regExp.test(obj.value)){
		obj.value = obj.value.substring(0, obj.value.length - 1); //�Է��� Ư������ ���ڸ� ���
	}
}
</script>
<script type="text/javascript">
	$j(document).ready(function(){
		$j('#submit').on("click", function(){
			var $frm = $j('.boardUpdate :input');
			var param = $frm.serialize();
			
			alert("param : " + param);
			
			var title = $j('#boardTitle').val().trim();
			var comment = $j('#boardComment').val().trim();
			
			if(title == ''){
				alert("������ �ʼ��Է� �׸��Դϴ�.");
				return;
			}
			if(comment == ''){
				alert("������ �ʼ��Է� �׸��Դϴ�.");
				return;
			}
			
			$j.ajax({
				url : "/board/boardUpdateAction.do",
				dataType : "json",
				type : "POST",
				data : param,
				success : function(data, textStatus, jqXHR){
					alert("������ �Ϸ�Ǿ����ϴ�.");
					return location.href = "/board/boardList.do";
				},
				error : function(jqXHR, textStatus, errowThrown){
					console.log("textStatus" + textStatus);
					alert("����");
				}
			})
		});
	});
</script>
<body>
<form class="boardUpdate">
	<input name="boardNum" type="hidden" size="10" value="${board.boardNum}"> 
	<input name="boardType" type="hidden" size="10" value="${board.boardType}"> 
	<table align="center">
		<tr>
			<td align="right">
			<input type="button" value="����" id="submit">
			</td>
		</tr>
		<tr>
			<td>
				<table border ="1">
					<tr>
						<td width="120" align="center">
						Type
						</td>
						<td width="400">
						${board.codeName}
						</td>
					</tr>
					<tr>
						<td width="120" align="center">
						Title
						</td>
						<td width="400">
						<input name="boardTitle" id="boardTitle" type="text" size="50" value="${board.boardTitle}" onkeyup="characterCheck(this)" onkeydown="characterCheck(this)" > 
						</td>
					</tr>
					<tr>
						<td height="300" align="center">
						Comment
						</td>
						<td>
						<textarea name="boardComment" id="boardComment" rows="20" cols="55" onkeyup="characterCheck(this)" onkeydown="characterCheck(this)" >${board.boardComment}</textarea>
						</td>
					</tr>
					<tr>
						<td align="center">
						Writer
						</td>
						<td>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="right">
				<a href="/board/boardList.do">List</a>
			</td>
		</tr>
	</table>	
</form>
</body>
</html>