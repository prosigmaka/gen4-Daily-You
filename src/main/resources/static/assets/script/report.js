const tableReport = {
    create() {
        $.ajax({
            url: '/api/order',
            method: 'get',
            contentType: 'application/json',
            success(res, status, xhr) {
                if (xhr.status === 200 || xhr.status === 201) {
                    for (i = 0; i < res.length; i++) {

                        var id = res[i].id;
                        var createdDate = res[i].createdDate;
                        var orderID = res[i].idOrder;
                        var productID = res[i].id;
                        var productName = res[i].productName;
                        var productQuantity = res[i].productQuantity;


                        var markup = "<tr><td>" + id + "</td>" +
                            "<td>" + createdDate + "</td>" +
                            "<td>" + orderID + "</td>" +
                            "<td>" + productID + "</td>" +
                            "<td>" + productName + "</td>" +
                            "<td>" + productQuantity + "</td>" +
                            "</tr>";
                        $("#tableReport tbody").append(markup);
                    }
                }
            },
            error(err) {
                console.log(err)
            }
        })
    }
}
