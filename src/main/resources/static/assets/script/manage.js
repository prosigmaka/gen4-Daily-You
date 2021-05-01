const tableProduct = {
    create() {
        $.ajax({
            url: '/api/product',
            method: 'get',
            contentType: 'application/json',
            success(res, status, xhr) {
                if (xhr.status === 200 || xhr.status === 201) {
                    for (i = 0; i < res.length; i++) {
                        var productID = res[i].id;
                        var productName = res[i].productName;
                        var productStock = res[i].stock;
                        var productPrice = res[i].price;
                        var productPictureURL = res[i].pictureUrl;
                        var idCategory = res[i].idCategory;
                        var categoryName = res[i].categoryName;

                        var markup = "<tr><td>" + productID + "</td>" +
                            "<td>" + productName + "</td>" +
                            "<td>" + productStock + "</td>" +
                            "<td>" + productPrice + "</td>" +
                            "<td>" + productPictureURL + "</td>" +
                            "<td>" + idCategory + "</td>" +
                            "<td>" + categoryName + "</td>" +
                            "<td><button class='btn-primary' onclick=formProduct.setEditData(${productID})>Edit</button>" +
                            "<button  class='btn-danger' onclick=actionDelete.deleteRowData(${productID})>Delete</button></td>" +
                            "</tr>";
                        $("#tableProduct tbody").append(markup);
                    }
                }
            },
            error(err) {
                console.log(err)
            }
        })
    }
}
var formProduct = {
    resetForm() {
        $('#form-product')[0].reset()
        $('#id').val('')
        $('#idCategory').val('')
    },
    saveForm() {
        if ($('#form-product').parsley().validate()) {
            const dataResult = getJsonForm($('#form-product').serializeArray(), true)

            $.ajax({
                url: '/api/product/add',
                method: 'post',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(dataResult),
                success(res, status, xhr) {
                    if (xhr.status === 200 || xhr.status === 201) {
                        tableProduct.create()
                        $('#modal-product').modal('hide')
                    } else {}
                },
                erorrr(err) {
                    console.log(err)
                }
            })
        }
    }, setEditData(idCabang) {
        formProduct.resetForm()

        $.ajax({
            url: `/api/product/${idCabang}`,
            method: 'get',
            contentType: 'application/json',
            dataType: 'json',
            success(res, status, xhr) {
                if (xhr.status === 200 || xhr.status === 201 ) {
                    $('#form-product').fromJSON(JSON.stringify(res))
                    $('#modal-product').modal('show');
                } else {}
            },
            erorrr(err) {
                console.log(err);
            }
        })
    }
}

const dropdown = {
    selectCategory() {
        $.ajax({
            type: 'GET',
            url: '/api/productcategory',
            contentType: 'application/json',
            dataType: 'json',
            success(data) {
                let s = '<option value="-1">Choose Category</option>'
                for (let i = 0; i < data.length; i++) {
                    s += `<option value="${data[i].id}">${data[i].categoryName}</option>`
                }

                $('#categoryName').append(s)
            }
        })
    }
}
