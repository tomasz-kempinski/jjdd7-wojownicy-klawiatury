<div class="container">
  <nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <#if page.previous gt -1>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.first}&hasAudio=${hasAudio}&kind=${kind}">Pierwsza</a>
          </li></#if>
        <#if page.previous gt -1>
          <li class="page-item"><a class="page-link" href="/book-list?part=${page.previous}&kind=${kind}">Poprzednia</a>
          </li></#if>
        <#if page.previous-1 gt -1>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.previous-1}&hasAudio=${hasAudio}&kind=${kind}">${page.previous}</a>
          </li></#if>
        <#if page.previous gt -1>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.previous}&hasAudio=${hasAudio}&kind=${kind}">${page.previous+1}</a>
          </li></#if>
      <li class="page-item active" aria-current="page"><span
            class="page-link">${page.current+1}<span
              class="sr-only">(current)</span></span></li>
        <#if page.last gte page.next>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.next}&hasAudio=${hasAudio}&kind=${kind}">${page.next+1}</a>
          </li></#if>
        <#if page.last gte page.third>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.third}&hasAudio=${hasAudio}&kind=${kind}">${page.third+1}</a>
          </li></#if>
        <#if page.last gte page.next>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.next}&hasAudio=${hasAudio}&kind=${kind}">Następna</a>
          </li></#if>
        <#if page.last gte page.next>
          <li class="page-item"><a class="page-link"
                                   href="/book-list?part=${page.last}&hasAudio=${hasAudio}&kind=${kind}">Ostatnia</a>
          </li></#if>
    </ul>
  </nav>
</div>