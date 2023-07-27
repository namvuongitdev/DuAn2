<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>

</head>
<body>
<%--navbar--%>
<jsp:include page="../sidebar/navbar.jsp"/>
<%--sidebar--%>
<div class="container-fluid">
    <div class="row flex-nowrap">
        <jsp:include page="../sidebar/sidebar.jsp"/>
        <div class="col py-3">
            <%--            code giao diện size --%>
            <div class="container-fluid">
                <div class="row">
                    <h3 class="text-center" style="margin-bottom: 30px">Tạo Tài Khoản Khách Hàng</h3>
                </div>
                <%--@elvariable id="khachHang" type=""--%>
                <form:form class="row g-3" modelAttribute="khachHang" action="/khach-hang/add" method="post">
                    <%--row1--%>
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <label class="fw-bold">Tên tài khoản</label>
                        <form:input path="taiKhoan" type="text" class="form-control"/>
                        <form:errors path="taiKhoan" cssStyle="color: red"/>
                    </div>
                    <div class="col-md-2"></div>

                    <%--row2--%>
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <label class="fw-bold">Họ và tên</label>
                        <form:input path="hoTen" type="text" class="form-control"/>
                        <form:errors path="hoTen" cssStyle="color: red"/>
                    </div>
                    <div class="col-md-2"></div>

                    <%--row3--%>
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <label class="fw-bold">Email</label>
                        <form:input path="email" type="text" class="form-control"/>
                        <form:errors path="email" cssStyle="color: red"/>
                    </div>
                    <div class="col-md-2"></div>

                    <form:button style="background:#0BA3E5;width: 108px;height: 36px;margin-left: 900px" class="rounded-3 mt-5"  type="submit" onclick="if(confirm('Bạn có chắc chắn muốn thêm không?')){window.location.href = '/khach-hang/adđ';}
                                                else{alert('Dữ liệu không được thêm!')}">Xác nhận</form:button>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>