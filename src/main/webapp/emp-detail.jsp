<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bkap</title>
</head>
<body>
	<table border="1">
		<caption>
			<h2>Chi tiết nhân viên</h2>
		</caption>
		<tr>
			<th>Phòng ban</th>
			<td>${dep.name}</td>
		</tr>
		<tr>
			<th>Họ và tên</th>
			<td>${emp.fullname}</td>
		</tr>
		<tr>
			<th>Địa chỉ</th>
			<td>${emp.address}</td>
		</tr>
		<tr>
			<th>Năm sinh</th>
			<td><fmt:formatDate dateStyle="MEDIUM" value="${emp.birthday}" />
			</td>
		</tr>
		<tr>
			<th>Giới tính</th>
			<td>${emp.gender? "Nam":"Nữ"}</td>
		</tr>
		<tr>
			<th>Lương</th>
			<td>${emp.salary}</td>
		</tr>
		<tr>
			<th>Tình trạng</th>
			<td>${emp.status?"Đang làm việc":"Nghỉ làm"}</td>
		</tr>
	</table>
	<a href="/employee-list">Trang chủ</a>
</body>
</html>