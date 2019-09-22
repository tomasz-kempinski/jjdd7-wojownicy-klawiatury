$.ui.autocomplete.prototype._resizeMenu = function () {
  let ul = this.menu.element;
  ul.outerWidth(this.element.outerWidth()*2
  );
}
$("#input-author").autocomplete({
  source: function (request, response) {
    $.ajax({
      url: '/api/books/searchAuthor/' + request.term,
      type: 'GET',
      success: function (data) {
        if (!data.length) {
          let result = [
            {
              label: 'Brak wyników',
              value: request.term
            }
          ];
          response(result);
        } else {
          let result = data.map(
              b => {
            return {
              id: b.id,
              label: b.title,
              value: b.title
            };
        }
        );
          response(result);
        }
      }
    });
  },
  minLength: 3,
  select: function (event, ui) {
    if (ui.item.id === undefined) {
      return;
    } else {
      window.location.href = "/book-view?id=" + ui.item.id + "&part=0";
    }
  }
});