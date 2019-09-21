<div id="table-container" class="container">
  <div class="custom-control custom-switch">
    <#if hasAudio=1>
      <input type="checkbox" class="custom-control-input" id="withAudio" checked>
      <label class="custom-control-label" for="withAudio" onclick=allBooks()>Filtruj pozycje z Audiobookiem</label>
        <#else>
    <input type="checkbox" class="custom-control-input" id="withAudio" >
    <label class="custom-control-label" for="withAudio" onclick=onlyAudioBooks()>Filtruj pozycje z Audiobookiem</label></#if>
  </div>
  <div class="table-responsive-md">
    <table
        class="table table-hover table-bordered table-striped shadow-lg p-3 mb-5 bg-white rounded">
      <thead class="thead-dark">
      <tr>
        <th scope="col" class="text-center">#</th>
        <th scope="col" class="text-center">Tytuł</th>
        <th scope="col" class="text-center">Autor</th>
      </tr>
      </thead>
      <tbody>
      <#assign i=1>
      <#list books>
          <#items as book>
              <#if (book.thumbnail)??>
            <tr class="clickable-row" data-href="/book-view?id=${book.id}&part=${page.current}&hasAudio=${hasAudio}"
                data-toggle="popover-hover"
                data-img="https://wolnelektury.pl/media/${book.thumbnail}">
                  <#else><tr class="clickable-row" data-href="/book-view?id=${book.id}&part=${page.current}&hasAudio=${hasAudio}"
                    data-toggle="popover-hover"
                    data-img="img/fake-cover-thumbnail.jpg">
              </#if>
              <th scope="row" class="text-center">${i}</th>
              <td>${book.title}</td>
              <td>${book.author.authorName}</td>
            </tr>
              <#assign i=i+1>
          </#items>
      </#list>
      </tbody>
    </table>
  </div>
</div>
<script src="/js/hasAudio.js"></script>