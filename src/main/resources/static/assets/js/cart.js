var tableCart = {
    create: function () {
        if ($.fn.DataTable.isDataTable('#tableCart')) {
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
                                title: "product name",
                                data: "productName"
                            },
                            {
                                title: "product quantity",
                                data: "productQuantity"
                            },
                            {
                                title: "price",
                                data: "totalCost"
                            },
                            {
                                title: "Action",
                                data: null,
                                render: function (data, type, row) {
                                    return "<button class='btn-success' data-toggle='tooltip' title='edit' data-placement='bottom' onclick=formCart.setEditData('" + data.idCart + "') style='border-radius: 20%'><i class='fa fa-pencil-alt'></i></button>" + "<span>   </span>" +
                                        "<button class='btn-danger' data-toggle='tooltip' title='delete' data-placement='bottom' onclick=actionDelete.deleteConfirm('" + data.idCart + "') style='border-radius: 20%'><i class='fa fa-minus-circle'></i></button>"
                                }
                            }
                        ],
                        scrollX : true
                    });
                } else {
                }
            },
            error: function (err) {
                console.log(err);
            }
        });

        // $.ajax({
        //     type: 'get',
        //     url: '/api/user',
        //     contentType: 'application/json',
        //     dataType: 'json',
        //     success: function (res) {
        //         console.log(res)
        //         let opt = '<option disabled selected hidden>-- Pilih --</option>';
        //         for(let i=0; i<res.length; i++) {
        //             opt += '<option value=' + res[i].idUser + '>' + res[i].nama + '</option>'
        //         }
        //         $('#nama').html(opt);
        //     }
        // });
    }
};

var formCart = {
    resetForm: function () {
        $('#form-cart')[0].reset();
        $('#idCart').val("");
    },

    setEditData: function (idCartItem) {
        formCart.resetForm();
        $.ajax({
            url: '/api/cart/update' + idCartItem,
            method: 'put',
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

var actionDelete = {
    // deleteConfirm: function (id) {
    //     $.ajax({
    //         url: '/api/cart/delete' + id,
    //         method: 'get',
    //         contentType: 'application/json',
    //         dataType: 'json',
    //         success: function (res, status, xhr) {
    //             if (xhr.status == 200 || xhr.status == 201) {
    //                 $('#form-transaksi').fromJSON(JSON.stringify(res));
    //                 $('#modal-delete').modal('show')
    //             } else {
    //
    //             }
    //         },
    //         erorrr: function (err) {
    //             console.log(err);
    //         }
    //     });
    // },

    deleteRowData : function () {
        if ($('#form-cart').parsley().validate()) {
            var dataResult = getJsonForm($("#form-cart").serializeArray(), true);

            $.ajax({
                url: '/api/cart/delete' + dataResult.idCart,
                method: 'delete',
                success: function () {
                    tableCart.create();
                    $('#modal-delete').modal('hide');
                },
                erorrr: function (err) {
                    console.log(err);
                }
            });
        }
    },

    deleteTable : function () {
        $.ajax({
            url: '/api/cart',
            method: 'delete',
            success: function () {
                tableCart.create()
                $('#modal-delete').modal('hide')
            }

        })
    }
};
