// var listOfBooks =[];
//
// $('#form-search').on('submit', () => {
//   const $input = $("#input-param");
//   message = $input.val();
//   if (message.length === 0) {
//     return false;
//   }
//   if(listOfBooks.some(book=>book.title===$input.val())){
//     let bookIDs = listOfBooks.filter(book=>book.title===$input.val());
//     window.location = '/book-view?id=' + bookIDs[0].id + '&part=0';
//   }
//   $input.val('');
//   return false;
// });
//
// $('#input-param').keyup(function () {
//   if( this.value.length < 3 ) return;
//   var substring = $(this).val();
//   $.ajax({
//     url: '/api/books/searchTitle/' + substring,
//     type: 'GET',
//     success: function(data) {
//       listOfBooks = data;
//       let resultTitle = data.map(b => b.title);
//       $("#input-param").autocomplete( {
//         source: resultTitle,
//         minLength: 3
//       });
//     }
//   });
// });
//
$.ui.autocomplete.prototype._resizeMenu = function () {
  let ul = this.menu.element;
  ul.outerWidth(this.element.outerWidth()*2
  );
}
$("#input-title").autocomplete({
  source: function (request, response) {
    $.ajax({
      url: '/api/books/searchTitle/' + request.term,
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
