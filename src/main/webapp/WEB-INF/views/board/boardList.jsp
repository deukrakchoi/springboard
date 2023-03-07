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
				$j("input[name=codeId]").prop("checked", true);
			}
			else 
				$j("input[name=codeId]").prop("checked", false);
		});
		
		$j('input[name=codeId]').click(function(){
			var total = $j("input[name=codeId]").length;
			var checked = $j("input[name=codeId]:checked").length;
			if(total != checked) {
				$j("#chkAll").prop("checked", false);
			}
			else 
				$j("#chkAll").prop("checked", true);
		});	
	
		$j("#submit").click(function(){
			var codeId = [];
			$j("input[name=codeId]:checked").each(function(i){
				codeId.push($j(this).val());
				alert("출력확인 ::: " + $j(this).val());
				//console.log(codeId);
			});
			var objParam = {"codeList" : codeId};
			alert("출력확인222 : " + objParam);
			
			$j.ajax({
				url : "/board/boardListAction.do",
				type:"POST",
				dataType : "json",
				data:objParam,
				success : function(retVal){
					if(retVal.code == "ok"){
						alert(retVal.message);
					}else{
						alert(retVal.message);
					}
				},
				error :function(request, status, error){
					console.log("AJAX_ERROR");
					alert("실패");
				}
			});  //ajax끝
		}); //click끝
		
	}); //document.ready끝

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
					<td width="60" align="center">
						조회수
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
						<td>
							${list.viewCnt}
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
<!-- 검색 -->
	<br><form class="boardTypeCheck" align="center">
		<input type="checkbox" id="chkAll">전체
		<c:forEach items="${codeList}" var="chk" varStatus="status">
			<input type="checkbox" id="${chk.codeId}" name="codeId" value="${chk.codeId}">${chk.codeName} 	
		</c:forEach>
		<input type="button" id="submit" value="조회">
	</form>

<!-- 페이징 -->	
<form class="pageVo" align="center">	
	<ul class="pageVo">
		<!-- first -->
		<c:if test="${pageVo.pageNo > 1}">
			<span><a href='<c:url value="/board/boardList.do?pageNo=1"/>'>First</a></span>
		</c:if>
		<c:if test="${pageVo.prev}">
        	<span><a href='<c:url value="/board/boardList.do?pageNo=${pageVo.startPage-1}"/>'>Prev</a></span>
    	</c:if>
    	<c:forEach begin="${pageVo.startPage}" end="${pageVo.endPage}" var="num">
       		<span><a href='<c:url value="/board/boardList.do?pageNo=${num}"/>'>${num}</a></span>
   	 	</c:forEach>
        <c:if test="${pageVo.next && pageVo.endPage>0}">
        	<span><a href='<c:url value="/board/boardList.do?pageNo=${pageVo.endPage+1}"/>'>Next</a></span>
    	</c:if>
    	<!-- last -->
    	<c:if test="${pageVo.pageNo <= totalCnt}">
    		<span><a href='<c:url value="/board/boardList.do?pageNo=${pageVo.tempEndPage}"/>'>Last</a></span>
    	</c:if>
	</ul>
</form>
	
</body>
</html>