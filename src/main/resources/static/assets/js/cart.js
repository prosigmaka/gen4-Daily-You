function getCart() {
    $.ajax({
        url: '/api/cart',
        method: 'get',
        contentType: 'application/json',
        success: function (res, status, xhr) {
            if (xhr.status == 200 || xhr.status == 201) {
                for (var i = 0; i < res.length; i++) {
                    totalQuantity += res[i].kuantitasBuku;
                }
                $('#total-quantity-badge').text(totalQuantity);
            } else {
            }
        },
        error: function (err) {
            console.log(err);
        }

    })
}

getCart();

$("#show-cart").click(function () {
    $("#modal-cart").modal('show')
    showTableCart();
})

function addToCart(id) {
    var jsonAddToCart = {"addToCart": [{"id": id, "idBuku": id, "kuantitasBuku": 1}]};
    $.ajax({
        url: '/api/cart',
        method: 'post',
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(jsonAddToCart),
        success: function (res, status, xhr) {
            var i;
            if (xhr.status == 200 || xhr.status == 201) {
                totalQuantity += 1;
                $('#total-quantity-badge').text(totalQuantity);
                console.log(jsonAddToCart);
                $('#modal-book-description').modal('hide');
            } else {
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}