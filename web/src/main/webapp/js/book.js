var listOfBooks =[];

$('#form-search').on('submit', () => {
  const $input = $("#input-param");
  message = $input.val();
  if (message.length === 0) {
    return false;
  }
  if(listOfBooks.some(book=>book.title===$input.val())){
    let bookIDs = listOfBooks.filter(book=>book.title===$input.val());
    window.location = '127.0.0.1:4380/book-view?id=' + bookIDs[0].id;
  }
  $input.val('');
  return false;
});

$('#input-param').keyup(function () {
  if( this.value.length < 3 ) return;
  var substring = $(this).val();
  $.ajax({
    url: '/api/books/searchTitle/' + substring,
    type: 'GET',
    success: function(data) {
      listOfBooks = data;
      let resultTitle = data.map(b => b.title);
      $("#input-param").autocomplete( {
        source: resultTitle,
        minLength: 3
      });
    }
  });
});

