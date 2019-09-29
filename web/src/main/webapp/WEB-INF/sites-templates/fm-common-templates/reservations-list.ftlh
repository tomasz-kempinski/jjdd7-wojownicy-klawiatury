<div id="table-container" class="container">
    <div class=“row”>
    </div>
      <div class=“col-md text-center”>
  </div>
  <div class="table-responsive-md">
    <br>
    <table
        class="table table-bordered table-striped shadow-lg p-3 mb-5 bg-white rounded">
      <thead class="thead-dark">
      <tr>
        <th scope="col" class="text-center">#</th>
        <th scope="col" class="text-center">Tytuł</th>
        <th scope="col" class="text-center">Autor</th>
        <th scope="col" class="text-center"></th>
      </tr>
      </thead>
      <tbody>
      <#assign i=1>
      <#list reservations>
          <#items as reservation>
            <tr>
            <th scope="row" class="text-center">${i}</th>
            <td>${reservation.book.title}</td>
            <td>${reservation.book.author.authorName}</td>
            <td><button type="button" data-id="${reservation.id}" class="btn btn-danger cancel">Anuluj rezerwacje</button></td>
            </tr>
              <#assign i=i+1>
          </#items>
      </#list>
      </tbody>
    </table>
  </div>
</div>
