<div id="table-container" class="container">
  <div class=“row”>
    <div class=“col-md text-center”>
      <div class="custom-control custom-switch">
        <input value="1" name="kind" class="kind-list"
               type="radio" <#if kind=1> onclick=allBooks(0,${hasAudio}) checked <#else> onclick=kind(1,${hasAudio}) </#if>>
        <label class="kind-list" for="kind">Liryka</label>
      </div>
    </div>
    <div class=“col-md text-center”>
      <div class="custom-control custom-switch">
        <input value="2" name="kind" class="kind-list"
               type="radio" <#if kind=2> onclick=allBooks(0,${hasAudio}) checked <#else> onclick=kind(2,${hasAudio}) </#if>>
        <label class="kind-list" for="kind">Epika</label>
      </div>
    </div>
    <div class=“col-md text-center”>
      <div class="custom-control custom-switch">
        <input value="3" name="kind" class="kind-list"
               type="radio" <#if kind=3> onclick=allBooks(0,${hasAudio}) checked <#else> onclick=kind(3,${hasAudio})</#if>>
        <label class="kind-list" for="kind">Dramat</label>
      </div>
    </div>
    <div class=“col-md text-center”>
      <div class="custom-control custom-switch">
          <#if hasAudio=1>
            <input type="checkbox" class="custom-control-input" id="withAudio" checked>
            <label class="custom-control-label" for="withAudio" onclick=allBooks(${kind},0)>Filtruj
              pozycje z
              Audiobookiem</label>
          <#else>
            <input type="checkbox" class="custom-control-input" id="withAudio">
            <label class="custom-control-label" for="withAudio" onclick=allBooks(${kind},1)>Filtruj
              pozycje
              z Audiobookiem</label></#if>
      </div>
    </div>
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
              <tr id="thumbnail" class="clickable-row"
                  data-href="/book-view?id=${book.id?c}&part=${page.current}&hasAudio=${hasAudio}&kind=${kind}"
                  data-toggle="popover-hover"
                  data-img="${book.thumbnail}">
              <#else><tr class="clickable-row" data-href="/book-view?id=${book.id?c}&part=${page.current}&hasAudio=${hasAudio}&kind=${kind}"
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
