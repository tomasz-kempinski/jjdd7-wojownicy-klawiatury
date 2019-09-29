<div id="book-view" class="container">
  <div class="row">
    <div class="col-md text-center">
      <a id="return-button" class="btn btn-primary"
         href="/book-view?id=${book.id}&part=${part}" role="button">Powrót</a>
    </div>
    <div class="col-md text-center">
    </div>
  </div>
  <div id="book-card" class="card mb-5 shadow-lg p-3 mb-5 bg-white rounded"
       style="max-width: 1200px;">
    <div class="row no-gutters">
      <div class="col-md-5">
          <#if book.cover??>
            <img src="${book.cover}" class="card-img" alt="book">
          <#else>
            <img src="img/fake-cover.png" alt="book" class="card-img">
          </#if>
      </div>
      <div class="col-md-7">
        <div class="card-body">

          <form method="POST" action="#" enctype="multipart/form-data">

            <h3 class="card-title font-weight-bold">Tytuł</h3>

            <input type="text" pattern="^[a-zA-Z0-9]+$" id="textInput" class="form-control mb-4" placeholder="Podaj tytuł"
                   name="title" value="${book.title}">

            <h4 class="card-line font-italic">Autor</h4>

            <input type="text" pattern="^[a-zA-Z0-9]+$" id="textInput" class="form-control mb-4" placeholder="Podaj autora"
                   name="author" value="${book.author.authorName}">

            <h5 class="card-line">Rodzaj: ${book.kind.kind}</h5>

            <select class="browser-default custom-select mb-4" id="select" name="kind">
              <option value="${book.kind.kind}" selected="selected">Wybierz rodzaj literacki
              </option>
              <option value="Epika">Epika</option>
              <option value="Liryka">Liryka</option>
              <option value="Dramat">Dramat</option>
              <option value="Epika, Liryka">Epika, Liryka</option>
              <option value="Dramat współczesny">Dramat współczesny</option>
            </select>

            <h5 class="card-line">Gatunek: ${book.genreName}</h5>

            <input type="text" pattern="^[a-zA-Z0-9]+$" id="textInput" class="form-control mb-4"
                   placeholder="Podaj gatunek literacki" name="genre" value="${book.genreName}">

            <h5 class="card-line">Wersja audio: ${hasAudio} </h5>

            <select class="browser-default custom-select mb-4" id="select" name="audio">
              <option value="${hasAudio}" selected="selected">Czy wersja audio jest dostępna?
              </option>
              <option value="tak">Tak</option>
              <option value="nie">Nie</option>
            </select>

            <div class="form-group">
              <div class="input-group input-file" name="file">
                <input type="text" class="form-control"
                       placeholder='Wybierz plik okładki z dysku...'/>
                <span class="input-group-btn">
       			 <button class="btn btn-warning btn-reset" type="button">Zresetuj</button>
    		</span>
              </div>
            </div>
            <button class="btn btn-success my-4 btn-block" type="submit">Zapisz zmiany</button>
        </div>
      </div>
    </div>
  </div>
</div>