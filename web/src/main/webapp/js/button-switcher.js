$(function () {
  $(document).ready(function () {
    $.ajax({
      url: '/api/user/is-logged',
      type: 'GET',
      success: function (result) {

        $("#logout").show();
        $("#login").hide();
      },
      error: function (event) {
        $("#login").show();
        $("#logout").hide();
      }
    });
  });
});