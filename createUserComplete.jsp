<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/userInfo.css">
<link rel="stylesheet" type="text/css" href="./css/mars.css"/>
<title>ユーザー情報入力完了画面</title>
<script type="text/javascript">
 	window.onload = function(){
 		var form = document.getElementById('form1');
 		setTimeout(function(){form.submit()},3000);
}
</script>
</head>
<body>
<jsp:include page="header.jsp" />

<div id="main">
<h1>ユーザー情報入力完了画面</h1>
<div class="complete">
<span>ユーザー情報入力が完了しました。</span>
</div>
</div>
<!-- ログイン画面に戻る -->
<s:form id="form1" action="LoginAction">
	<s:hidden name="userId" value="%{userId}" />
	<s:hidden name="password" value="%{password}" />
</s:form>
</body>
</html>