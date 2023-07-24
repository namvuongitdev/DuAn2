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
            <%--            code giao diện khách hàng --%>
            <div class="container-fluid">
                <div class="row">
                    <h3 class="text-center" >Cập nhật thông tin</h3>
                </div>
                    <%--@elvariable id="khachHang" type=""--%>
                    <form:form class="text-center" modelAttribute="khachHang" action="/khach-hang/update/${khachHang.id}" method="post">
                        <div class="row">
                            <div class="col-6">
                                <label style="font-weight: bold;font-size: 15px;font-family: 'Inter', sans-serif;">Tên tài khoản</label>&nbsp;<form:input style="width: 361px;height: 46px" readonly="true" path="taiKhoan" class="rounded-3 mt-5"/><form:errors path="taiKhoan" cssStyle="color: red"/>
                            </div>
                            <div class="col-6">
                                <label style="font-weight: bold;font-size: 15px;font-family: 'Inter', sans-serif;">Số điện thoại</label>&nbsp;<form:input path="sdt" style="width: 361px;height: 46px" class="rounded-3 mt-5"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label style="font-weight: bold;font-size: 15px;font-family: 'Inter', sans-serif;">Họ và tên</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:input path="hoTen" readonly="true" style="width: 361px;height: 46px" class="rounded-3 mt-5"/>
                            </div>
                            <div class="col-6">
                                <label style="font-weight: bold;font-size: 15px;font-family: 'Inter', sans-serif;">Địa chỉ</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:input path="diaChi" style="width: 361px;height: 46px" class="rounded-3 mt-5"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label style="font-weight: bold;font-size: 15px;font-family: 'Inter', sans-serif;">Email</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:input readonly="true" path="email" style="width: 361px;height: 46px;font-family: 'Inter', sans-serif;" class="rounded-3 mt-5"/>
                            </div>
                            <div class="col-6 mt-4">
                                <label class="mt-3" style="font-weight: bold;font-size: 15px;font-family: 'Inter', sans-serif;">Trạng thái</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
                                <form:radiobutton path="trangThai" value="0"/>Hoạt động&nbsp;&nbsp;&nbsp;&nbsp;
                                <form:radiobutton path="trangThai" value="1"/>Ngừng hoạt động
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label style="font-weight: bold;font-size: 15px;font-family: 'Inter', sans-serif;">Mật khẩu</label>&nbsp;&nbsp;&nbsp;&nbsp;<form:input type="password" path="matKhau" style="width: 361px;height: 46px" class="rounded-3 mt-5"/>
                            </div>
                        </div>
                        <form:button style="background:#0BA3E5;width: 108px;height: 36px;margin-left: 700px;font-size: 15px;font-family: 'Inter', sans-serif;" class="rounded-3 mt-5"  type="submit" onclick="if(confirm('Bạn có chắc chắn muốn thay đổi thông tin không?')){window.location.href = '/khach-hang/update/${kh.id}';}
                                                else{alert('Dữ liệu không được thay đổi!')}">Xác nhận</form:button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>