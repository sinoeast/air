$(function(){
    $("#cus_login").click(function(){
        //清除表单数据，取出dom对象，使用reset方法
        $("#modal form")[0].reset();
        //清除提示信息
        $("#modal form").find("*").removeClass("has-error has-success");
        $("#modal form").find(".help-block").text("");
        //打开模态框
        $("#modal").modal({
        backdrop:"static"
        });

    });

    //登陆点击事件
    $("#login_cus").click(function(){
        account=$("#account").val();
        cus_pwd=$("#cus_pwd").val();
        $.ajax({
            url:"loginCus",
            data:{Account:account,cusPwd:cus_pwd},
            type:"POST",
            success:function(result){
                console.log(result);
                if(result.code==100){
                    alert("欢迎登陆");
                    window.location.reload();
                    $("#modal").modal('hide');
                }else{
                    check_information_bot("#account","error","");
                    $("#man_account").attr("ajax","fail");
                    check_information_bot("#cus_pwd","error",result.extend.login_msg);
                    $("#man_pwd").attr("ajax","fail");
                }
            }
        })
    });
});
//校验出错时提醒,提示条和框颜色
function check_information_bot(element,infomation,msg){
    $(element).parent().removeClass(" has-error has-success");
    $(element).next("span").text("");
    if("error"==infomation){
        $(element).parent().addClass("has-error");
        $(element).next("span").text(msg);
    }else if("success"==infomation){
        $(element).parent().addClass("has-success");
        $(element).next("span").text(msg);
    }
}

// 退出账号
function  loginout() {
    $.ajax({
        url:"cust_logout",
        async:false,
        success:function (resp) {
            //刷新当前界面
            window.location.reload();
            alert("账户退出成功");
        }
    });
}
function a(){
    var a='<%=session.getAttribute("Account")%>';
    if($("#cusinfo").text(a)!=null){
        $("#cusinfo").text(a)
    }
}