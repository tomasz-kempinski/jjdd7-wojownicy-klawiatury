<div class="jumbotron jumbotron-fluid" style="background-color: rgb(177, 202, 248)">
  <div class="container">
    <h1 class="display-4">Witaj w BookHub ${user ! ""}!</h1>
    <#if user??><h1 class="display-4">Witaj w BookHub ${user}!</h1></#if>
    <p class="lead">Twojej nowej ulubionej bibliotece on-line</p>
  </div>
</div>