<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Tìm kiếm thông tin tốt nghiệp và việc làm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            padding: 20px;
        }

        .container {
            max-width: 900px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        h3, h4 {
            margin-bottom: 15px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"] {
            padding: 8px;
            width: 100%;
            margin-bottom: 15px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        button {
            padding: 8px 16px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #007bff;
        }
    </style>
</head>
<body>
<div class="container">
    <%--@elvariable id="keyword" type=""--%>
    <form:form action="search-totnghiep-vieclam-result" method="get" modelAttribute="keyword">
        <h3>Tìm kiếm thông tin tốt nghiệp và việc làm của sinh viên</h3>
        <label>Nhập số CMND:</label>
        <form:input path="soCMND"/>
        <button type="submit">Tìm kiếm</button>
    </form:form>

    <h4>Kết quả tìm kiếm</h4>
    <table>
        <tr>
            <th>Số CMND</th>
            <th>Họ tên</th>
            <th>Mã ngành</th>
            <th>Mã trường</th>
            <th>Tên công ty</th>
            <th>Thời gian làm việc</th>
        </tr>
        <tr>
            <td>${sinhVien.soCMND}</td>
            <td>${sinhVien.hoTen}</td>
            <td>${sinhVien.maNganh}</td>
            <td>${sinhVien.maTruong}</td>
            <td>${sinhVien.tenCongTy}</td>
            <td>${sinhVien.thoiGianLamViec}</td>
        </tr>
    </table>
</div>
</body>
</html>
