<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
  <title>${blog.title}</title>
</head>
<body>
<h1>${blog.title}</h1>
<p><strong>Ngày tạo: </strong>${blog.createdAt}</p>
<p>${blog.content}</p>
<a href="<spring:url value='/blogs/edit/${blog.id}'/>">Sửa</a> |
<form action="<spring:url value='/blogs/delete/${blog.id}'/>" method="post" style="display:inline;">
  <button type="submit">Xóa</button>
</form>
<br/>
<a href="<spring:url value='/blogs/'/>">Quay lại danh sách</a>
</body>
</html>
