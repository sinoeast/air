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
        <script type="text/javascript" src="js/cus_grid.js"></script>
        <script type="text/javascript" src="js/cus_info.js"></script>
    <title>机票界面</title>
</head>
<body>
<div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">航空系统</a>
    </div>
    <div class="collapse navbar-collapse bs-example-js-navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="dropdown">
                <a id="drop1" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    功能待开发
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" aria-labelledby="drop1">
                    <li><a id="3" href="#">修改个人信息</a></li>
                    <li><a id="2" href="#">查看我的订单</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a id="drop2" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    功能待开发
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" aria-labelledby="drop2">
                    <li><a  href="#">修改个人信息</a></li>
                    <li><a href="#">查看订单</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li id="fat-menu" class="dropdown">
                <a  id="cusinfo" href="javascript:void(0);"  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    登录
                    <%
                        Cookie c[]=request.getCookies();
                        for(int x=0;x<c.length;x++){
                    %>
                    <%=c[x].getName()+':'+c[x].getValue()%>
                    <%
                        }
                    %>
                    <%=session.getAttribute("Account")%>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" id="dropdown-menu1" aria-labelledby="drop3">
                    <li><a id="cus_login"  data-toggle="select"  href="javascript:void(0)" onclick="a()">登陆</a></li>
                    <li><a id="cus_info"  data-toggle="select"  href="javascript:void(0)">修改个人信息</a></li>
                    <li><a id="cus_book" href="#">查看订单</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a id="logout" ref="javascript:void(0)" onclick="loginout()" >安全退出账号</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <form class="navbar-form navbar-left">
                    起始地：
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    目的地：
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default ">搜索</button>
                </form>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>
<%--航空信息table--%>
<div style="margin: 0 200px;" col-md-12>
    <table id="table" class="table  table-condensed table-striped">
        <tr >
            <th class="col-md-12" style="text-align: center">航班信息</th>
        </tr>
        <%--解析数据--%>
        <tbody id="flightinformation">
        </tbody>
    </table>
    <%--信息--%>
    <div class="row">
        <%--文字--%>
        <div class="col-md-6" id="page_info2"></div>
        <%--分页条--%>
        <div class="col-md-6" >
            <nav aria-label="Page navigation">
                <ul class="pagination" id="page_nav2">

                </ul>
            </nav>
        </div>
    </div>
</div>




<%--登陆--%>
<div id="modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="gridSystemModalLabel">用户登陆</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="account">用户账号</label>
                        <input type="text" class="form-control" name="cusAccount" id="account" placeholder="请输入账号或手机号">
                        <span class="help-block"></span>
                    </div>
                    <div class="form-group">
                        <label for="cus_pwd">用户密码</label>
                        <input type="password" class="form-control" name="cusPwd" id="cus_pwd" placeholder="请输入密码">
                        <span class="help-block"></span>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary"  id="login_cus">登陆</button>
                <button type="button" class="btn btn-default col-sm-offset-6" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<%--//填写订单--%>
<div id="bookModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">填写订单</h4>
            </div>
            <div id="modalBody" class="modal-body">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="input-group">
                            <input id="fliBaddress" type="text" class="form-control" readonly />
                            <span class="input-group-addon">飞往></span>
                            <input id="fliAaddress" type="text" class="form-control" readonly />
                        </div>
                        <!-- 这里的margintop最好用一个class然后同一设置 -->
                        <div class="input-group" style="margin-top: 20px">
                            <input id="fliBtime" type="text" class="form-control" readonly />
                            <span class="input-group-addon">——</span>
                            <input id="fliAtime" type="text" class="form-control" readonly />
                        </div>
                        <div class="input-group" style="margin-top: 20px">
                            <span class="input-group-addon">机型</span>
                            <input id="airCode" type="text" class="form-control" readonly />
                        </div>
                        <div class="input-group" style="margin-top: 20px">
                            <span class="input-group-addon">航空公司</span>
                            <input id="comName" type="text" class="form-control" readonly />
                        </div>
                        <div class="input-group" style="margin-top: 20px">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">请选择服务类型 <span class="caret"></span></button>
                                <ul id="serviceTypeOptions" class="dropdown-menu">
                                    <li><a class="selectFareType">经济舱</a></li>
                                    <li><a class="selectFareType">公务舱</a></li>
                                    <li><a class="selectFareType">头等舱</a></li>
                                </ul>
                            </div>
                            <input id="fareType" type="text" value="选择服务类型" class="form-control needClear" placeholder="请选择服务类型" readonly />
                        </div><!-- /input-group -->
                        <div class="input-group" style="margin-top: 20px">
                            <span class="input-group-addon">订单备注</span>
                            <input id="note" type="text" class="form-control needClear" placeholder="必要时可以输入备注" />
                        </div>
                        <div class="input-group" style="margin-top: 20px">
                            <span class="input-group-addon">乘客1</span>
                            <input type="text" class="form-control myPsg" readonly />
                            <span class="input-group-addon">乘客2</span>
                            <input type="text" class="form-control myPsg needClear otherPsg" placeholder="如果有请加入" />
                        </div>
                        <div class="input-group" style="">
                            <span class="input-group-addon">乘客3</span>
                            <input type="text" class="form-control myPsg needClear otherPsg" placeholder="乘客必须是" />
                            <span class="input-group-addon">乘客4</span>
                            <input type="text" class="form-control myPsg needClear otherPsg" placeholder="系统用户" />
                        </div>
                    </div><!-- /.col-lg-6 -->
                </div><!-- /.row -->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="submitOrder" onclick="submitOrder()" type="button" class="btn btn-primary">提交订单</button>
            </div>
        </div>
    </div>
</div>
<%--个人信息修改--%>
<div class="modal fade" id="select" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabe2">
                    个人信息修改
                </h4>
            </div>
            <div style="margin: 20px;">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">AutoId</label>
                        <div class="col-sm-10">
                            <input type="password" id="cusAutoId" readonly name="cusAutoId" class="form-control" placeholder="用户编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" id="cusAccount" name="cusAccount" class="form-control" placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">修改密码</label>
                        <div class="col-sm-10">
                            <input type="password" id="cusPwd" name="cusPwd" class="form-control" type="password" placeholder="修改后密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">手机号</label>
                        <div class="col-sm-10">
                            <input type="text" id="cusTelnumber" name="cusTelnumber" class="form-control " placeholder="手机号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <input type="text" id="cusSex" name="cusSex" class="form-control" placeholder="性别">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">注册时间</label>
                        <div class="col-sm-10">
                            <input type="text" id="cusTime" name="cusTime" readonly class="form-control" placeholder="注册时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" class="btn btn-primary">
                                提交更改
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%--登陆--%>
<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabe3">
                    个人信息修改
                </h4>
            </div>
            <div style="margin: 20px;">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" id="userName" name="username" class="form-control" placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text" id="password" name="cusPwd" class="form-control" type="password" placeholder="修改后密码">
                        </div>
                    </div>
                    <input id="fli_autoid" name="cusPwd" class="form-control" type="hidden" placeholder="修改后密码">
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" id="user_login" onclick="userlogin()" class="btn btn-primary">
                                提交更改
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
