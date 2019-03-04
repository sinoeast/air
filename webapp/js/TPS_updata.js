var currentPage2;//记录当前页
$(function(){
    //按钮是查询数据后生成的需要用jquery的on方法，带edit_btn元素的生成click方法
    $(document).on("click",".edit_btn",function(){
        var myDate = new Date();
        var year=myDate.getFullYear();        //获取当前年
        var month=myDate.getMonth()+1;   //获取当前月
        var date=myDate.getDate();            //获取当前日
        var h=myDate.getHours();              //获取当前小时数(0-23)
        var m=myDate.getMinutes();          //获取当前分钟数(0-59)
        var now=year+'-'+getNow(month)+"-"+getNow(date)+" "+getNow(h)+':'+getNow(m);
        fliNo1=year+""+month+""+date+""+h+""+m+""+myDate.getMilliseconds();
        //时间控件
        $(".form_datetime").datetimepicker({
            language:  'zh-CN',
            weekStart: 0, //一周从哪一天开始
            todayBtn:  1, //
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1,
            format: 'yyyy-mm-dd hh:ii',
            startDate:now
        });
        //alert(1);
        //1.查询航班信息，并显示
        selectInfo($(this).attr("edit_fliAutoid"));
        //alert($(this).attr("edit_fliAutoid"));
        //将empId属性给到更新按钮
        $("#Save_updata").attr("edit_fliAutoid",$(this).attr("edit_fliAutoid"));
        //2。查询combo信息并显示
        query_flicomInfo("#Selectcheck2");
        query_airInfo("#Selectcheck3");
        $("#flightModal_updata").modal({
            backdrop:"static"
        });
    })
    //点击更新按钮
    $("#Save_updata").click(function(){
        //alert(1);
        //折扣前端校验
        text=$("#discount1").val();
        reg=/^(0(\.\d+)?|1)$/;
        // 正则表达式测试，是否符合规范
        if(!reg.test(text)){
            check_information_bot("#discount1","error","只能0-1之间的整数或小数");
            flag=1;
        }else {
            check_information_bot("#discount1","success","");
        }
        //alert($("#flightModal_updata form").serialize());
        //ajax更新
        $.ajax({
            url:"updataFliInfo/"+$(this).attr("edit_fliAutoid"),
            data:$("#flightModal_updata form").serialize(),
            type:"POST",
            success:function(result){
                //1。关闭对话框
                $("#flightModal_updata").modal("hide");
                //2.回到修改页
                to_flightpage(currentPage2);
                alert("更新成功")
            }
        })

    })
});
function selectInfo(id) {
    $.ajax({
        url:"selectfliinfoById",
        data:"fliAutoid="+id,
        type:"POST",
        success:function (result) {
            console.log(result);
            fliInfoData=result.extend.fliInfo_updata;
            $("#baddress1").val(fliInfoData.fliBaddress);
            $("#baddress1").attr("readOnly","true");
            $("#aaddress1").val(fliInfoData.fliAaddress);
            $("#aaddress1").attr("readOnly","true");
            $("#btime1").val(fliInfoData.fliBtime);
            $("#atime1").val(fliInfoData.fliAtime);
            $("#flightModal_updata select").val([fliInfoData.comCode]);
            //$("#Selectcheck2").attr("readOnly","true");
            //$("#Selectcheck2").attr("disabled","disabled");
            $("#flightModal_updata select").attr("disabled","disabled");

            $("#flightModal_updata select").val([fliInfoData.airCode]);
            //$("#Selectcheck3").attr("readOnly","true");
            $("#fliNo1").val(fliInfoData.fliNo);
            $("#fliNo1").attr("readOnly","true");
            $("#discount1").val(fliInfoData.fliDiscount);
            $("#everyday1").val(fliInfoData.fliEveryday);
            $("#everyday1").attr("readOnly","true");
            $("#Y1").val(fliInfoData.fliYnumber);
            $("#Ynumber1").val(fliInfoData.fliYfare);
            $("#Ynumber1").attr("readOnly","true");
            $("#C1").val(fliInfoData.fliCnumber);
            $("#Cnumber1").val(fliInfoData.fliCfare);
            $("#Cnumber1").attr("readOnly","true");
            $("#F1").val(fliInfoData.fliFnumber);
            $("#Fnumber1").val(fliInfoData.fliFfare);
            $("#Fnumber1").attr("readOnly","true");

        }
    })
}