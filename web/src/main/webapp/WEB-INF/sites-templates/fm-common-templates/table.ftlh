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

    <#list bookJsonClasses>
        <#items as bookJsonClass>
          <tr>
            <th scope="row">${bookJsonClass.id}</th>
            <td>${bookJsonClass.title}</td>
            <td>${bookJsonClass.author}</td>
            <td>${bookJsonClass.genres}</td>
          </tr>
        </#items>
    </#list>
    </tbody>
  </table>
</div>