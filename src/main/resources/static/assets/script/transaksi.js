var create = {
  getAllItemCart: function () {
    $.ajax({
      url: '/api/cart',
      method: 'get',
      contentType: 'application/json',
      success: function (res, status, xhr) {
        console.log(xhr.status)
        if (xhr.status == 200 || xhr.status == 201) {

          console.log(res.length);
          // var cart = [];
          // if (res.length > 0 && cart.length < 1) {
            for (i = 0; i < res.length; i++) {
              var id = res[i].id
              var pictureUrl = res[i].product.pictureUrl
              var productName = res[i].product.productName
              var productQuantity = res[i].productQuantity
              var price = res[i].product.price

              document.getElementById("tableCart").innerHTML +=
                '<tr class="rem1" id="cart">'+
                    '<td class="invert">'+i+'</td>'+
                    '<td class="invert-image"><a href="single.html"><img src="'+pictureUrl+'" alt="Product Image" class="img-responsive" /></a></td>'+
                    '<td class="invert">'+productName+'</td>'+
                    '<td class="invert">'+
                        '<div class="quantity">'+
                            '<div class="quantity-select">'+
                                '<div class="entry value-minus">&nbsp;</div>'+
                                '<div class="entry value"><span>'+productQuantity+'</span></div>'+
                                '<div class="entry value-plus active">&nbsp;</div>'+
                            '</div>'+
                        '</div>'+
                    '</td>'+
                    '<td class="invert">'+price+'<td>'+
                    '<div class="rem">'+
                        '<button  class="btn-danger" onclick="deleteRow('+id+')">Delete</button>'+
                    '</div>'+
                    '</td>'+
                '</tr>'

            }
          // } else if (res.length < 1 && cart.length < 1) {
          //   cart.push(errorMessage);
          // }
        }
      }
    })
  }
}

// $("#deleteRow").on("click", "#btn-danger",
function deleteRow (id) {
  $.ajax({
    url: '/api/cart/delete/'+id,
    method: 'delete',
    contentType: 'application/json',
    success: function (res, status, xhr) {
      if (xhr.status == 200 || xhr.status == 201) {
        console.log(res);
        alert("are you sure to delete this?");
      }
    }
  })

};
//
// create.getAllItemCart();
