var tableMahasiswa = {
  create: function () {
    // jika table tersebut datatable, maka clear and dostroy
    if ($.fn.DataTable.isDataTable('#tableMahasiswa')) {
      //table yg sudah dibentuk menjadi datatable harus d rebuild lagi untuk di instantiasi ulang
      $('#tableMahasiswa').DataTable().clear();
      $('#tableMahasiswa').DataTable().destroy();
    }

    $.ajax({
      url: '/api/mahasiswa',
      method: 'get',
      contentType: 'application/json',
      success: function (res, status, xhr) {
        if (xhr.status == 200 || xhr.status == 201) {
          $('#tableMahasiswa').DataTable({
            data: res,
            columns: [
              {
                title: "Nama Lengkap",
                data: "nama"
              },
              {
                title: "Alamat",
                data: "alamat"
              },
              {
                title: "Agama",
                data: "namaAgama"
              },
              {
                title: "Jurusan",
                data: "namaJurusan"
              },

              {
                title: "Action",
                data: null,
                render: function (data, type, row) {
                  return "<button class='btn-primary' onclick=formMahasiswa.setEditData('" + data.id + "'); style='border-radius:12px ;'>Edit</button>"  +"&ensp;"+
                    "<button class='btn-danger' onclick=actionDelete.deleteConfirm('" + data.id + "'); style='border-radius:12px ;'>Delete</button>"
                }
              }
            ]
          });

        } else {

        }
      },
      error: function (err) {
        console.log(err);
      }
    });


  }
};

var formMahasiswa = {
  resetForm: function () {
    $('#form-mahasiswa')[0].reset();
    $('#id').val("");
  },
  saveForm: function () {
    if ($('#form-mahasiswa').parsley().validate()) {
      var dataResult = getJsonForm($("#form-mahasiswa").serializeArray(), true);

      $.ajax({
        url: '/api/mahasiswa',
        method: 'post',
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(dataResult),
        success: function (res, status, xhr) {
          if (xhr.status == 200 || xhr.status == 201) {
            tableMahasiswa.create();
            $('#modal-mahasiswa').modal('hide')

          } else {

          }
        },
        erorrr: function (err) {
          console.log(err);
        }
      });
    }
  }, setEditData: function (idCabang) {
    formMahasiswa.resetForm();

    $.ajax({
      url: '/api/mahasiswa/' + idCabang,
      method: 'get',
      contentType: 'application/json',
      dataType: 'json',
      success: function (res, status, xhr) {
        if (xhr.status == 200 || xhr.status == 201) {
          $('#form-mahasiswa').fromJSON(JSON.stringify(res));
          $('#modal-mahasiswa').modal('show')

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
  deleteConfirm: function (idCabang) {

    $.ajax({
      url: '/api/mahasiswa/' + idCabang,
      method: 'get',
      contentType: 'application/json',
      dataType: 'json',
      success: function (res, status, xhr) {
        if (xhr.status == 200 || xhr.status == 201) {

          $('#form-mahasiswa').fromJSON(JSON.stringify(res));
          $('#modal-delete').modal('show')
        } else {

        }
      },
      erorrr: function (err) {
        console.log(err);
      }
    });

  }, deleteRowData: function () {
    if ($('#form-mahasiswa').parsley().validate()) {
      var dataResult = getJsonForm($("#form-mahasiswa").serializeArray(), true);

      $.ajax({
        url: '/api/mahasiswa/' + dataResult.id,
        method: 'delete',
        success: function () {
          tableMahasiswa.create()
          $('#modal-delete').modal('hide')
        },
        erorrr: function (err) {
          console.log(err);
        }
      });

    }
  }

};

var dropDown = {
  pilihAgama: function (){
    $.ajax({
      type:"GET",
      url:"/api/agama",
      contentType: 'application/json',
      dataType:'json',
      success:function (data){
        var a = '<option value="-1">Pilih Agama</option>';
        for (var i = 0; i < data.length; i++){
          a += '<option value="' + data[i].id +'">' + data[i].namaAgama +'</option>'
        }
        $("#namaAgama").append(a);
      }

    })
  },
  pilihJurusan: function (){
    $.ajax({
      type:"GET",
      url:"/api/jurusan",
      contentType: 'application/json',
      dataType:'json',
      success:function (data){
        var b = '<option value="-1">Pilih Jurusan</option>';
        for (var i = 0; i < data.length; i++){
          b += '<option value="' + data[i].id +'">' + data[i].namaJurusan +'</option>'
        }
        $("#namaJurusan").append(b);
      }

    })
  }

}





