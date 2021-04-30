var tableTransaksi = {
  create: function () {
    if ($.fn.DataTable.isDataTable('#tableTransaksi')) {
      $('#tableTransaksi').DataTable().clear();
      $('#tableTransaksi').DataTable().destroy();
    }

    $.ajax({
      url: '/api/transaksi',
      method: 'get',
      contentType: 'application/json',
      success: function (res, status, xhr) {
        if (xhr.status == 200 || xhr.status == 201) {
          $('#tableTransaksi').DataTable({
            data: res,
            columns: [
              {
                title: "id user",
                data: "idUser"
              },
              {
                title: "id transaksi",
                data: "idTransaksi"
              },
              {
                title: "Alamat",
                data: "alamat"
              },
              {
                title: "Action",
                data: null,
                render: function (data, type, row) {
                  return "<button class='btn-success' data-toggle='tooltip' title='edit' data-placement='bottom' onclick=formTransaksi.setEditData('" + data.idTransaksi + "') style='border-radius: 20%'><i class='fa fa-pencil-alt'></i></button>" + "<span>   </span>" +
                    "<button class='btn-danger' data-toggle='tooltip' title='delete' data-placement='bottom' onclick=actionDelete.deleteConfirm('" + data.idTransaksi + "') style='border-radius: 20%'><i class='fa fa-minus-circle'></i></button>"
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

    $.ajax({
      type: 'get',
      url: '/api/user',
      contentType: 'application/json',
      dataType: 'json',
      success: function (res) {
        console.log(res)
        let opt = '<option disabled selected hidden>-- Pilih --</option>';
        for(let i=0; i<res.length; i++) {
          opt += '<option value=' + res[i].idUser + '>' + res[i].nama + '</option>'
        }
        $('#nama').html(opt);
      }
    });
  }
};

var formTransaksi = {
  resetForm: function () {
    $('#form-transaksi')[0].reset();
    $('#idTransaksi').val("");
  },

  // saveForm: function () {
  //
  //   if ($('#form-transaksi').parsley().validate()) {
  //     var dataResult = getJsonForm($("#form-transaksi").serializeArray(), true);
  //     $.ajax({
  //       url: '/api/transaksi/upload',
  //       method: 'post',
  //       contentType: 'application/json',
  //       dataType: 'json',
  //       data: JSON.stringify(dataResult),
  //       success: function (res, status, xhr) {
  //         if (xhr.status == 200 || xhr.status == 201) {
  //           tableTransaksi.create();
  //           $('#modal-transaksi').modal('hide')
  //         } else {
  //         }
  //       },
  //       erorrr: function (err) {
  //         console.log(err);
  //       }
  //     });
  //   }
  // },

  setEditData: function (idCabang) {
    formTransaksi.resetForm();
    $.ajax({
      url: '/api/transaksi/' + idCabang,
      method: 'get',
      contentType: 'application/json',
      dataType: 'json',
      success: function (res, status, xhr) {
        if (xhr.status == 200 || xhr.status == 201) {
          $('#form-transaksi').fromJSON(JSON.stringify(res));
          $('#modal-transaksi').modal('show')
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
  deleteConfirm: function (id) {
    $.ajax({
      url: '/api/transaksi/' + id,
      method: 'get',
      contentType: 'application/json',
      dataType: 'json',
      success: function (res, status, xhr) {
        if (xhr.status == 200 || xhr.status == 201) {
          $('#form-transaksi').fromJSON(JSON.stringify(res));
          $('#modal-delete').modal('show')
        } else {

        }
      },
      erorrr: function (err) {
        console.log(err);
      }
    });
  },

  deleteRowData : function () {
    if ($('#form-transaksi').parsley().validate()) {
      var dataResult = getJsonForm($("#form-transaksi").serializeArray(), true);

      $.ajax({
        url: '/api/transaksi/' + dataResult.idTransaksi,
        method: 'delete',
        success: function () {
          tableTransaksi.create();
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
      url: '/api/transaksi',
      method: 'delete',
      success: function () {
        tableTransaksi.create()
        $('#modal-delete').modal('hide')
      }

    })
  }
};
