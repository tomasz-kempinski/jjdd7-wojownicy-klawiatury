<div id="table1" class="container">
  <table class="table table-hover table-bordered space">
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
      <th scope="row">id</th>
          <td>${book.name}</td>
          <td>${book.author}</td>
          <td>${book.genre}</td>
    </tr>
    </#items>
    </#list>
    </tbody>
  </table>
  </div>