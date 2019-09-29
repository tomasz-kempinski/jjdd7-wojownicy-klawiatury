<div id="reservation-table-container" class="container">
  <div class="table-responsive-md">
    <table
        class="table table-bordered table-striped shadow-lg p-3 mb-5 bg-white rounded">
      <thead class="thead-dark">
      <tr>
        <th scope="col" class="text-center">#</th>
        <th scope="col" class="text-center">Zarezerwowana książka</th>
        <th scope="col" class="text-center">Data rezerwacji</th>
      </tr>
      </thead>
      <tbody>
      <#if reservationsForUser?size == 0>
        <div class="container-fluid">
          <h5 class="text-center ">Brak rezerwacji na liście</h5>
        </div>
      <#else>
          <#list reservationsForUser>
              <#items as reservation>
                <th scope="row" class="text-center">${i}</th>
                <td>${reservation.book.title}</td>
                <td>${reservation.reservationDate}</td>
                </tr>
              </#items>
          </#list>
      </#if>
      </tbody>
    </table>
  </div>
</div>