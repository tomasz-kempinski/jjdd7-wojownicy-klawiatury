$(".reserve").click(function(){
  $.ajax({
    url: '/api/books/reserve/' + $(this).attr('data-id'),
    type: 'GET',
    success: function(result)
    {
      location.reload();
    }});
});

$(".cancel").click(function(){
  $.ajax({
    url: '/api/books/reserve/' + $(this).attr('data-id'),
    type: 'DELETE',
    success: function(result)
    {
      location.reload();
    }});
});