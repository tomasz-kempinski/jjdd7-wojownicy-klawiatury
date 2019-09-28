$(function () {
  $(document).ready(function () {
    $(".delete-book").click(function () {
      $.ajax({
        url: '/book-view?id=' + $(this).attr('data-id'),
        type: 'DELETE',
        success: function (result) {
          location.reload();
        }
      });
    });
  });
});