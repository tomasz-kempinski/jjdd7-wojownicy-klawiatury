<div class="container">
<nav aria-label="Page navigation example">
  <ul class="pagination">
      <#if page.previous gt 0> <li class="page-item"><a class="page-link" href="/book-list?part=${page.first}">Pierwsza</a></li></#if>
      <#if page.previous gt 0> <li class="page-item"><a class="page-link" href="/book-list?part=${page.previous}">Poprzednia</a></li></#if>
      <#if page.previous-1 gt 0><li class="page-item"><a class="page-link" href="/book-list?part=${page.previous-1}">${page.previous-1}</a></li></#if>
    <#if page.previous gt 0> <li class="page-item"><a class="page-link" href="/book-list?part=${page.previous}">${page.previous}</a></li></#if>
    <li class="page-item active" aria-current="page"><span class="page-link">${page.current}<span class="sr-only">(current)</span></span></li>
      <#if page.last gte page.next> <li class="page-item"><a class="page-link" href="/book-list?part=${page.next}">${page.next}</a></li></#if>
      <#if page.last gte page.third> <li class="page-item"><a class="page-link" href="/book-list?part=${page.third}">${page.third}</a></li></#if>
      <#if page.last gte page.next><li class="page-item"><a class="page-link" href="/book-list?part=${page.next}">Następna</a></li></#if>
      <#if page.last gte page.next><li class="page-item"><a class="page-link" href="/book-list?part=${page.last}">Ostatnia</a></li></#if>
  </ul>
</nav>
</div>