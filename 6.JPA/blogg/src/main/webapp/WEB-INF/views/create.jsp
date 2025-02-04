<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
  <title>Tạo Blog mới</title>
</head>
<body>
<h1>Tạo Blog mới</h1>
<form action="<spring:url value='/blogs/'/>" method="post">
  <div>
    <label for="title">Tiêu đề:</label>
    <input type="text" id="title" name="title" required/>
  </div>
  <div>
    <label for="content">Nội dung:</label>
    <textarea id="content" name="content" required></textarea>
  </div>
  <div>
    <button type="submit">Tạo mới</button>
  </div>
</form>
<a href="<spring:url value='/blogs/'/>">Quay lại danh sách</a>
</body>
</html>
