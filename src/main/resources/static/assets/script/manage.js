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
                            "<td><button class='btn-primary' onclick=formProduct.editData("+ res[i].id +")>Edit</button>" +
                            "<button  class='btn-danger' onclick=actionDelete.confirmDelete("+ res[i].id +")>Delete</button></td>" +
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

const dataTableProduct = {
    create() {
        // jika table tersebut datatable, maka clear and dostroy
        if ($.fn.DataTable.isDataTable('#tableProduct')) {
            // table yg sudah dibentuk menjadi datatable harus d rebuild lagi untuk di instantiasi ulang
            $('#tableProduct').DataTable().clear()
            $('#tableProduct').DataTable().destroy()
        }

        $.ajax({
            url: '/api/product',
            method: 'get',
            contentType: 'application/json',
            success(res, status, xhr) {
                if (xhr.status == 200 || xhr.status == 201) {
                    $('#tableProduct').DataTable({
                        data: res,
                        columns: [
                            {title: 'Product ID', data: 'id'},
                            {title: 'Product Name', data: 'productName'},
                            {title: 'Stock', data: 'stock'},
                            {title: 'Price', data: 'price'},
                            {title: 'Picture Url', data: 'pictureUrl'},
                            {title: 'Category ID', data: 'idCategory'},
                            {title: 'Category Name', data: 'categoryName'},
                            {
                                title: 'Action', data: null,
                                render(data, type, row) {
                                    return `<button class='btn-primary' onclick=formProduct.editData('${data.id}')><a>Edit</a></button>` +
                                        `<button  class='btn-danger' onclick=actionDelete.confirmDelete('${data.id}')>Delete</button>`
                                }
                            }
                        ]
                    })
                } else {
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
                        console.log(dataResult);
                        dataTableProduct.create()
                        // tableProduct.create()
                        $('#modal-product').modal('hide')
                    } else {}
                },
                erorrr(err) {
                    console.log(err)
                }
            })
        }
    },
    updateForm() {
        if ($('#form-update').parsley().validate()) {
            const dataResult = getJsonForm($('#form-update').serializeArray(), true)

            $.ajax({
                url: '/api/product/update/' + dataResult.id,
                method: 'post',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(dataResult),
                success(res, status, xhr) {
                    if (xhr.status === 200 || xhr.status === 201) {
                        // tableProduct.create()
                        dataTableProduct.create();
                        $('#modal-product').modal('hide')
                    } else {}
                },
                erorrr(err) {
                    console.log(err)
                }
            })
        }
    },
    editData(idCabang) {
        formProduct.resetForm()

        $.ajax({
            url: `/api/product/${idCabang}`,
            method: 'get',
            contentType: 'application/json',
            dataType: 'json',
            success(res, status, xhr) {
                if (xhr.status === 200 || xhr.status === 201 ) {
                    console.log(res);
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

const actionDelete = {
    confirmDelete(idRow) {// kalo ga pake modal, connfirmDelete dicomment aja
        $.ajax({
            url: `/api/product/${idRow}`,
            method: 'get',
            contentType: 'application/json',
            dataType: 'json',
            success(res, status, xhr) {
                if (xhr.status == 200 || xhr.status == 201) {
                    $('#form-product').fromJSON(JSON.stringify(res))
                    $('#modal-delete').modal('show')
                } else {
                }
            },
            erorrr(err) {
                console.log(err)
            }
        })
    },
    deleteRowData: function () { //pake ini kalo ga pake modal
        // deleteRowData() {
        if ($('#form-product').parsley().validate()) {
        const dataResult = getJsonForm($('#form-product').serializeArray(), true)
            console.log(getJsonForm($('#id').serializeArray(), true));
        // var yes = confirm("Hapus data?"); //pake ini kalo ga pake modal
        // if (yes) {
            $.ajax({
                    url: `/api/product/`+dataResult.id, // ${idRow}ditambah idRow kalo pake confirm ga pake modal
                    method: 'delete',
                    success() {
                        // $("#tableProduct tbody").parent("tr").remove();

                        dataTableProduct.create();
                        $('#modal-delete').modal('hide')
                    },
                    erorrr(err) {
                        console.log(err)
                    }
                }
            )
        }
        // } // dicomment kalo ga pake modal
    }
    // }
}

function getJsonForm(jsonArray, isAllowedNull) {
    result = {};
    jsonArray.forEach(function (element) {
        value = element.value;
        if (value == "" && isAllowedNull) {
            value = null;
        }
        result[element.name] = value;
    });
    return result;
}

$.fn.fromJSON = function (json_string) {
    var $form = $(this);
    var data = JSON.parse(json_string);
    $.each(data, function (key, value) {
        var $elem = $('[name="' + key + '"]', $form);
        var type = $elem.first().attr('type');
        if (type == 'radio') {
            $('[name="' + key + '"][value="' + value + '"]').prop('checked', true)
        } else if (type == 'checkbox' && (value == true || value == 'true')) {
            $('[name="' + key + '"]').prop('checked', true)
        } else {
            $elem.val(value)
        }
    })
};

