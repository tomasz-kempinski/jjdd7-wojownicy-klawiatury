<div id="table-container" class="container">
  <div class="custom-control custom-switch">
    <input type="checkbox" class="custom-control-input" id="customSwitch1" disabled>
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
        <th scope="col" class="text-center">Rodzaj</th>
      </tr>
      </thead>
      <tbody>
      <#list books>
          <#items as book>
            <tr class="clickable-row" data-href="/book-view?id=${book.id}&part=${page.previous}"
                data-toggle="popover-hover"
                data-img="https://wolnelektury.pl/media/${book.thumbnail}">
              <th scope="row" class="text-center">${book.id}</th>
              <td>${book.title}</td>
              <td>${book.author.authorName}</td>
              <td>${book.kind.kind}</td>
            </tr>
          </#items>
      </#list>
      </tbody>
    </table>
  </div>
</div>
