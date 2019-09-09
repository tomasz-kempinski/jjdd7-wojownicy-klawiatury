<%--
  Created by IntelliJ IDEA.
  User: kacperrucinski
  Date: 09.09.2019
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.infoshareacademy.wojownicy.dao.BookDaoBeen" %>
<%@ page import="java.util.List" %>
<%@ page import="com.infoshareacademy.wojownicy.domain.Book" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pl">

<head>
    <%@include file="WEB-INF/sites-templates/fm-common-templates/main-template.ftlh" %>
</head>
<body>
<header>
    <%@include file="WEB-INF/sites-templates/fm-common-templates/navbar.ftlh" %>
</header>


<%
    String order = request.getParameter("order");
    String bookTitle = request.getParameter("title");
    String orderTitle;
    if (order == null || order.isEmpty() || order.equals("title")) {
        orderTitle = " (wg tytułu)";
        order = "title";
    } else orderTitle = " (wg autora)";
%>
<article>
    <div class="content">
        <div class="contentInside">
            <br/>
            <h4>Spis książek<%=orderTitle%>
            </h4>
            <table class="table table-bordered table-hover">
                <thead class="listofitemps">
                <tr class="black white-text">
                    <th scope="col">#</th>
                    <th scope="col">Tytuł</th>
                    <th scope="col">Autor</th>
                </tr>
                </thead>
                <tbody>
                <%
                    int rowNumber = 1;
                    BookDaoBeen bookDaoBeen = new BookDaoBeen();
                    List<Book> listOfBooks = (List<Book>) bookDaoBeen.searchBook(bookTitle, order);
                    for (Book book : listOfBooks) {
                %>

                <tr class="listofitemps" style="cursor:pointer"
                    onclick="window.location='bookDescription.jsp?id=<%=book.getId()%>'" data-toggle="tooltip"
                    title="Zobacz więcej ...">
                    <th scope="row"><%=rowNumber%>
                    </th>
                    <td><%=book.getTitle()%>
                    </td>
                    <td><%=book.getAuthor()%>
                    </td>
                </tr>
                <%
                        rowNumber++;
                    }%>
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-end">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">Previous</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
            <br/><br/><br/>
        </div>
    </div>
</article>

<footer>
    <%@include file="WEB-INF/sites-templates/fm-common-templates/footer.ftlh" %>
</footer>

</body>
</html>