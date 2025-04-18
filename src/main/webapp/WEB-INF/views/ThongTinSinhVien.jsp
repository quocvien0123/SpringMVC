<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/15/2025
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Thông tin sinh viên</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>


<%--@elvariable id="sinhVien" type=""--%>
<div class="mb-3">
    <form:form action="add" method="POST" modelAttribute="sinhVien">
        <h3>Thông tin sinh viên</h3>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <form:label path="soCMND" cssClass="form-label">Số CMND: </form:label>
        <form:input path="soCMND" cssClass="form-control" /><br>
        <form:errors path="soCMND" cssClass="form-label"/><br>

        <form:label path="hoTen">Họ Tên: </form:label>
        <form:input path="hoTen"/><br>
        <form:errors path="hoTen"/><br>

        <form:label path="email">Email: </form:label>
        <form:input path="email"/><br>
        <form:errors path="email"/><br>

        <form:label path="soDT">SĐT: </form:label>
        <form:input path="soDT"/><br>
        <form:errors path="soDT"/><br>

        <form:label path="diaChi">Địa chỉ: </form:label>
        <form:input path="diaChi"/><br>
        <form:errors path="diaChi"/><br>

        <h3>Thông tin tốt nghiệp</h3>

        <!-- Trường -->
        <label>Trường: </label>
        <select id="selectTruong">
            <c:forEach var="truong" items="${truongs}">
                <option value="${truong.tenTruong}" data-ma="${truong.maTruong}">
                        ${truong.tenTruong}
                </option>
            </c:forEach>
        </select><br><br>

        <label>Mã trường: </label>
        <input type="text" id="maTruongInput" name="maTruong" readonly><br><br>

        <!-- Ngành -->
        <label>Ngành: </label>
        <select id="selectNganh">
            <c:forEach var="nganh" items="${nganhs}">
                <option value="${nganh.tenNganh}" data-ma="${nganh.maNganh}">
                        ${nganh.tenNganh}
                </option>
            </c:forEach>
        </select><br><br>

        <label>Mã ngành: </label>
        <input type="text" id="maNganhInput" name="maNganh" readonly><br><br>


        <form:label path="heTN">Hệ tốt nghiệp: </form:label>
        <form:input path="heTN"/><br>
        <form:errors path="heTN"/><br>

        <form:label path="ngayTN">Ngày tốt nghiệp: </form:label>
        <form:input path="ngayTN" type="date"/><br>
        <form:errors path="ngayTN"/><br>

        <form:label path="loaiTN">Loại tốt nghiệp: </form:label>
        <form:input path="loaiTN"/><br>
        <form:errors path="loaiTN"/><br>

        <button type="submit" class="btn-success">Thêm</button>

    </form:form>
</div>
<a href="search">
    <button> Tìm kiếm 1</button>
</a>

<a href="search-totnghiep-vieclam">
    <button> Tìm kiếm 2</button>
</a>
<script>
    // Trường
    document.getElementById("selectTruong").addEventListener("change", function () {
        const selectedOption = this.options[this.selectedIndex];
        const maTruong = selectedOption.getAttribute("data-ma");
        document.getElementById("maTruongInput").value = maTruong;
    });

    // Ngành
    document.getElementById("selectNganh").addEventListener("change", function () {
        const selectedOption = this.options[this.selectedIndex];
        const maNganh = selectedOption.getAttribute("data-ma");
        document.getElementById("maNganhInput").value = maNganh;
    });

    // Tự động load giá trị mặc định khi trang vừa load
    window.addEventListener("DOMContentLoaded", () => {
        document.getElementById("selectTruong").dispatchEvent(new Event("change"));
        document.getElementById("selectNganh").dispatchEvent(new Event("change"));
    });
</script>

</body>
</html>
