$(function() {
    $("#opencard").click(function(){
        $.ajax({
            //请求方式
            type : "GET",
            //请求的媒体类型
            // contentType: "application/json;charset=UTF-8",
            //请求地址
            url : "http://127.0.0.1:8080/card/opencard",
            //数据，json字符串
            // data : JSON.stringify(list),
            //请求成功
            success : function(result) {
                if(result.code == 1){
                    alert("成功");
                }
                else if(result.code == 3){
                    alert("您已经开过卡了");
                }else{
                    alert("服务器报错啦");
                }
            },
            //请求失败，包含具体的错误信息
            error : function(e){
                alert(e);
            }
        });
    });

    $("#cancelcard").click(function(){
        $.ajax({
            //请求方式
            type : "GET",
            //请求的媒体类型
            // contentType: "application/json;charset=UTF-8",
            //请求地址
            url : "http://127.0.0.1:8080/card/cancelcard",
            //数据，json字符串
            // data : JSON.stringify(list),
            //请求成功
            success : function(result) {
                if(result.code == 1){
                    alert("成功");
                }
                else if(result.code == 5){
                    alert("您已经注销了或者还有余额");
                }else{
                    alert("服务器报错啦");
                }
            },
            //请求失败，包含具体的错误信息
            error : function(e){
                alert(e);
            }
        });
    });
});