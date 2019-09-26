<div id="book-view" class="container">
  <div class="row">
    <div class="col-md text-center">
      <a class="btn btn-primary nav-button" href="/book-list?part=${part}" role="button">Powrót do listy</a>
    </div>
    <div class="col-md text-center">
      <a class="btn btn-info nav-button" href="/book-edit" role="button">Edytuj książkę</a>
    </div>
    <div class="col-md text-center">
      <a class="btn btn-danger nav-button" href="#" role="button">Usuń książkę</a>
    </div>
  </div>
  <div id="book-card" class="card mb-5 shadow-lg p-3 bg-white rounded"
       style="max-width: 1200px;">
    <div class="row no-gutters">
      <div class="col-md-5">
          <#if book.cover??>
            <img src="https://wolnelektury.pl/media/${book.cover}" class="card-img" alt="book">
          <#else>
            <img src="img/fake-cover.png" alt="book" class="card-img">
          </#if>
      </div>
      <div class="col-md-7">
        <div class="card-body">
          <h2 class="card-title font-weight-bold">${book.title}</h2>
          <h3 class="card-text font-italic">${book.author.authorName}</h3>
          <h4 class="card-text">Rodzaj: ${book.kind.kind}</h4>
          <h4 class="card-text">Gatunek: ${book.genreName}</h4>
          <h4 class="card-text">Wersja audio: ${hasAudio} </h4>
        </div>
      </div>
    </div>
  </div>
</div>