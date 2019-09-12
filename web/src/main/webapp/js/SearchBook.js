$(function() {
    function log (message) {
        $("<div>").text(message).prependTo("#log");
        $("#log").scrollTop(0);
    }
    $("#searchParam").autocomplete({
        source: "search-book",
        minLength: 3,
        select: function (event, ui) {
            $("#searchParam").val(ui.item.value)
        }
    });
});