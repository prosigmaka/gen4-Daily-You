var create = {
    getAllItemCart: function () {
        $.ajax({
            url: '/api/cart',
            method: 'get',
            contentType: 'application/json',
            success: function (res, status, xhr) {
                if (xhr.status == 200 || xhr.status == 201) {
                    console.log(res.length);
                    var cart = [];
                    if (res.length > 0 && cart.length < 1) {
                        for (i = 0; i < res.length; i++) {

                            var number = res[i].id;
                            var productPictureURL = res[i].pictureUrl;
                            var productName = res[i].productName;
                            var productQuantity = res[i].prductQuantity;
                            var productPrice = res[i].price;
                            var totalCost = res[i].totalCost;
                            // console.log(categoryName);
                            var cartItem = `
                <tr class="rem1" id="isi">
                    <td class="invert">1</td>
                    <td class="invert-image"><a href="single.html"><img src="${productPictureURL}" alt="Product Image " class="img-responsive" /></a></td>
                    <td class="invert">${productName}</td>
                    <td class="invert">
                        <div class="quantity"> 
                            <div class="quantity-select">                           
                                <div class="entry value-minus">&nbsp;</div>
                                <div class="entry value"><span>${productQuantity}</span></div>
                                <div class="entry value-plus active">&nbsp;</div>
                            </div>
                        </div>
                    </td>
                    <td class="invert">${productPrice}</td>
                    <td class="invert">${totalCost}</td>
                    <td class="invert">
                    <div class="rem">
                        <button  class='btn-danger' onclick=deleteCartItem(${number})>Delete</button>
                    </div>
                    </td>
                </tr>
            `;

                            $("#cart").append(cartItem);
                        }
                    } else if (res.length < 1 && cart.length < 1) {
                        cards.push(errorMessage);
                    }
                }
            }
        })
    },
}

$("#cart").on("click", "#btn-danger", function () {
    $.ajax({
        url: '/api/cart/delete{id}',
        method: 'delete',
        contentType: 'application/json',
        success: function (res, status, xhr) {
            if (xhr.status == 200 || xhr.status == 201) {
                console.log(res);
                alert("Thank you for trusting Daily You!");
            }
        }
    })

});
