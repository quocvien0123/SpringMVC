
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Tìm kiếm sinh viên</title>
</head>
<body>
    <div>
        <div>
            <%--@elvariable id="keyword" type=""--%>
            <form:form action="search-result" modelAttribute="keyword" method="get">
                <h3>Tìm kiếm thông tin sinh viên</h3>
                <label>Nhập thông tin sinh viên: </label>
                <form:input path="soCMND"></form:input>
                <button type="submit">Tìm kiếm</button>
            </form:form>
        </div>
        <div>
            <h4>Kết quả tìm kiếm</h4>
            <table border="2">
                <tr>
                    <th>Số CMND</th>
                    <th>Họ tên</th>
                    <th>SĐT</th>
                    <th>Email</th>
                    <th>Địa chỉ</th>
                </tr>
                <c:forEach var="sv" items="${sinhVien}">
                    <td>${sv.soCMND}</td>
                    <td>${sv.hoTen}</td>
                    <td>${sv.soDT}</td>
                    <td>${sv.email}</td>
                    <td>${sv.diaChi}</td>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
