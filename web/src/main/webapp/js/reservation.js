// $(function () {
//   $(document).ready(function () {
//     $.ajax({
//       url: '/api/reservation/book-isReserved',
//       type: 'GET',
//       success: function (result) {
//
//         $("#book-reserved-button").show();
//         $("#reservation-button").hide();
//       },
//       error: function (event) {
//         $("#reservation-button").show();
//         $("#book-reserved-button").hide();
//       }
//     });
//   });
// });

$(".reserve").click(function(){
  $.ajax({
    url: '/api/books/reserve/' + $(this).attr('data-id'),
    type: 'GET',
    success: function(result)
    {
      location.reload();
    }});
});