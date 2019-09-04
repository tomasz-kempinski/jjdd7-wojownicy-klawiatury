<!DOCTYPE html>
<html>
<head>
  <title>Welcome User</title>
</head>
<body>
<#if errorMessage??>
  <span style="color: #ff0000;">${errorMessage}</span>
</#if>
<#if book??>
  <ul>
    <li>title: ${book.title}</li>
  </ul>
</#if>
<#if author??>
  <ul>
    <li>author: ${author.authorName}</li>
  </ul>
</#if>
</body>
</html>