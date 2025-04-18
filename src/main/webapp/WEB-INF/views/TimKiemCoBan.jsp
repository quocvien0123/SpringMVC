<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Tìm kiếm sinh viên</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }

        .container {
            max-width: 800px;
            margin: auto;
            background: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h3, h4 {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        button {
            padding: 8px 16px;
            background-color: #28a745;
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
            border: 1px solid #ccc;
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
    <form:form action="search-result" modelAttribute="keyword" method="get">
        <h3>Tìm kiếm thông tin sinh viên</h3>
        <label>Nhập thông tin sinh viên:</label>
        <form:input path="soCMND"/>
        <button type="submit">Tìm kiếm</button>
    </form:form>

    <h4>Kết quả tìm kiếm</h4>
    <table>
        <tr>
            <th>Số CMND</th>
            <th>Họ tên</th>
            <th>SĐT</th>
            <th>Email</th>
            <th>Địa chỉ</th>
        </tr>
        <c:forEach items="${sinhVien}" var="sv">
            <tr>
                <td>${sv.soCMND}</td>
                <td>${sv.hoTen}</td>
                <td>${sv.soDT}</td>
                <td>${sv.email}</td>
                <td>${sv.diaChi}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
