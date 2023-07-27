<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
          crossorigin="anonymous">
    <!-- icon -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
          rel="stylesheet"/>
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
            <%-- code giao diện size --%>
            <div class="container">
                <div class="row gy-5">
                    <form method="" action="/khach-hang/search" class="col-9">
                        <div class="row">
                            <%--                            //tìm kiếm--%>
                            <div class="col-7">
                                <input type="text" name="timKiem" class="me-2 rounded-4">
                                <button type="submit" class="me-1 rounded-5 border border-white"
                                        style="background: #0BA3E5">Tìm kiếm
                                </button>
                                <button
                                        type="submit" style="background: #F7FC10"
                                        class="rounded-5 border border-white">Làm mới
                                </button>
                            </div>
                            <%--                            //lọc combobox--%>
                            <div class="col-5">
                                <div class="row">
                                    <div class="col-5">
                                        <label>Trạng thái</label>:
                                    </div>
                                    <div class="col-7">
                                        <select name="status"
                                                class="form-select form-select-sm"
                                                aria-label=".form-select-sm example">
                                            <option value="0">Kích hoạt</option>
                                            <option value="1">Ngừng kích hoạt</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="col-3">
                        <button class="rounded-2 border border-white ms-3"
                                style="background: #0BA3E5"><a href="/khach-hang/view-add"
                                                               style="text-decoration: none" class="text-black"><i
                                class="bi bi-plus-lg"></i> Tạo tài
                            khoản</a></button>
                        <br>
                    </div>
                </div>
                <table class="table" ng-app="app" ng-controller="app-ctrl">
                    <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Tên tài khoản</th>
                        <th scope="col">Email</th>
                        <th scope="col">Họ và tên</th>
                        <th scope="col">SDT</th>
                        <th scope="col">Ngày tạo</th>
                        <th scope="col">Trạng thái</th>
                        <th scope="col">Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${lst}" var="kh" varStatus="i">
                        <tr>
                            <th scope="row">${i.index+1}</th>
                            <td>${kh.taiKhoan}</td>
                            <td>${kh.email}</td>
                            <td>${kh.hoTen}</td>
                            <td>${kh.sdt}</td>
                            <td>${kh.ngayTao}</td>
                            <td>${kh.trangThai==0?"Kích hoạt":"Ngừng kích hoạt"}</td>
                            <td>
                                <a class="text-success fw-bold" style="text-decoration: none" href="/khach-hang/view-update/${kh.id}">SỬA</a>
                                &emsp;
                                <a class="text-danger fw-bold" style="text-decoration: none" onclick="if(confirm('Bạn có chắc chắn muốn xoá không?')){
                                                window.location.href = '/khach-hang/delete/${kh.id}';
                                                }
                                                else{alert('Dữ liệu không được xoá!')}">XÓA
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <%-- phân trang --%>
                <div class="container-fluid mt-5">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <li class="page-item ${currentPage<=0?" disabled":""}"><a
                                    class="page-link"
                                    href="/khach-hang/hien-thi/${currentPage-1}">Previous</a>
                            </li>
                            <c:forEach begin="1" end="${totalsPage}" var="i">
                                <li class="page-item"><a class="page-link"
                                                         href="/khach-hang/hien-thi/${i-1}">${i}</a></li>
                            </c:forEach>
                            <li class="page-item ${currentPage>=totalsPage-1?"disabled":""}"><a class="page-link"
                                                                                                href="/khach-hang/hien-thi/${currentPage+1}">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>