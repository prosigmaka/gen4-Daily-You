// show product
async function getAllProducts() {
    var products = [];
    var cards = [];
    const errorMessage = "<p>We don't currently have any items in stock, but feel free to add your own product/s </p>";

    await fetch('/api/product/', {
        method: 'GET',
        mode: 'cors'
    })
        .then(response => response.json())
        .then(data => products = data)
        .catch(_ => cards.push(errorMessage));

    if (products.length > 0 && cards.length < 1) {
        for (const index in products) {
            var product = products[index];

            var productID = product.id;
            var productName = product.productName;
            var productStock = product.stock;
            var productPrice = product.price;
            var productPictureURL = product.pictureUrl;
            var productCategory = product.categoryProduct;

            var card = `
                <div class="col-sm" id=${productID}>
                    <div class="card bg-dark" style="width: 18rem;">
                        <img class="card-img-top" src=${productPictureURL} alt="Product Image">
                        <div class="card-body text-white">
                            <h5 class="card-title">${productName}</h5>
                            <p class="card-text">${productCategory}</p>
                            <br />
                            <p>Stock: ${productStock}</p>
                            <br />
                            <p><strong>Price: $</strong> ${productPrice}</p>
                        </div>
                        <div class="card-footer bg-transparent text-center row">
                            <button type="button" class="btn btn-outline-warning btn-sm col" id="buy-btn">Buy Product</button>
                            <button type="button" class="btn btn-outline-warning btn-sm col offset-md-1" id="edit-btn">Edit Product</button>
                        </div>
                    </div>
                </div>
            `;

            cards.push(card);
        }
    } else if (products.length < 1 && cards.length < 1) {
        cards.push(errorMessage);
    }

    return cards;
}
// new product
async function createNewProduct(product) {
    var result = false;

    await fetch('/api/product/add/', {
        method: 'POST',
        body: JSON.stringify(product),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(_ => result = true)
        .catch(_ => result = false);

    return result;
}

// update product
async function updateProduct(id, product) {
    var result = false;

    await fetch(`/api/product/update/${id}`, {
        method: 'POST',
        body: JSON.stringify(product),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(_ => result = true)
        .catch(_ => result = false);

    return result;
}

// ambil 1 produk
async function getProduct(id) {
    var products = [];

    await fetch('http://remotedevs.org:8080/api/product/', {
        method: 'GET',
        mode: 'cors'
    })
        .then(response => response.json())
        .then(data => products = data)
        .catch(_ => {});

    if (products.length > 0) {
        for (const index in products) {
            var product = products[index];

            if (product.id == id) {
                console.log("Product match!");
                return {
                    "productName": product.name,
                    "stock": product.stock,
                    "pictureURL": product.pictureUrl,
                    "price": product.price,
                    "productCategory": product.categoryProduct
                };
            }
        }
    }

    return {};
}
