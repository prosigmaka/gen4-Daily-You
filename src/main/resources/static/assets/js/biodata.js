var tableCart = {
    create: function () {
        // jika table tersebut datatable, maka clear and dostroy
        if ($.fn.DataTable.isDataTable('#tableBiodata')) {
            //table yg sudah dibentuk menjadi datatable harus d rebuild lagi untuk di instantiasi ulang
            $('#tableCart').DataTable().clear();
            $('#tableCart').DataTable().destroy();
        }

        $.ajax({
            url: '/api/cart/',
            method: 'get',
            contentType: 'application/json',
            success: function (res, status, xhr) {
                if (xhr.status == 200 || xhr.status == 201) {
                    $('#tableCart').DataTable({
                        data: res,
                        columns: [
                            {
                                title: "Product id",
                                data: "id"
                            },
                            {
                                title: "Product Name",
                                data: "productName"
                            },
                            {
                                title: "Unit Price",
                                data: "unitPrice"
                            },
                            {
                                title: "Quantity",
                                data: "productQuantity"
                            },
                            {
                                title: "Action",
                                data: null,
                                render: function (data, type, row) {
                                    return "<button class='btn-primary' onclick=formCart.setEditData('" + data.id + "')>Edit</button>"
                                }
                            }
                        ]
                    });

                } else {

                }
            },
            error: function (err) {
                console.log(err);
            }
        });


    }
};

var formCart = {
    resetForm: function () {
        $('#form-cart')[0].reset();
    },
    saveForm: function () {
        if ($('#form-cart').parsley().validate()) {
            var dataResult = getJsonForm($("#form-cart").serializeArray(), true);

            $.ajax({
                url: '/api/biodata',
                method: 'post',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(dataResult),
                success: function (res, status, xhr) {
                    if (xhr.status == 200 || xhr.status == 201) {
                        tableCart.create();
                        $('#modal-cart').modal('hide')

                    } else {

                    }
                },
                erorrr: function (err) {
                    console.log(err);
                }
            });
        }
    }, setEditData: function (idCabang) {
        formCart.resetForm();

        $.ajax({
            url: '/api/biodata/' + idCabang,
            method: 'get',
            contentType: 'application/json',
            dataType: 'json',
            success: function (res, status, xhr) {
                if (xhr.status == 200 || xhr.status == 201) {
                    $('#form-cart').fromJSON(JSON.stringify(res));
                    $('#modal-cart').modal('show')

                } else {

                }
            },
            erorrr: function (err) {
                console.log(err);
            }
        });


    }

};
