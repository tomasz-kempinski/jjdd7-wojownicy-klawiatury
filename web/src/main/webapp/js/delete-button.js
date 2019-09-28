$(function () {
  $(document).ready(function () {
    $(".delete").click(function () {
      $.ajax({
        url: '/api/books/delete/' + $(this).attr('data-id'),
        type: 'DELETE',
        success: function (result) {
          location.reload();
        }
      });
    });
  });
});