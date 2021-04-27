$("#card-container").ready(async function() {
    var cards = await getAllProducts();

    for (const index in cards) {
        var card = cards[index];
        $("#card-container").append(card);
    }
});


$("#card-container").on("click", "#buy-btn", function() {
    alert("Thank you for supporting https://www.webtutsplus.com");
});


$("#add-product").on("click", function() {
    window.location.href = "/add-product";
});


$("#btn-add-product").click(async function(form) {
    form.preventDefault();
    const id=$("#id");
    const productName = $("#productName").val();
    const pictureUrl = $("#pictureUrl").val();
    const price = $("#price").val();
    const stock = $("#stock").val();
    const categoryName = $("#categoryName").val();

    const product = {
        "id": id,
        "productName": productName,
        "pictureUrl": pictureUrl,
        "price": price,
        "stock": stock,
        "categoryName": categoryName
    };

    var result = await createNewProduct(product);

    if (result) {
        alert("Product has been added!");
        window.location.href = "index.html";
    } else {
        alert("Failed to add product, sorry");
    }
});

$("#update-form").ready(async function() {
    const id = window.location.href.split("?id=").pop();
    var product = await getProduct(id);

    $("#productName").val(product.productName);
    $("#pictureUrl").val(product.pictureUrl);
    $("#price").val(product.price);
    $("#stock").val(product.stock);
    $("#categoryProduct").val(product.categoryProduct);
});

$("#update-form").submit(async function(form) {
    form.preventDefault();

    const id = window.location.href.split("?id=").pop();
    const productName = $("#productName").val();
    const pictureUrl = $("#pictureUrl").val();
    const price = $("#price").val();
    const stock = $("#stock").val();
    const categoryProduct = $("#categoryProduct").val();

    const product = {
        "productName": productName,
        "pictureUrl": pictureUrl,
        "price": price,
        "stock": stock,
        "categoryProduct": categoryProduct
    };

    var result = await updateProduct(id, product);

    if (result) {
        alert("Product has been update!");
        window.location.href = "index.html";
    } else {
        alert("Failed to update product, sorry");
    }
});

$("#card-container").on("click", "#edit-btn", function() {
    // Get the id of the product
    var productID = $(this).parent().parent().parent().attr("id");
    var url = "update.html" + "?id=" + productID;
    window.location.href = url;
});