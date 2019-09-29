$(function () {
  $('#reservation-button').click(function (event) {
    var buttonId = $(event.target).attr('data-id');
    $.ajax({
      url: "/reservation",
      method: "POST",
      data: {id: buttonId},
      success: function () {
        location.reload();
      },
      error: function (error) {
        alert('Nie można zarezerwować książki. Książka jest już zarezerwowana');
      }
    });
  });
});