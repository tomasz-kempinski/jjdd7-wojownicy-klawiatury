<div id="table-container" class="container">


  <div class="table-responsive-md">
    <table
        class="table table-bordered table-striped shadow-lg p-3 mb-5 bg-white rounded">
      <thead class="thead-dark">
      <tr>
        <th scope="col" class="text-center">#</th>
        <th scope="col" class="text-center">Autor</th>
        <th scope="col" class="text-center">Liczba wypożyczeń</th>
      </tr>
      </thead>
      <tbody>
      <#assign i=1>
      <#list authorStatList>
          <#items as author>
              <tr>
            <th scope="row" class="text-center">${i}</th>
            <td>${author.author.authorName}</td>
            <td>${author.reservedCounter}</td>
            </tr>
              <#assign i=i+1>
          </#items>
      </#list>
      </tbody>
    </table>
  </div>
</div>
