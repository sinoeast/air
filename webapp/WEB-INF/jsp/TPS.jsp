<%--
  Created by IntelliJ IDEA.
  User: Rick
  Date: 2019-02-02
  Time: 23:35
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
        <link rel="stylesheet" href="static/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
        <script src="static/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
        <script src="static/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
        <script type="text/javascript" src="js/TPS_grid.js"></script>
        <script type="text/javascript" src="js/TPS_insert.js"></script>
        <script type="text/javascript" src="js/TPS_updata.js"></script>
        <script type="text/javascript" src="js/TPS_delete.js"></script>
        <title>事务处理系统</title>
</head>

<body>
<h3>欢迎：<%=session.getAttribute("manAccount") %></h3>
<div>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">订单管理</a></li>
        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">航空管理</a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane fade in active" id="home">
            <%--订单管理--%>
            <div class="container">
                <%--标题--%>
                <div class="row">
                    <div class="col-md-12">
                        <h1>订单信息</h1>
                    </div>
                </div>
                <%--新增删除按钮--%>
                <div class="row">
                    <div class="col-md-4 col-md-offset-10">
                        <button class="btn btn-primary"  id="Insert">新增</button>
                        <button class="btn btn-danger"   id="deleteall">删除</button>
                    </div>
                </div>
                <%--表格--%>
                <div class="row" id="bookInformation">
                    <div class="col-md-12">
                        <table class="table table-bordered table-striped table-hover">

                            <tr >
                                <th >
                                    <input type="checkbox" id="check_all"/>
                                </th>
                                <th class="col-md-1">订单编号</th>
                                <th class="col-md-1">用户名</th>
                                <th class="col-md-1">出发城市</th>
                                <th class="col-md-1">目标城市</th>
                                <th class="col-md-2">出发时间</th>
                                <th class="col-md-2">到达时间</th>
                                <th class="col-md-1">舱位</th>
                                <th class="col-md-1">座位号</th>
                                <th class="col-md-2">操作</th>
                            </tr>
                            <%--解析数据--%>
                            <tbody id="bookinformation">
                            </tbody>
                        </table>
                    </div>
                </div>
                <%--信息--%>
                <div class="row">
                    <%--文字--%>
                    <div class="col-md-6" id="page_info"></div>
                    <%--分页条--%>
                    <div class="col-md-6" >
                        <nav aria-label="Page navigation">
                            <ul class="pagination" id="page_nav">

                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>

        <%-------------------------------------%>


        <div role="tabpanel" class="tab-pane fade" id="profile">
            <%--航空管理--%>
                <div class="container">
                    <%--标题--%>
                    <div class="row">
                        <div class="col-md-12">
                            <h1>航班信息</h1>
                        </div>
                    </div>
                    <%--新增删除按钮--%>
                    <div class="row">
                        <div class="col-md-4 col-md-offset-10">
                            <button class="btn btn-primary"  id="Insert2">新增</button>
                            <button class="btn btn-danger"   id="deleteall2">删除</button>
                        </div>
                    </div>
                    <%--表格--%>
                    <div class="row" id="bookInformation">
                        <div class="col-md-12">
                            <table class="table table-bordered table-striped table-hover">
                                <tr >
                                    <th >
                                        <input type="checkbox" id="checkAll"/>
                                    </th>
                                    <th class="col-md-1">航班编号</th>
                                    <th class="col-md-1">航空公司</th>
                                    <th class="col-md-1">出发城市</th>
                                    <th class="col-md-1">目标城市</th>
                                    <th class="col-md-2">出发时间</th>
                                    <th class="col-md-2">到达时间</th>
                                    <th class="col-md-1">机型</th>
                                    <th class="col-md-1">折扣</th>
                                    <th class="col-md-2">操作</th>
                                </tr>
                                <%--解析数据--%>
                                <tbody id="flightinformation">
                                </tbody>
                            </table>
                        </div>
                    </div>
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
        </div>
    </div>
