<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/18/2025
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tìm Kiến thông tin tốt nghiệp và vệc làm</title>
</head>
<body>
<div>
    <div>
        <%--@elvariable id="sinhVien" type=""--%>
        <form:form action="search-totnghiep-vieclam" method="get" modelAttribute="keyword">
            <h3>Tìm Kiến thông tin tốt nghiệp và vệc làm của sinh viên</h3>
            <label>Nhập thông tin sinh viên: </label>
            <form:input path="soCMND"></form:input>
        </form:form>
    </div>
    <div>
        <h4>Kết quả tìm kiếm</h4>
        <table border="2">
            <tr>
                <th>Số CMND</th>
                <th>Họ tên</th>
                <th>Mã ngành</th>
                <th>Mã trường </th>
                <th>Tên Công Ty</th>
                <th>Thời gian làm việc</th>
            </tr>
            <tr>
                <td></td>
            </tr>
        </table>
    </div>
</div>

</body>
</html>
