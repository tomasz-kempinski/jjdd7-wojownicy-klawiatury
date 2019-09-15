$(function () {
    $(document).ready(function () {
        $('#bookTitle').keyup(function () {
            if (this.value.length < 3) return;
            var bookTitle = $(this).val();
            $.ajax({
                url: '/search-book?bookTitle=' + bookTitle,
                method: "GET",
                success: function (data) {
                    console.log(result);
                    $('#table-container').html(data)

                },
                error: function (error) {
                    alert(error);
                }
            });
        });
    });
});