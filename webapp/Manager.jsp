<%--
  Created by IntelliJ IDEA.
  User: Rick
  Date: 2019-02-02
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--引入样式--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/TPS_grid.js"></script>

        <title>管理员登陆</title>
</head>
<body>
<div class="jumbotron" id="man_login">
    <div class="container ">
        <h1>欢迎来到机票事务处理系统</h1>
        <div class="row">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="man_account" class="col-sm-2 control-label col-sm-offset-1" >管理员账号</label>
                    <div class="col-sm-7">
                        <input class="form-control" id="man_account" >
                        <span class="help-block"></span>

                    </div>
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <label for="man_pwd" class="col-sm-2 control-label col-sm-offset-1" >管理员密码</label>
                    <div class="col-sm-7">
                        <input type="password" class="form-control" id="man_pwd" >
                        <span class="help-block"></span>

                    </div>
                    <span class="help-block"></span>
                </div>
                <%--<div class="form-group">--%>
                    <%--<div class="col-sm-offset-4 col-sm-10">--%>
                        <%--<div class="checkbox">--%>
                            <%--<label>--%>
                                <%--<input type="checkbox"> 记住密码--%>
                            <%--</label>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            </form>
            <div class="form-group">
                <div class="col-sm-offset-5 col-sm-10">
                    <button id="submit" type="submit" class="btn btn-default" >登陆</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    //登陆点击事件
    $("#submit").click(function(){
        man_account=$("#man_account").val();
        man_pwd=$("#man_pwd").val();
        $.ajax({
            url:"manlogin",
            data:{manAccount:man_account,manPwd:man_pwd},
            type:"POST",
            success:function(result){
                console.log(result);
                if(result.code==100){
                    alert("欢迎登陆");
                    window.location.replace("TPS");
                }else{
                        check_information_bot("#man_account","error","");
                        $("#man_account").attr("ajax","fail");
                        check_information_bot("#man_pwd","error",result.extend.login_msg);
                        $("#man_pwd").attr("ajax","fail");

                }
            }
        })
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
</script>
</body>
</html>