</div>
<div class="container">
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
                            <div class="input-group" style="margin-top: 20px">
                                <input id="fareType1" type="text" value="选择服务类型" class="form-control needClear" placeholder="请选择服务类型"  />
                            </div><!-- /input-group -->
                            <div class="input-group">
                                <input id="fliBaddress" type="text" class="form-control"  />
                                <span class="input-group-addon">飞往></span>
                                <input id="fliAaddress" type="text" class="form-control"  />
                            </div>
                            <!-- 这里的margintop最好用一个class然后同一设置 -->
                            <div class="input-group" style="margin-top: 20px">
                                <input id="fliBtime" type="text" class="form-control"  />
                                <span class="input-group-addon">——</span>
                                <input id="fliAtime" type="text" class="form-control"  />
                            </div>
                            <div class="input-group" style="margin-top: 20px">
                                <span class="input-group-addon">机型</span>
                                <input id="airCode" type="text" class="form-control"  />
                            </div>
                            <div class="input-group" style="margin-top: 20px">
                                <span class="input-group-addon">航空公司</span>
                                <input id="comName" type="text" class="form-control"  />
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
                                <input id="fareType" type="text" value="选择服务类型" class="form-control needClear" placeholder="请选择服务类型"  />
                            </div><!-- /input-group -->
                            <div class="input-group" style="margin-top: 20px">
                                <span class="input-group-addon">订单备注</span>
                                <input id="note" type="text" class="form-control needClear" placeholder="必要时可以输入备注" />
                            </div>
                            <div class="input-group" style="margin-top: 20px">
                                <span class="input-group-addon">乘客1</span>
                                <input type="text" class="form-control myPsg"  />
                                <span class="input-group-addon">乘客2</span>
                                <input type="text" class="form-control myPsg needClear otherPsg" placeholder="如果有请加入" />
                            </div>
                            <div class="input-group" style="">
                                <span class="input-group-addon">乘客3</span>
                                <input type="text" class="form-control myPsg needClear otherPsg" placeholder="如果有请加入" />
                                <span class="input-group-addon">乘客4</span>
                                <input type="text" class="form-control myPsg needClear otherPsg" placeholder="如果有请加入" />
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
</div>
<div class="container">
    <%--//填写航班--%>
    <div id="flightModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" >新增航班</h4>
                </div>
                <div  class="modal-body">
                    <form>
                    <div class="row">
                        <div class="col-lg-12">

                            <div class="input-group">
                                <div>
                                    <input  type="text" class="form-control" name="fliBaddress" id="baddress" />
                                </div>
                                <span class="input-group-addon">飞往</span>
                                <div>
                                    <input  type="text" class="form-control"name="fliAaddress" id="aaddress" />
                                </div>
                            </div>
                            <span class="help-block"></span>
                            <!-- 这里的margintop最好用一个class然后同一设置 -->
                            <div class="input-group" style="margin-top: 20px">
                                <%--<input  type="text" class="form-control"  />--%>
                                    <span class="input-group-addon">起飞时间</span>
                                    <div class="input-group date form_datetime "  data-date="2019-02-26" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                                        <input name="fliBtime" id="btime" class="form-control" size="30" type="text" value="" readonly>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                    </div>
                                    <span class="input-group-addon">到达时间</span>
                                    <div class="input-group date form_datetime " data-date="2019-02-26" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                                        <input name="fliAtime" id="atime" class="form-control" size="30" type="text" value="" readonly>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                    </div>
                            </div>
                            <span class="help-block"></span>

                            <div class="input-group" style="margin-top: 20px">
                                <span class="input-group-addon">航空公司</span>
                                <select class="form-control col-md-4" name="comCode" id="Selectcheck1"></select>
                            </div>
                            <div class="input-group" style="margin-top: 20px">
                                <span class="input-group-addon">机型</span>
                                <select class="form-control col-md-4" name="airCode" id="Selectcheck"></select>
                            </div>

                            <div class="input-group" style="margin-top: 20px">
                                <span class="input-group-addon">航班编号</span>
                                <input  name="fliNo" type="text" class="form-control" id="fliNo" readonly/>
                            </div>
                            <div class="input-group" style="margin-top: 20px">

                                <span class="input-group-addon">折扣</span>
                                <div >
                                    <input name="fliDiscount" id="discount" type="text" class="form-control needClear"  />
                                </div>

                                <span class="input-group-addon">星期</span>
                                <div >
                                    <input name="fliEveryday" type="text" class="form-control needClear" id="everyday"/>
                                </div>
                            </div>
                            <span class="help-block"></span>
                            <div class="input-group" style="margin-top: 20px">
                                <span class="input-group-addon">经济舱座位数量</span>
                                <input name="fliYnumber" type="text" class="form-control myPsg" id="Y" readonly/>
                                <span class="input-group-addon">经济舱座位价格</span>
                                <div>
                                    <input id="Ynumber" name="fliYfare" type="text" class="form-control myPsg needClear otherPsg"  />
                                </div>
                            </div>
                            <span class="help-block"></span>
                            <div class="input-group" style="">
                                <span class="input-group-addon">公务舱座位数量</span>
                                <input name="fliCnumber" type="text" class="form-control myPsg needClear otherPsg" id="C"readonly/>
                                <span class="input-group-addon">公务舱座位价格</span>
                                <div>
                                    <input id="Cnumber" name="fliCfare" type="text" class="form-control myPsg needClear otherPsg"  />
                                </div>
                            </div>
                            <span class="help-block"></span>

                            <div class="input-group" style="">
                                <span class="input-group-addon">头等舱座位数量</span>
                                <input name="fliFnumber" type="text" class="form-control myPsg needClear otherPsg" id="F"readonly/>
                                <span class="input-group-addon">头等舱座位价格</span>
                                <div>
                                    <input id="Fnumber" name="fliFfare" type="text" class="form-control myPsg needClear otherPsg"  />
                                </div>
                            </div>
                            <span class="help-block"></span>

                        </div><!-- /.col-lg-6 -->
                    </div><!-- /.row -->
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button onclick="submitFliinfor()" type="button" class="btn btn-primary">提交</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <%--//修改航班--%>
    <div id="flightModal_updata" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" >修改航班</h4>
                </div>
                <div  class="modal-body">
                    <form>
                        <div class="row">
                            <div class="col-lg-12">

                                <div class="input-group">
                                    <div>
                                        <input  type="text" class="form-control" name="fliBaddress" id="baddress1" />
                                    </div>
                                    <span class="input-group-addon">飞往</span>
                                    <div>
                                        <input  type="text" class="form-control"name="fliAaddress" id="aaddress1" />
                                    </div>
                                </div>
                                <span class="help-block"></span>
                                <!-- 这里的margintop最好用一个class然后同一设置 -->
                                <div class="input-group" style="margin-top: 20px">
                                    <%--<input  type="text" class="form-control"  />--%>
                                    <span class="input-group-addon">起飞时间</span>
                                    <div class="input-group date form_datetime "  data-date="2019-02-26" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                                        <input name="fliBtime" id="btime1" class="form-control" size="30" type="text" value="" readonly>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                    </div>
                                    <span class="input-group-addon">到达时间</span>
                                    <div class="input-group date form_datetime " data-date="2019-02-26" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                                        <input name="fliAtime" id="atime1" class="form-control" size="30" type="text" value="" readonly>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                    </div>
                                </div>
                                <span class="help-block"></span>

                                <div class="input-group" style="margin-top: 20px">
                                    <span class="input-group-addon">航空公司</span>
                                    <select class="form-control col-md-4" name="comCode" id="Selectcheck2"></select>
                                </div>
                                <div class="input-group" style="margin-top: 20px">
                                    <span class="input-group-addon">机型</span>
                                    <select class="form-control col-md-4" name="airCode" id="Selectcheck3"></select>
                                </div>

                                <div class="input-group" style="margin-top: 20px">
                                    <span class="input-group-addon">航班编号</span>
                                    <input  name="fliNo" type="text" class="form-control" id="fliNo1" readonly/>
                                </div>
                                <div class="input-group" style="margin-top: 20px">

                                    <span class="input-group-addon">折扣</span>
                                    <div >
                                        <input name="fliDiscount" id="discount1" type="text" class="form-control needClear"  />
                                    </div>

                                    <span class="input-group-addon">星期</span>
                                    <div >
                                        <input name="fliEveryday" type="text" class="form-control needClear" id="everyday1"/>
                                    </div>
                                </div>
                                <span class="help-block"></span>
                                <div class="input-group" style="margin-top: 20px">
                                    <span class="input-group-addon">经济舱座位数量</span>
                                    <input name="fliYnumber" type="text" class="form-control myPsg" id="Y1" readonly/>
                                    <span class="input-group-addon">经济舱座位价格</span>
                                    <div>
                                        <input id="Ynumber1" name="fliYfare" type="text" class="form-control myPsg needClear otherPsg"  />
                                    </div>
                                </div>
                                <span class="help-block"></span>
                                <div class="input-group" style="">
                                    <span class="input-group-addon">公务舱座位数量</span>
                                    <input name="fliCnumber" type="text" class="form-control myPsg needClear otherPsg" id="C1"readonly/>
                                    <span class="input-group-addon">公务舱座位价格</span>
                                    <div>
                                        <input id="Cnumber1" name="fliCfare" type="text" class="form-control myPsg needClear otherPsg"  />
                                    </div>
                                </div>
                                <span class="help-block"></span>

                                <div class="input-group" style="">
                                    <span class="input-group-addon">头等舱座位数量</span>
                                    <input name="fliFnumber" type="text" class="form-control myPsg needClear otherPsg" id="F1"readonly/>
                                    <span class="input-group-addon">头等舱座位价格</span>
                                    <div>
                                        <input id="Fnumber1" name="fliFfare" type="text" class="form-control myPsg needClear otherPsg"  />
                                    </div>
                                </div>
                                <span class="help-block"></span>

                            </div><!-- /.col-lg-6 -->
                        </div><!-- /.row -->
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button id="Save_updata" type="button" class="btn btn-primary" >更新</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
