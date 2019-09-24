<nav class="navbar navbar-expand-md navbar-dark py-1 fixed-top"
     style="background-color: rgb(52,50,50); z-index: 100">
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
            <a class="dropdown-item" href="/book-list?part=0&hasAudio=0">Przeglądanie książek</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">Twoje
              ulubione książki</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">Rezerwacja
              książek</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/admin-panel">Panel administratora</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/logout">wyloguj</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/googlelogin">zaloguj</a>

          </div>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0" id="form-search">
        <input class="form-control mr-sm-2 ui-autocomplete-input" type="search" id="input-param" placeholder="Szukaj"
               aria-label="Search" autocomplete="off">
      </form>
      <ul class="nav navbar-nav navbar-right">
        <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
        <script>
          function onSignIn(googleUser) {
            // Useful data for your client-side scripts:
            var profile = googleUser.getBasicProfile();
            console.log("ID: " + profile.getId()); // Don't send this directly to your server!
            console.log('Full Name: ' + profile.getName());
            console.log('Given Name: ' + profile.getGivenName());
            console.log('Family Name: ' + profile.getFamilyName());
            console.log("Image URL: " + profile.getImageUrl());
            console.log("Email: " + profile.getEmail());

            // The ID token you need to pass to your backend:
            var id_token = googleUser.getAuthResponse().id_token;
            console.log("ID Token: " + id_token);
          }
        </script>
      </ul>
    </div>
  </div>
</nav>
