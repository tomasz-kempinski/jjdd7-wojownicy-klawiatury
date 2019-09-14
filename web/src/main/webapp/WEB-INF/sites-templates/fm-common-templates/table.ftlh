<div id="table-container" class="container">
  <div class="custom-control custom-switch">
    <input type="checkbox" class="custom-control-input" id="customSwitch1">
    <label class="custom-control-label" for="customSwitch1">Filtruj pozycje z Audiobookiem</label>
  </div>
  <table class="table table-hover table-bordered table-striped space">
    <thead class="thead-dark">
    <tr>
      <th scope="col" class="text-center">#</th>
      <th scope="col" class="text-center">Tytuł</th>
      <th scope="col" class="text-center">Autor</th>
      <th scope="col" class="text-center">Gatunek</th>
    </tr>
    </thead>
    <tbody>
    <#list books>
        <#items as book>
          <tr>
            <th scope="row" class="text-center">${book.id}</th>
            <td>${book.title}</td>
            <td>${book.author.authorName}</td>
            <td></td>
          </tr>
        </#items>
    </#list>
    </tbody>
  </table>
</div>
