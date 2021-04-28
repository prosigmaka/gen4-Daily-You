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
            }})
    },

    getMakeUp: function (){
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
            }})
    },

    getBodyCare: function (){
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
            }})
    },

    getSkinCare: function (){
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
            }})
    }
}