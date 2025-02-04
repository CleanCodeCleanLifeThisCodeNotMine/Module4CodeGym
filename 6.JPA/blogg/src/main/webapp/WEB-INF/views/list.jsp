<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Blog</title>
</head>
<body>
<h1>Danh sách các Blog</h1>
<a href="<spring:url value='/blogs/new'/>">Tạo Blog mới</a>
<table border="1">
    <thead>
    <tr>
        <th>Tiêu đề</th>
        <th>Ngày tạo</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="blog" items="${blogs}">
        <tr>
            <td><a href="<spring:url value='/blogs/${blog.id}'/>">${blog.title}</a></td>
            <td>${blog.createdAt}</td>
            <td>
                <a href="<spring:url value='/blogs/edit/${blog.id}'/>">Sửa</a> |
                <form action="<spring:url value='/blogs/delete/${blog.id}'/>" method="post" style="display:inline;">
                    <button type="submit">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
