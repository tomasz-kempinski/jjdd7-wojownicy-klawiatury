
var listOfBooks =['Akslop'];
console.log("test")
console.log(listOfBooks)


$('#form-search').on('submit', () => {
  const $input = $("#input-param");
  message = $input.val();
  if (message.length === 0) {
    return false;
  }
  if(listOfBooks.some(book=>book.title===$input.val())){
    let bookIDs = listOfBooks.filter(book=>book.title===$input.val());
    window.location = 'http://localhost:8080/book-view?id=' + bookIDs[0].id;
  }
  $input.val('');
  return false;
});

//
// $('#input-param').keyup(function () {
//   console.log("TEst")
//   if( this.value.length < 3 ) return;
//   var substring = $(this).val();
//   $.ajax({
//     url: '/api/books/searchTitle/' + substring,
//     type: 'GET',
//     success: function(data) {
//       console.log(data);
//       listOfBooks = data.map(b => b.title);
//       console.log(listOfBooks);
//     }
//
//   });
// });
//
// $("#input-param").autocomplete( {
//   source: listOfBooks
// });
$( "#input-param" ).autocomplete({
  source: function (request, response) {
    $.ajax({
      url: '/api/books/searchTitle/' + $(this).val(),
      type: 'GET',
      success: function (data) {
        console.log(data);
        listOfBooks = data.map(b = > b.title
      )
        ;
        response(listOfBooks)
      }
    });
  },
  minLength: 2
});

