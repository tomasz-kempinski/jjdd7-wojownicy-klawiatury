let listOfTitle = [];
$('#searchParam').keyup(function () {
    if( this.value.length < 3 ) return;
    var substring = $(this).val();
    $.ajax({
        url: '/api/books/searchParam/' + substring,
        type: 'GET',
        success: function(data) {
            console.log(data);
            listOfTitle = data;
            let result = data.map(b => b.title);
            $("#searchParam").autocomplete( {
                source: result,
                minLength: 3
            });
        }

    });
});