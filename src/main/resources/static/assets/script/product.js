var create = {
    getAllProducts: function () {
        $.ajax({
            url: '/api/product',
            method: 'get',
            contentType: 'application/json',
            success: function (res, status, xhr) {
                if (xhr.status == 200 || xhr.status == 201) {
                    console.log(res.length);
                    var cards = [];
                    if (res.length > 0 && cards.length < 1) {
                        for (i = 0; i < res.length; i++) {

                            var productID = res[i].id;
                            var productName = res[i].productName;
                            var productStock = res[i].stock;
                            var productPrice = res[i].price;
                            var productPictureURL = res[i].pictureUrl;
                            var idCategory = res[i].idCategory;
                            var categoryName = res[i].categoryName;

                            console.log(categoryName);
                            var card = `
                <div class="col-md-3" id=${productID}>
                    <div class="card-body card-product" style="width: 18rem;">
                        <img class="card-img-top" src=${productPictureURL} alt="Product Image">
                        <div class="text-dark text-capitalize">
                            <p class="card-title" style="line-height: 2"><strong>${productName}</strong></p>
                            <h5 class="card-text">${categoryName}</h5>
                           
                            <h5 style="line-height: 2">Stock: ${productStock}</h5>
                            <br>
                            <p><strong>Price: Rp${productPrice}</strong> </p>
                        </div>
                        <div class="card-footer bg-transparent text-center row">
                            <button type="button" class="btn btn-outline-warning btn-sm col" id="buy-btn">Add to Cart</button>
                        </div>
                    </div>
                </div>
            `;

                            $("#card-container").append(card);
                        }
                    } else if (res.length < 1 && cards.length < 1) {
                        cards.push(errorMessage);
                    }
                }
            }
        })
    },

    getMakeUp: function () {
        $.ajax({
            url: '/api/product/category/1',
            method: 'get',
            contentType: 'application/json',
            success: function (res, status, xhr) {
                if (xhr.status == 200 || xhr.status == 201) {
                    console.log(res.length);
                    var cards = [];
                    if (res.length > 0 && cards.length < 1) {
                        for (i = 0; i < res.length; i++) {

                            var productID = res[i].id;
                            var productName = res[i].productName;
                            var productStock = res[i].stock;
                            var productPrice = res[i].price;
                            var productPictureURL = res[i].pictureUrl;
                            var idCategory = res[i].idCategory;
                            var categoryName = res[i].categoryName;

                            console.log(categoryName);
                            var card = `
                <div class="col-md-3" id=${productID}>
                    <div class="card-body card-product" style="width: 18rem;">
                        <img class="card-img-top" src=${productPictureURL} alt="Product Image">
                        <div class="text-dark text-capitalize">
                            <p class="card-title" style="line-height: 2"><strong>${productName}</strong></p>
                            <h5 class="card-text">${categoryName}</h5>
                           
                            <h5 style="line-height: 2">Stock: ${productStock}</h5>
                            <br>
                            <p><strong>Price: Rp${productPrice}</strong> </p>
                        </div>
                        <div class="card-footer bg-transparent text-center row">
                            <button type="button" class="btn btn-outline-warning btn-sm col" id="buy-btn">Add to Cart</button>
                        </div>
                    </div>
                </div>
            `;
                            $("#card-container").append(card);
                        }
                    } else if (res.length < 1 && cards.length < 1) {
                        cards.push(errorMessage);
                    }
                }
            }
        })
    },

    getBodyCare: function () {
        $.ajax({
            url: '/api/product/category/2',
            method: 'get',
            contentType: 'application/json',
            success: function (res, status, xhr) {
                if (xhr.status == 200 || xhr.status == 201) {
                    console.log(res.length);
                    var cards = [];
                    if (res.length > 0 && cards.length < 1) {
                        for (i = 0; i < res.length; i++) {

                            var productID = res[i].id;
                            var productName = res[i].productName;
                            var productStock = res[i].stock;
                            var productPrice = res[i].price;
                            var productPictureURL = res[i].pictureUrl;
                            var idCategory = res[i].idCategory;
                            var categoryName = res[i].categoryName;

                            console.log(categoryName);
                            var card = `
                <div class="col-md-3" id=${productID}>
                    <div class="card-body card-product" style="width: 18rem;">
                        <img class="card-img-top" src=${productPictureURL} alt="Product Image">
                        <div class="text-dark text-capitalize">
                            <p class="card-title" style="line-height: 2"><strong>${productName}</strong></p>
                            <h5 class="card-text">${categoryName}</h5>
                           
                            <h5 style="line-height: 2">Stock: ${productStock}</h5>
                            <br>
                            <p><strong>Price: Rp${productPrice}</strong> </p>
                        </div>
                        <div class="card-footer bg-transparent text-center row">
                            <button type="button" class="btn btn-outline-warning btn-sm col" id="buy-btn">Add to Cart</button>
                        </div>
                    </div>
                </div>
            `;

                            $("#card-container").append(card);
                        }
                    } else if (res.length < 1 && cards.length < 1) {
                        cards.push(errorMessage);
                    }
                }
            }
        })
    },

    getSkinCare: function () {
        $.ajax({
            url: '/api/product/category/3',
            method: 'get',
            contentType: 'application/json',
            success: function (res, status, xhr) {
                if (xhr.status == 200 || xhr.status == 201) {
                    console.log(res.length);
                    var cards = [];
                    if (res.length > 0 && cards.length < 1) {
                        for (i = 0; i < res.length; i++) {

                            var productID = res[i].id;
                            var productName = res[i].productName;
                            var productStock = res[i].stock;
                            var productPrice = res[i].price;
                            var productPictureURL = res[i].pictureUrl;
                            var idCategory = res[i].idCategory;
                            var categoryName = res[i].categoryName;

                            console.log(categoryName);
                            var card = `
                <div class="col-md-3" id=${productID}>
                    <div class="card-body card-product" style="width: 18rem;">
                        <img class="card-img-top" src=${productPictureURL} alt="Product Image">
                        <div class="text-dark text-capitalize">
                            <p class="card-title" style="line-height: 2"><strong>${productName}</strong></p>
                            <h5 class="card-text">${categoryName}</h5>
                           
                            <h5 style="line-height: 2">Stock: ${productStock}</h5>
                            <br>
                            <p><strong>Price: Rp${productPrice}</strong> </p>
                        </div>
                        <div class="card-footer bg-transparent text-center row">
                            <button type="button" class="btn btn-outline-warning btn-sm col" id="buy-btn">Add to Cart</button>
                        </div>
                    </div>
                </div>
            `;

                            $("#card-container").append(card);
                        }
                    } else if (res.length < 1 && cards.length < 1) {
                        cards.push(errorMessage);
                    }
                }
            }
        })
    }
}

