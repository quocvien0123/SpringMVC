<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Tìm Kiến thông tin tốt nghiệp và vệc làm</title>
</head>
<body>
<div>
    <div>
        <%--@elvariable id="keyword" type=""--%>
        <form:form action="search-totnghiep-vieclam-result" method="get" modelAttribute="keyword">
            <h3>Tìm Kiến thông tin tốt nghiệp và vệc làm của sinh viên</h3>
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
                <th>Mã ngành</th>
                <th>Mã trường </th>
                <th>Tên Công Ty</th>
                <th>Thời gian làm việc</th>
            </tr>
            <td>${sinhVien.soCMND}</td>
            <td>${sinhVien.hoTen}</td>
            <td>${sinhVien.maNganh}</td>
            <td>${sinhVien.maTruong}</td>
            <td>${sinhVien.tenCongTy}</td>
            <td>${sinhVien.thoiGianLamViec}</td>
        </table>
    </div>
</div>

</body>
</html>
