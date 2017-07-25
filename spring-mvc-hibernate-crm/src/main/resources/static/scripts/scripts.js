window.jQuery(function() {
    var customerId;

    $(document).on('click', '.js-confirm-delete-modal-open', function () {
        customerId = $(this).data('customer-id');
    });

    $('.js-delete-customer').on('click', function () {
        var url = '/customers/delete/process?customerId=' + customerId;
        $('.confirm-delete-modal').modal('hide');

        $.post(url, function() {
            // success
            window.location = '/customers';
        })
            .fail(function() {
                // error
                alert( "error" );
            })
        ;
    });
});