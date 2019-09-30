<div class="container">
  <div class="row">
    <div class="col-md-6">
      <h2>Przeglądaj</h2>
      <p>Przeglądaj nasze bogate zbiory. Filtruj i wyszukuj pozycje po interesującej Cię kategori.
        Wyświetl
        szczegółowy widok konkretnej książki.</p>
      <p><a class="btn btn-secondary" href="book-list?part=0&hasAudio=0&kind=0"
            role="button">Przejdź dalej »</a></p>
    </div>
    <div class="col-md-6">
      <h2>Rezerwacje</h2>
      <p>W dowolnej chwili zarezerwuj wybraną przez siebię książkę, lub anuluj swoją obecną
        rezerwację. Sprawdź, czy
        książka która Cię interesuje, jest aktualnie dostępna.</p>
        <#if (siteType) == "guest">
          <p><a href="#" class="btn btn-secondary disabled" tabindex="-1" aria-disabled="true"
                role="button">Przejdź dalej »</a></p>
        </#if>
        <#if (siteType) == "user" || (siteType) == "admin">
          <p><a href="/reservation-list" class="btn btn-secondary"
                role="button">Przejdź dalej »</a></p>
        </#if>
    </div>
  </div>
</div>