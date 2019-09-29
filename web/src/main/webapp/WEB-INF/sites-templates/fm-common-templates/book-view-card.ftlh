<div id="book-view" class="container">
  <div class="row">
    <div class="col-md text-center">
      <a id="return-button" class="btn btn-primary"
         href="/book-list?part=${part}&hasAudio=${isAudioFilter}&kind=${kind}" role="button">Powrót
        do listy</a>
    </div>
        <div class="col-md text-center">
            <#if (siteType) == "admin">
              <a class="btn btn-info nav-button" href="/book-edit?id=${book.id?c}&part=${part}"
             role="button">Edytuj książkę</a>
            </#if>
        </div>
        <div class="col-md text-center">
            <#if (siteType) == "admin">
          <a href="/book-list?part=0&hasAudio=0&kind=0" class="btn btn-danger nav-button delete" data-id="${book.id}">Usuń książkę</a>
          </#if>
        </div>

  </div>
  <div id="book-card" class="card mb-5 shadow-lg p-3 bg-white rounded"
       style="max-width: 1200px;">
    <div class="row no-gutters">
      <div class="col-md-5">
          <#if book.cover??>
            <img src="${book.cover}" class="card-img" alt="book-cover">
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