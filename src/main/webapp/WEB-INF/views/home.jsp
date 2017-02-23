<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Blog</title>
    <link rel="stylesheet"
              type="text/css"
              href="<c:url value="/resources/bootstrap.min.css" />" >
    <link rel="stylesheet"
              type="text/css"
              href="<c:url value="/resources/bootstrap-theme.min.css" />" >
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Welcome to my blog</h1>
    <a href="<c:url value="/posts" />">Posts</a>
    <
  </body>
</html>