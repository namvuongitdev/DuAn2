<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <%--            code giao diện màu sắc --%>
            <div class="container">
                <nav class="navbar navbar-light" style="height:30px">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#"><font color="black">Danh Sách</font></a>
                    </div>
                </nav>
                <hr>
                <div style="margin-left: 460px"><font color="#696969"><h5>THÊM MÀU SẮC</h5></font></div>

                <p style="margin-left: 20px">Tên màu sắc :</p>
                <input name="ten" class="form-control"
                       type="text" style="margin-left: 20px;width: 1000px">
                <br>
                <p style="margin-left: 20px">Trạng thái :</p>
                <input type="radio" style="margin-left: 60px" name="trangthai" value="1" checked="checked"> Kích Hoạt
                <br>
                <input type="radio" style="margin-left: 60px" name="trangthai" value="0"> Ngừng Kích Hoạt
                <br>
                <button type="button" class="btn btn-info" style="margin-left: 900px;border-top-left-radius: 20px;
                border-bottom-left-radius: 20px;
                border-bottom-right-radius: 20px;
                border-top-right-radius: 20px">
                    Xác
                    Nhận
                </button>

                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Tên màu sắc</th>
                        <th scope="col">Trạng thái</th>
                        <th scope="col">Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list.getContent()}" var="mau" varStatus="i">
                        <tr>
                            <th scope="row">${i.index + page}</th>
                            <td>${mau.ten}</td>
                            <td>${mau.trangThai}</td>
                            <td>
                                <button type="button" class="btn btn-info"
                                        style="border-top-left-radius: 20px;
                                        border-bottom-left-radius: 20px;
                                        border-bottom-right-radius: 20px;
                                        border-top-right-radius: 20px;background: lawngreen">Update

                                </button>
                                <button type="button" class="btn btn-info"
                                        style="margin-left: 10px;border-top-left-radius: 20px;
                                        border-bottom-left-radius: 20px;
                                        border-bottom-right-radius: 20px;
                                        border-top-right-radius: 20px;background: red"
                                        onclick="if(confirm('Bạn có chắc chắn muốn xoá không?')){window.location.href = '/mausac/delete/${mau.id}';}
                                                else{alert('Dữ liệu không được xoá!')}">Remove

                                </button>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

                <%--                phân trang --%>
                <div style="margin-left: 500px;margin-top: 20px">
                    <c:if test="${list.getNumber() gt 0}">
                        <button style="background: whitesmoke;border-style: none">
                            <a href="?page=${list.getNumber()}">
                                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor"
                                     class="bi bi-skip-backward" viewBox="0 0 16 16">
                                    <path d="M.5 3.5A.5.5 0 0 1 1 4v3.248l6.267-3.636c.52-.302 1.233.043 1.233.696v2.94l6.267-3.636c.52-.302 1.233.043 1.233.696v7.384c0 .653-.713.998-1.233.696L8.5 8.752v2.94c0 .653-.713.998-1.233.696L1 8.752V12a.5.5 0 0 1-1 0V4a.5.5 0 0 1 .5-.5zm7 1.133L1.696 8 7.5 11.367V4.633zm7.5 0L9.196 8 15 11.367V4.633z"/>
                                </svg>
                            </a>
                        </button>

                    </c:if>

                    <span>${list.getNumber()+1}/${list.getTotalPages()}</span>

                    <c:if test="${list.getNumber() lt list.getTotalPages() - 1}">
                        <button style="background: whitesmoke;border-style: none">
                            <a href="?page=${list.getNumber()+2}">
                                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor"
                                     class="bi bi-skip-forward" viewBox="0 0 16 16">
                                    <path d="M15.5 3.5a.5.5 0 0 1 .5.5v8a.5.5 0 0 1-1 0V8.752l-6.267 3.636c-.52.302-1.233-.043-1.233-.696v-2.94l-6.267 3.636C.713 12.69 0 12.345 0 11.692V4.308c0-.653.713-.998 1.233-.696L7.5 7.248v-2.94c0-.653.713-.998 1.233-.696L15 7.248V4a.5.5 0 0 1 .5-.5zM1 4.633v6.734L6.804 8 1 4.633zm7.5 0v6.734L14.304 8 8.5 4.633z"/>
                                </svg>
                            </a>
                        </button>
                    </c:if>

                </div>
            </div>
        </div>


    </div>
</div>

</body>
</html>