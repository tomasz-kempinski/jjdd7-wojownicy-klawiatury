$(function () {
  $(document).ready(function () {
    $.ajax({
      url: '/api/reservation/book-isReserved',
      type: 'GET',
      success: function (result) {

        $("#book-reserved-button").show();
        $("#reservation-button").hide();
      },
      error: function (event) {
        $("#reservation-button").show();
        $("#book-reserved-button").hide();
      }
    });
  });
});

$("#reservation-button").click(function(){
  $.ajax({
    url: "/api/reservation/book-newReservation",
    success: function(result)
    {
    }});
});