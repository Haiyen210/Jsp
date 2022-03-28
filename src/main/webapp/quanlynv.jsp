<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bkap</title>
<script type="text/javascript">
	function deleteItem() {
		var isConfirm = confirm("Are you sure?");
		return isConfirm;
	}
</script>
</head>
<body>
	<h1>Quản lý nhân viên</h1>
	<hr>
	<a href="employee-insert">Thêm mới</a>
	<hr>
	<form action="employee-search" method="get">
		<select name="optDepartment">
			<option value="0">-------Tất cả-------</option>
			<c:forEach items="${lstDep}" var="dep">
				<option value="${dep.id}">${dep.name}</option>
			</c:forEach>
		</select> <input type="text" name="txtSearch"> <input type="submit"
			value="Tìm kiếm">
	</form>
	<!-- 	Show danh sách nhân viên -->
	<table border="1">
		<tr>
			<th>Mã</th>
			<th>Mã Phòng</th>
			<th>Họ và tên</th>
			<th>Địa chỉ</th>
			<th>Ngày sinh</th>
			<th>Giới tính</th>
			<th>Lương</th>
			<th>Trạng thái</th>
			<th>Ảnh đại diện</th>
			<th>Chi tiết</th>
			<th>Cập nhật</th>
			<th>Xóa</th>
		</tr>
		<c:forEach items="${lstEmp}" var="e">
			<tr>
				<td>${e.id}</td>
				<td>${e.iddep}</td>
				<td>${e.fullname}</td>
				<td>${e.address}</td>
				<td>${e.birthday}</td>
				<td>${e.gender? "Nam":"Nữ"}</td>
				<td>${e.salary}</td>
				<td>${e.status? "Đang làm việc":"Nghỉ"}</td>
				<td>${e.imglink}</td>
				<td align="center"><a
					href="employee-detail?idEmp=${e.id}">Chi tiết</a></td>
				<td align="center"><a
					href="employee-update?idEmp=${e.id}">Cập nhật</a></td>
				<td align="center"><a href="employee-delete?idEmp=${e.id}"
					onclick="return deleteItem()">Xóa</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>