const tableProduct = {
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
                                    return `<button class='btn-primary' onclick=formProduct.setEditData('${data.id}')>Edit</button>` +
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
                url: '/api/product',
                method: 'post',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(dataResult),
                success(res, status, xhr) {
                    if (xhr.status == 200 || xhr.status == 201) {
                        tableProduct.create()
                        $('#modal-product').modal('hide')
                    } else {
                    }
                },
                erorrr(err) {
                    console.log(err)
                }
            })
        }
    }, setEditData(id) {
        formProduct.resetForm()

        $.ajax({
            url: `/api/product/${id}`,
            method: 'get',
            contentType: 'application/json',
            dataType: 'json',
            success(res, status, xhr) {
                if (xhr.status == 200 || xhr.status == 201) {
                    $('#form-product').fromJSON(JSON.stringify(res))
                    $('#modal-product').modal('show')
                } else {
                }
            },
            erorrr(err) {
                console.log(err)
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
                } else {}
            },
            erorrr(err) {
                console.log(err)
            }
        })
    },
    // deleteRowData: function (idRow) { //pake ini kalo ga pake modal
    deleteRowData() {
        if ($('#form-product').parsley().validate()) {
            const dataResult = getJsonForm($('#form-product').serializeArray(), true)
            // var yes= confirm("Hapus data?"); //pake ini kalo ga pake modal
            // if (yes){
            $.ajax({
                    url: `/api/product/${dataResult.id}`, // ditambah idRow kalo pake confirm ga pake modal
                    method: 'delete',
                    success() {
                        tableProduct.create()
                        $('#modal-delete').modal('hide')
                    },
                    erorrr(err) {
                        console.log(err)
                    }
                }
            )
        }
    } // dicomment kalo ga pake modal
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
    },
}
