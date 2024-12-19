<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Web Study</title>
</head>
<body>
<h1>스프링 기초 학습중</h1>
<ul>
    <li>
        <a href="/score/page">성적관리</a>
    </li>
    <li>
        <a href="/board/list">개시판관리</a>
    </li>
</ul>
<script>
    fetch('/api/v1/boards')
        .then(res => res.json())
        .then(data => {
            console.log(data);
        })

</script>
</body>
</html>