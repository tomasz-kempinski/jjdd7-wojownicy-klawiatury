<div id="table-container" class="container">
  <div class="custom-control custom-switch">
    <input type="checkbox" class="custom-control-input" id="customSwitch1">
    <label class="custom-control-label" for="customSwitch1">Filtruj pozycje z Audiobookiem</label>
  </div>
  <div class="table-responsive-md">
    <table
        class="table table-hover table-bordered table-striped shadow-lg p-3 mb-5 bg-white rounded">
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
            <tr class="clickable-row" data-href="/book-view" data-toggle="popover-hover"
                data-img="img/fake-cover-thumbnail.jpg">
              <th scope="row" class="text-center">${book.id}</th>
              <td>${book.title}</td>
              <td>${book.author.authorName}</td>
              <td><#list book.genres><#items as genre>${genre}</#items></#list></td>
            </tr>
          </#items>
      </#list>
      </tbody>
    </table>
  </div>
</div>
