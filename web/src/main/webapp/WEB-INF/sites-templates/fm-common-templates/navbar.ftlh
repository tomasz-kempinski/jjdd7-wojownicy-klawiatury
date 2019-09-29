<nav class="navbar navbar-expand-md navbar-dark py-1 fixed-top"
     style="background-color: rgb(52,50,50); z-index: 100" xmlns="http://java.sun.com/jsf/html">
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
            <a class="dropdown-item" href="/book-list?part=0&hasAudio=0&kind=0">Przeglądanie
              książek</a>
              <#if (siteType) == "guest">
            <div class="dropdown-divider"></div>
            <a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">Rezerwacja
              książek</a>
            </#if>
            <#if (siteType) == "user" || (siteType) == "admin">
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/reservation-list" tabindex="-1" aria-disabled="true">Rezerwacja
              książek</a>
            </#if>
          </div>
        </li>
       <#if (siteType) == "admin">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#"
             id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
             aria-expanded="false">Panel administratora</a>
          <div class="dropdown-menu" aria-labelledby="dropdown01">
            <a class="dropdown-item" href="/book-add">Dodaj książkę</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/books-upload">Załaduj książki z pliku</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/users-list">Zarządzaj użytkownikami</a>
          </div>
        </li>
        </#if>
      </ul>
      <form class="form-inline my-2 my-lg-0" id="form-search">
        <input class="form-control mr-sm-2 ui-autocomplete-input" type="search" id="input-param"
               placeholder="Szukaj"
               aria-label="Search" autocomplete="off">
      </form>
      <ul class="nav navbar-nav navbar-right">
        <a class="btn btn-warning" role="button" href="/googlelogin" id="login" style="display: none;">Zaloguj</a>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <a class="btn btn-warning" role="button" href="/logout" id="logout" style="display: none;">Wyloguj</a>
      </ul>
    </div>
  </div>
</nav>
