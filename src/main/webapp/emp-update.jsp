<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bkap</title>
</head>
<c:url value="/" var="rootPath" />
<body>
	<span style="color: blue">${msgOk}</span>
	<span style="color: red">${msgErr}</span>
	<form action="${rootPath}employee-update" method="post">
		<table border="1">
			<caption>
				<h2>Cập nhật nhân viên</h2>
			</caption>
			<input type="text" name="txtId" readonly="readonly" hidden="hidden"
				value="${emp.id}" />
			<tr>
				<th>Phòng ban</th>
				<td><select name="optDeparment">
						<c:forEach items="${lstDep}" var="dep">
							<option value="${dep.id}"
								${dep.id == emp.iddep? "selected='selected'":""}>${dep.name}</option>
						</c:forEach>
				</select></td>

			</tr>
			<tr>
				<th>Họ và tên</th>
				<td><input type="text" name="txtFullname" required="required"
					value="${emp.fullname}" /></td>
			</tr>
			<tr>
				<th>Địa chỉ</th>
				<td><input type="text" name="txtAddress" value="${emp.address}" /></td>
			</tr>
			<tr>
				<th>Năm sinh</th>
				<td><input type="date" name="txtBirthday" value="${emp.birthday}" /></td>
			</tr>
			<tr>
				<th>Giới tính</th>
				<td><input type="radio" name="radGender" value="1"
					checked="checked" /> Nam <input type="radio" name="radGender"
					value="0" /> Nữ</td>
			</tr>
			<tr>
				<th>Lương</th>
				<td><input type="number" step="1000" min="0" name="txtSalary"
					value="${emp.salary}" /></td>
			</tr>
			<tr>
				<th>Trạng thái</th>
				<td><input type="checkbox" name="chkStatus" value="1"
					checked="checked" /> Đang làm việc</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="reset" value="Làm lại"> <input
					type="submit" value="Đăng ký"></td>
			</tr>
		</table>
	</form>
	<a href="${rootPath}employee-list">Trang chủ</a>
</body>
</html>