<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報入力画面</title>
<link rel="stylesheet" type="text/css" href="./css/userInfo.css"/>
<link rel="stylesheet" type="text/css" href="./css/mars.css"/>
</head>
<body>
<jsp:include page="header.jsp" />

<div id="main">
<h1>ユーザー情報入力画面</h1>

<s:if test="!familyNameErrorMessageList.isEmpty()">		<%--isEmptyは事前に空文字列か判定--%>

	<div class="error">
		<s:iterator value="familyNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>
<s:if test="!firstNameErrorMessageList.isEmpty()">		<%--isEmptyは事前に空文字列か判定--%>
	<div class="error">
	<s:iterator value="firstNameErrorMessageList"><s:property /><br></s:iterator>
</div>
</s:if>
<s:if test="!familyNameKanaErrorMessageList.isEmpty()">		<%--isEmptyは事前に空文字列か判定--%>
	<div class="error">
	<s:iterator value="familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>
<s:if test="!firstNameKanaErrorMessageList.isEmpty()">		<%--isEmptyは事前に空文字列か判定--%>
	<div class="error">
	<s:iterator value="firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>
<s:if test="!emailErrorMessageList.isEmpty()">
	<div class="error">
	<s:iterator value="emailErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>
<s:if test="!userIdErrorMessageList.isEmpty()">
	<div class="error">
	<s:iterator value="userIdErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>
<s:if test="!passwordErrorMessageList.isEmpty()">
	<div class="error">
	<s:iterator value="passwordErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>
<s:if test="!userIdExistErrorMessageList.isEmpty()">
	<div class="error">
	<s:iterator value="userIdExistErrorMessageList"><s:property /><br></s:iterator>
	</div>
</s:if>

<s:form action="CreateUserConfirmAction">
<table class="t1">
<tr>
	<th scope="row">姓</th>
	<td><s:textfield name="familyName" value="%{#session.familyName}" placeholder="姓" class="textfield"  /></td>
</tr>
<tr>
	<th scope="row">名</th>
	<td><s:textfield name="firstName" value="%{#session.firstName}"  placeholder="名" class="textfield"  /></td>
</tr>
<tr>
	<th scope="row">姓ふりがな</th>
	<td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" placeholder="姓ふりがな" class="textfield"   /></td>
</tr>
<tr>
	<th scope="row">名ふりがな</th>
	<td><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" placeholder="名ふりがな" class="textfield"  /></td>
</tr>

<tr>
	<th scope="row">性別</th>
 	<td><s:radio name="sex" list="#session.sexList" value="#session.sex" placeholder="性別" class="textfield-seibetu"  /></td>
</tr>

<tr>
	<th scope="row">メールアドレス</th>
	<td><s:textfield name="email" value="%{#session.email}" placeholder="メールアドレス" class="textfield"  /></td>
</tr>
<tr>
	<th scope="row">ユーザーID</th>
	<td><s:textfield name="userId" value="%{#session.userId}" placeholder="ユーザーID" class="textfield"  /></td>
</tr>
<tr>
	<th scope="row">パスワード</th>
	<td><s:password name="password" value="" placeholder="パスワード" class="textfield" /></td>
</tr>
</table>
<s:submit value="確認" class="submit_btn" />
</s:form>
</div>

</body>
</html>