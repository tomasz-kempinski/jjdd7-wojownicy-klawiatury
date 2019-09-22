<nav class="navbar navbar-expand-md navbar-dark py-1 fixed-top"
     style="background-color: rgb(52,50,50)">
  <div class="container">
    <a class="navbar-brand"
       href="/">
      <img src="img/Bookhub30.png" alt="Bookhub"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span><span class="icon-bar"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#"
             id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
             aria-expanded="false">Menu</a>
          <div class="dropdown-menu" aria-labelledby="dropdown01">
            <a class="dropdown-item" href="/book-list?part=1">Przeglądanie książek</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">Twoje
              ulubione książki</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">Rezerwacja
              książek</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#"
             id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
             aria-expanded="false">Panel administratora</a>
          <div class="dropdown-menu" aria-labelledby="dropdown01">
            <a class="dropdown-item" href="/book-create">Dodaj książkę</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/books-upload">Załaduj książki z pliku</a>
          </div>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="Szukaj" aria-label="Search">
      </form>
      <ul class="nav navbar-nav navbar-right">
        <a href="#" class="btn btn-primary btn-md disabled btn-outline-warning" tabindex="-1"
           role="button" aria-disabled="true">Zaloguj</a>
      </ul>
    </div>
  </div>
</nav>