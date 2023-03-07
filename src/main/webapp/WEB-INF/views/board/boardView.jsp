<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>boardView</title>
</head>
<body>
<script type="text/javascript">
	$j(document).ready(function(){
		$j("#deletePage").on("click", function(){
			var $frm = $j('.boardDelete :input');
			var param = $frm.serialize();
			
			alert("param : " + param);
			
			$j.ajax({
				url : "/board/boardDeleteAction.do",
				dataType : "json",
				type : "POST",
				data : param,
				success : function(data, textStatus, jqXHR){
					if(data.success=="Y"){
						alert("삭제가 완료되었습니다.");
						return location.href = "/board/boardList.do";
					}
				},
				error : function(jqXHR, textStatus, errowThrown){
					console.log("textStatus" + textStatus);
					alert("실패");
				}
			})
		});
	});
</script>
<form class="boardDelete">
	<input name="boardNum" type="hidden" size="50" value="${board.boardNum}"> 
	<input name="boardType" type="hidden" size="50" value="${board.boardType}"> 
	<table align="center">
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
						${board.boardTitle}
						</td>
					</tr>
					<tr>
						<td height="300" align="center">
						Comment
						</td>
						<td>
						${board.boardComment}
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
				<a href="/board/${board.boardType}/${board.boardNum}/boardUpdate.do">Update</a>
				<a href="javascript:void(0)" id="deletePage">Delete</a>
			</td>
		</tr>
	</table>	
</form>
</body>
</html>