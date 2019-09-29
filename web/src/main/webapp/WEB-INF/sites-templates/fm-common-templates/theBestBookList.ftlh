<div id="table-container" class="container">

  <div class="table-responsive-md">
    <br>
    <table
        class="table table-bordered table-striped shadow-lg p-3 mb-5 bg-white rounded">
      <thead class="thead-dark">
      <tr>
        <th scope="col" class="text-center">#</th>
        <th scope="col" class="text-center">Książka</th>
        <th scope="col" class="text-center">Liczba wypożyczeń</th>
      </tr>
      </thead>
      <tbody>
      <#assign i=1>
      <#list bookStatList>
          <#items as book>
            <tr>
              <th scope="row" class="text-center">${i}</th>
              <td>${book.book.title}</td>
              <td>${book.reservedCounter}</td>
            </tr>
              <#assign i=i+1>
          </#items>
      </#list>
      </tbody>
    </table>
  </div>
</div>
