const $formName = $('#form-search');
let listOfBooks =[];
console.log("test")


$formName.on('submit', () => {
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


$('#input-param').keyup(function () {
  console.log("TEst")
  if( this.value.length < 3 ) return;
  var substring = $(this).val();
  $.ajax({
    url: '/api/books/searchTitle/' + substring,
    type: 'GET',
    success: function(data) {
      console.log(data);
      listOfBooks = data;
      let result = data.map(b => b.title);
      $("#input-param").autocomplete( {
        source: result,
        minLength: 3
      });
    }

  });
});