$(function () {
  $(document).ready(function () {
    $.ajax({
      url: '/api/user/is-logged',
      type: 'GET',
      success: function (result) {
        $("#login").hide();
        $("#logout").show();
      },
      error: function (event) {
        $("#login").show();
        $("#logout").hide();
      }
    });
  });
});