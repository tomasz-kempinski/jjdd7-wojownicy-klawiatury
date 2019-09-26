<div id="book-form-container" class="container">
  <div class="col-md-8 col-md-offset-2">
    <form class="border p-5" method="POST" action="#" enctype="multipart/form-data">

      <p class="h3 mb-4 text-center">Dodaj nową książkę</p>
      <hr>

      <label for="textInput">Tytuł</label>
      <input type="text" id="textInput" class="form-control mb-4" placeholder="Podaj tytuł" name="title">

      <label for="textInput">Autor</label>
      <input type="text" id="textInput" class="form-control mb-4" placeholder="Podaj autora" name="author">

      <label for="textInput">Rodzaj</label>
      <select class="browser-default custom-select mb-4" id="select" name="audio">
        <option value="" disabled="" selected="">Wybierz rodzaj literacki</option>
        <option value="1">Epika</option>
        <option value="2">Liryka</option>
        <option value="1">Dramat</option>
        <option value="2">Epika, Liryka</option>
        <option value="1">Dramat współczesny</option>
      </select>

      <label for="textInput">Gatunek</label>
      <input type="text" id="textInput" class="form-control mb-4"
             placeholder="Podaj gatunek literacki" name="genre">

      <label for="textInput">Audiobook</label>
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

      <button class="btn btn-primary my-4 btn-block" type="submit">Dodaj książkę</button>

    </form>
  </div>
</div>