$("#reservation-button").click(function(){
  $.ajax({
    url: "/api/reservation/book-newReservation",
    success: function(result)
    {
      // $("#div1").html(result);
    }});
});