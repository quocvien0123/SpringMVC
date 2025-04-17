
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
        <%--@elvariable id="keyword" type=""--%>
        <form:form action="" modelAttribute="keyword">
            <h3>Tìm kiếm thông tin sinh viên</h3>
            <label>Nhập số CMND: </label>
            <form:input path=""></form:input>
        </form:form>
    </div>
</body>
</html>
