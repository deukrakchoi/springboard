<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list</title>
</head>
<script type="text/javascript">

	$j(document).ready(function(){
		$j('#chkAll').click(function(){
			if($j("#chkAll").is(":checked")){
				$j("input[name=boardType]").prop("checked", true);
			}
			else 
				$j("input[name=boardType]").prop("checked", false);
		});
		
		$j('input[name=boardType]').click(function(){
			var total = $j("input[name=boardType]").length;
			var checked = $j("input[name=boardType]:checked").length;
			if(total != checked) {
				$j("#chkAll").prop("checked", false);
			}
			else 
				$j("#chkAll").prop("checked", true);
		});
	});

</script>
<body>
<table  align="center">
	<tr>
		<td align="left">
			<a href ="/user/userLogin.do">login</a>
			<a href ="/user/userJoin.do">join</a>
		</td>
	</tr>
	<tr>
		<td align="right">
		total : ${totalCnt}
		</td>
	</tr>
	<tr>
		<td>
			<table id="boardTable" border = "1">
				<tr>
					<td width="80" align="center">
						Type
					</td>
					<td width="40" align="center">
						No
					</td>
					<td width="300" align="center">
						Title
					</td>
				</tr>
				<c:forEach items="${boardList}" var="list">
					<tr>
						<td align="center">
							${list.codeName}
						</td>
						<td>
							${list.boardNum}
						</td>
						<td>
							<a href = "/board/${list.boardType}/${list.boardNum}/boardView.do?pageNo=${pageNo}">${list.boardTitle}</a>
						</td>
					</tr>	
				</c:forEach>
			</table>
		</td>
	</tr>
	<tr>
		<td align="right">
			<a href ="/board/boardWrite.do">글쓰기</a>
		</td>
	</tr>
</table>
	<br><form class="boardTypeCheck" align="center">
		<input type="checkbox" id="chkAll">전체
		<c:forEach items="${codeList}" var="chk">
			<input type="checkbox" id="${chk.codeId}" name="boardType" value="${chk.codeId}">${chk.codeName} 	
		</c:forEach>
		<input type="button" id="submit" value="조회">
	</form>
</body>
</html>