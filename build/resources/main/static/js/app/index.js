let main = {
    init : function () {
        let _this = this; //main{}

        //save-btn event handler
        $('#btn-save').on('click', function (){
            _this.save();
        });

        $('#btn-update').on('click', function (){
            _this.update();
        });

        $('#btn-delete').on('click', function (){
            _this.delete();
        });
    },
    save : function () {

        //html 에서 데이터를 가져옴
        let data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        // 브라우저에서 지원하는 비동기적인 통신방법
        $.ajax({
          type: 'POST', //전송방식
          url: '/api/v1/posts', //호출 url
          dataType: 'json', //전송받는 data type
          contentType:'application/json; charset=utf-8', //서버에서 데이터를 보낼때 보내는 타입
          data: JSON.stringify(data)//게시글에 들어갈 데이터 JSON.stringify()로 문자열로 변형시킴.
        }).done(function (){
            alert('글이 등록되었습니다'); //성공시 띄워줄 알림창
            window.location.href = '/'; //다시 홈페이지로 이동
        }).fail(function (error) {
            alert(JSON.stringify(error)); //실패시 실패이유를 알림창으로 띄워줌
        });

        console.log(data);
    },
    update : function () {

        let data = {
            title: $('#title').val(),
            content: $('#content').val()
        }

        let id = $('#id').val();

        $.ajax({
            type: 'PUT', //데이터를 수정한다.
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정 되었습니다.');
            window.location.href= '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    delete : function (){
        let id = $('#id').val();

        $.ajax({
            type:'delete',
            url:'/api/v1/posts/'+id,
            dataType:'json',
            contentType:'application/json; charset=utf-8'
        }).done(function () {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error))
        });

    }
};

main.init();