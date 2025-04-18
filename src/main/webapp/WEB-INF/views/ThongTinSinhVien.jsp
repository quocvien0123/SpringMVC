<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Thông tin sinh viên</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1400px;
            margin: 40px auto;
            background: #fff;
            padding: 25px 40px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        h3 {
            margin-bottom: 20px;
            color: #333;
        }

        label, .form-label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="date"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .text-danger {
            color: red;
            font-size: 13px;
        }

        .form-actions {
            margin-top: 20px;
            display: flex;
            gap: 10px;
        }

        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            color: white;
        }

        .btn-success {
            background-color: #28a745;
        }

        .btn-primary {
            background-color: #007bff;
        }

        .btn-secondary {
            background-color: #6c757d;
        }

        .alert-danger {
            background-color: #f8d7da;
            padding: 10px;
            margin-bottom: 15px;
            color: #721c24;
            border: 1px solid #f5c6cb;
            border-radius: 5px;
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
    <%--@elvariable id="sinhVien" type=""--%>
    <form:form action="add" method="POST" modelAttribute="sinhVien">
        <h3>Thông tin sinh viên</h3>

        <c:if test="${not empty error}">
            <div class="alert-danger">${error}</div>
        </c:if>

        <form:label path="soCMND" cssClass="form-label">Số CMND</form:label>
        <form:input path="soCMND"/>
        <form:errors path="soCMND" cssClass="text-danger"/>

        <form:label path="hoTen" cssClass="form-label">Họ Tên</form:label>
        <form:input path="hoTen"/>
        <form:errors path="hoTen" cssClass="text-danger"/>

        <form:label path="email" cssClass="form-label">Email</form:label>
        <form:input path="email"/>
        <form:errors path="email" cssClass="text-danger"/>

        <form:label path="soDT" cssClass="form-label">SĐT</form:label>
        <form:input path="soDT"/>
        <form:errors path="soDT" cssClass="text-danger"/>

        <form:label path="diaChi" cssClass="form-label">Địa chỉ</form:label>
        <form:input path="diaChi"/>
        <form:errors path="diaChi" cssClass="text-danger"/>

        <h3>Thông tin tốt nghiệp</h3>

        <label>Trường</label>
        <select id="selectTruong">
            <c:forEach var="truong" items="${truongs}">
                <option value="${truong.tenTruong}" data-ma="${truong.maTruong}">
                        ${truong.tenTruong}
                </option>
            </c:forEach>
        </select>

        <label>Mã trường</label>
        <input type="text" id="maTruongInput" name="maTruong" readonly>

        <label>Ngành</label>
        <select id="selectNganh">
            <c:forEach var="nganh" items="${nganhs}">
                <option value="${nganh.tenNganh}" data-ma="${nganh.maNganh}">
                        ${nganh.tenNganh}
                </option>
            </c:forEach>
        </select>

        <label>Mã ngành</label>
        <input type="text" id="maNganhInput" name="maNganh" readonly>

        <form:label path="heTN" cssClass="form-label">Hệ tốt nghiệp</form:label>
        <form:input path="heTN"/>
        <form:errors path="heTN" cssClass="text-danger"/>

        <form:label path="ngayTN" cssClass="form-label">Ngày tốt nghiệp</form:label>
        <form:input path="ngayTN" type="date"/>
        <form:errors path="ngayTN" cssClass="text-danger"/>

        <form:label path="loaiTN" cssClass="form-label">Loại tốt nghiệp</form:label>
        <form:input path="loaiTN"/>
        <form:errors path="loaiTN" cssClass="text-danger"/>

        <div class="form-actions">
            <button type="submit" class="btn btn-success" style="font-size: 17px">Thêm sinh viên</button>
            <a href="search" class="btn btn-primary">Tìm kiếm 1</a>
            <a href="search-totnghiep-vieclam" class="btn btn-secondary">Tìm kiếm 2</a>
        </div>
    </form:form>
    <table>
        <tr>
            <th>Số CMND</th>
            <th>Họ tên</th>
            <th>Email</th>
            <th>SĐT</th>
            <th>Địa chỉ</th>
            <th>Mã trường</th>
            <th>Mã ngành</th>
            <th>Hệ tốt nghiệp</th>
            <th>Ngày tốt nghiệp</th>
            <th>Loại tốt nghiệp</th>
            <th></th>
        </tr>
        <c:forEach items="${tableData}" var="td">
           <tr>
               <td>${td.soCMND}</td>
               <td>${td.hoTen}</td>
               <td>${td.soDT}</td>
               <td>${td.email}</td>
               <td>${td.diaChi}</td>
               <td>${td.maTruong}</td>
               <td>${td.maNganh}</td>
               <td>${td.heTN}</td>
               <td>${td.ngayTN}</td>
               <td>${td.heTN}</td>
               <td>
                   <a href="edit?soCMND=${td.soCMND}">
                       <button >Sửa</button>
                   </a>
                   <a href="">
                       <button>Xóa</button>
                   </a>
               </td>
           </tr>
        </c:forEach>
    </table>
</div>


<script>
    document.getElementById("selectTruong").addEventListener("change", function () {
        const selectedOption = this.options[this.selectedIndex];
        document.getElementById("maTruongInput").value = selectedOption.getAttribute("data-ma");
    });

    document.getElementById("selectNganh").addEventListener("change", function () {
        const selectedOption = this.options[this.selectedIndex];
        document.getElementById("maNganhInput").value = selectedOption.getAttribute("data-ma");
    });

    window.addEventListener("DOMContentLoaded", () => {
        document.getElementById("selectTruong").dispatchEvent(new Event("change"));
        document.getElementById("selectNganh").dispatchEvent(new Event("change"));
    });
</script>
</body>
</html>
