<div class="container">
  <nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <#if page.previous gt -1>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.first}&hasAudio=${hasAudio}">Pierwsza</a>
          </li></#if>
        <#if page.previous gt -1>
          <li class="page-item"><a class="page-link" href="/book-list?part=${page.previous}">Poprzednia</a>
          </li></#if>
        <#if page.previous-1 gt -1>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.previous-1}&hasAudio=${hasAudio}">${page.previous}</a>
          </li></#if>
        <#if page.previous gt -1>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.previous}&hasAudio=${hasAudio}">${page.previous+1}</a>
          </li></#if>
      <li class="page-item active" aria-current="page"><span
            class="page-link">${page.current+1}<span
              class="sr-only">(current)</span></span></li>
        <#if page.last gte page.next>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.next}&hasAudio=${hasAudio}">${page.next+1}</a>
          </li></#if>
        <#if page.last gte page.third>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.third}&hasAudio=${hasAudio}">${page.third+1}</a>
          </li></#if>
        <#if page.last gte page.next>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.next}&hasAudio=${hasAudio}">Następna</a>
          </li></#if>
        <#if page.last gte page.next>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.last}&hasAudio=${hasAudio}">Ostatnia</a>
          </li></#if>
    </ul>
  </nav>
</div>