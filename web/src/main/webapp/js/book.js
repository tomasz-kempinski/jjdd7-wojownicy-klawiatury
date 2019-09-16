$('#searchParam').keyup(function () {
    if( this.value.length < 3 ) return;
    var substring = $(this).val();
    //wyslij request
    $.ajax({
        url: '/api/books/searchParam/' + substring,
        type: 'GET',
        success: function(data) {
            console.log(data);
            let listOfTitle = [];
            listOfTitle = data;
            let result = data.map(b => b.title);
            $("#searchParam").autocomplete( {
                source: result,
                minLength: 3
            });
        }

    });
});