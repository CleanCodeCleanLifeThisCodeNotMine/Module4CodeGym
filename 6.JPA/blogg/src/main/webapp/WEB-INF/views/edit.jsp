<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
  <title>Cập nhật Blog</title>
</head>
<body>
<h1>Cập nhật Blog</h1>
<form action="<spring:url value='/blogs/edit/${blog.id}'/>" method="post">
  <div>
    <label for="title">Tiêu đề:</label>
    <input type="text" id="title" name="title" value="${blog.title}" required/>
  </div>
  <div>
    <label for="content">Nội dung:</label>
    <textarea id="content" name="content" required>${blog.content}</textarea>
  </div>
  <div>
    <button type="submit">Cập nhật</button>
  </div>
</form>
<a href="<spring:url value='/blogs/${blog.id}'/>">Quay lại bài viết</a>
</body>
</html>
