<div id="book-view" class="container">
  <a id="return-button" class="btn btn-primary"
     href="/book-list?part=${part}&hasAudio=${isAudioFilter}" role="button">Powrót
    do listy</a>
  <div id="book-card" class="card mb-5 shadow-lg p-3 mb-5 bg-white rounded"
       style="max-width: 1000px;">
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
      <div>
        <a id="reservation-button" class="btn btn-primary" role="button">Zarezerwuj książkę</a>
      </div>
      <div>
        <button id="book-reserved-button" type="button" class="btn btn-lg btn-primary" disabled>Książka jest zarezerwowana</button>
      </div>
    </div>
  </div>
</div>