<div id="book-view" class="container">
  <a id="return-button" class="btn btn-primary" href="/book-view?part=0&id=${book.id}" role="button">Powrót
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

          <form method="POST" action="#" enctype="multipart/form-data">

          <h2 class="card-title font-weight-bold">${book.title}</h2>

            <input type="text" id="textInput" class="form-control mb-4" placeholder="Podaj tytuł" name="title">

          <h3 class="card-text font-italic">${book.author.authorName}</h3>

            <input type="text" id="textInput" class="form-control mb-4" placeholder="Podaj autora" name="author">

          <h4 class="card-text">Rodzaj: ${book.kind.kind}</h4>

            <select class="browser-default custom-select mb-4" id="select" name="audio">
              <option value="" disabled="" selected="">Wybierz rodzaj literacki</option>
              <option value="1">Epika</option>
              <option value="2">Liryka</option>
              <option value="1">Dramat</option>
              <option value="2">Epika, Liryka</option>
              <option value="1">Dramat współczesny</option>
            </select>

          <h4 class="card-text">Gatunek: ${book.genreName}</h4>

            <input type="text" id="textInput" class="form-control mb-4"
                   placeholder="Podaj gatunek literacki" name="genre">

          <h4 class="card-text">Wersja audio: ${hasAudio} </h4>

            <select class="browser-default custom-select mb-4" id="select" name="audio">
              <option value="" disabled="" selected="">Czy książka ma wersję audio?</option>
              <option value="1">Nie</option>
              <option value="2">Tak</option>
            </select>

            <div class="form-group">
              <div class="input-group input-file" name="file">
                <input type="text" class="form-control" placeholder='Wybierz plik okładki z dysku...'/>
                <span class="input-group-btn">
       			 <button class="btn btn-warning btn-reset" type="button">Zresetuj</button>
    		</span>
              </div>
            </div>

        </div>
      </div>
    </div>
  </div>
</div>