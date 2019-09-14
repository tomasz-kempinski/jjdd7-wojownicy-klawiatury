
<div id="table1" class="container">
  <table class="table table-hover table-bordered table-striped space">
    <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Tytuł</th>
      <th scope="col">Autor</th>
      <th scope="col">Gatunek</th>
    </tr>
    </thead>
    <tbody>

    <#list books>
        <#items as book>
          <tr>
            <th scope="row">${book.id}</th>
            <td>${book.title}</td>
            <td>${book.author.authorName}</td>
            <td></td>
          </tr>
        </#items>
    </#list>
    </tbody>
  </table>
</div>
