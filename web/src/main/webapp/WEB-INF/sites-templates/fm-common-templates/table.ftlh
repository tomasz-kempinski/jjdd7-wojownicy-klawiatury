<div id="table-container" class="container">
    <div class="custom-control custom-switch">
      <#if hasAudio=1>
        <input type="checkbox" class="custom-control-input" id="withAudio" checked>
        <label class="custom-control-label" for="withAudio" onclick=allBooks(${kind})>Filtruj pozycje z
          Audiobookiem</label>
      <#else>
        <input type="checkbox" class="custom-control-input" id="withAudio">
        <label class="custom-control-label" for="withAudio" onclick=onlyAudioBooks(${kind})>Filtruj pozycje
          z Audiobookiem</label></#if>
  </div>
  <div class="custom-control custom-switch">
    <input value="1" name="kind" class="kind-list" onchange=kind(1,${hasAudio}) type="checkbox" <#if kind=1>checked</#if>>
    <label class="kind-list" for="kind" > Liryka </label>
    <input value="2" name="kind" class="kind-list" onchange=kind(2,${hasAudio}) type="checkbox" <#if kind=2>checked</#if>>
    <label class="kind-list" for="kind"> Epika </label>
    <input value="3" name="kind" class="kind-list" onchange=kind(3,${hasAudio}) type="checkbox" <#if kind=3>checked</#if>>
    <label class="kind-list" for="kind"> Dramat </label>
  </div>
  <div class="table-responsive-md">
    <table
        class="table table-bordered table-striped shadow-lg p-3 mb-5 bg-white rounded">
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
              <tr class="clickable-row"
                  data-href="/book-view?id=${book.id}&part=${page.current}&hasAudio=${hasAudio}"
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
