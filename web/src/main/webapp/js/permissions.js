$(function () {

  $(document).ready(function () {

    $(".give").click(function () {

      $.ajax({
        url: '/api/admin/give/' + $(this).attr('data-userId'),
        type: 'PATCH',
        success: function (result) {
          location.reload();
        }
      });
    });
  });
});

$(function () {

  $(document).ready(function () {

    $(".revoke").click(function () {

      $.ajax({
        url: '/api/admin/revoke/' + $(this).attr('data-userId'),
        type: 'PATCH',
        success: function (result) {
          location.reload();
        }
      });
    });
  });
});