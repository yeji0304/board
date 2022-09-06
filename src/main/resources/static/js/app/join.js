var main = {
    init : function () {
        var _this = this;
        $('#userSave').on('click', function () {
            _this.userSave();
        });

        $('#userUpdate').on('click', function () {
            _this.userUpdate();
        });

        $('#userDelete').on('click', function () {
            _this.userDelete();
        });
    },

    userSave : function () {
        var data = {
            email: $('#email').val(),
            password: $('#password').val(),
            password: $('#password').val(),
            username: $('#username').val(),
            ninkname: $('#nickname').val(),
        };

        $.ajax({
            type: 'POST',
            url: '/users/new',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입이 완료되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

     userUpdate : function () {
        var data = {
            password: $('#password').val(),
            username: $('#username').val(),
            ninkname: $('#nickname').val(),
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/users/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원정보가 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
     },

      userDelete : function () {
         var id = $('#id').val();

         $.ajax({
            type: 'DELETE',
            url: '/users/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
         }).done(function() {
            alert('계정이 삭제되었습니다.');
            window.location.href = '/';
         }).fail(function (error) {
            alert(JSON.stringify(error));
         });
      }
    };

main.init();