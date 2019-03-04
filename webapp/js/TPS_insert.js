var totalRecord2//用于跳转到最后一页
function getNow(s) {
    return s < 10 ? '0' + s: s;
}
$(function(){
    //新增按钮事件
    $("#Insert2").click(function(){
        //获取事件作为flino
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
        // $('#btime').datetimepicker({
        //     language:  'zh-CN',
        //     weekStart: 0, //一周从哪一天开始
        //     todayBtn:  1, //
        //     autoclose: 1,
        //     todayHighlight: 1,
        //     startView: 2,
        //     forceParse: 0,
        //     showMeridian: 1,
        //     format: $("#btime").val(),
        //     startDate:now
        // });

        //清除表单数据，取出dom对象，使用reset方法
        $("#flightModal form")[0].reset();
        //清除提示信息
        $("#flightModal form").find("*").removeClass("has-error has-success");
        $("#flightModal form").find(".help-block").text("");


        ////////////////////////////////// 后端校验地区名
        $("#aaddress").change(function(){
            baddress=$("#aaddress").val();
            $.ajax({
                url:"selectareaName",
                type:"POST",
                data:"baadress="+baddress,
                success:function(result){
                    console.log(result);
                    if(result.code==100){
                        check_information_bot("#aaddress","success","");
                        $("#aaddress").attr("ajax","success");
                    }else {
                        check_information_bot("#aaddress","error",result.extend.va_msg);
                        $("#aaddress").attr("ajax","fail");
                    }
                }
            })
        });
        $("#baddress").change(function(){
            baddress=$("#baddress").val();
            $.ajax({
                url:"selectareaName",
                type:"POST",
                data:"baadress="+baddress,
                success:function(result){
                    console.log(result);
                    if(result.code==100){
                        check_information_bot("#baddress","success","");
                        $("#baddress").attr("ajax","success");
                    }else {
                        check_information_bot("#baddress","error",result.extend.va_msg);
                        $("#baddress").attr("ajax","fail");
                    }
                }
            })
        });
        ////////////////////////////////////////////////前端校验
        $("#discount").change(function () {
            text=$("#discount").val();
            reg=/^(0(\.\d+)?|1)$/;
            // 正则表达式测试，是否符合规范
            if(!reg.test(text)){
                check_information_bot("#discount","error","只能0-1之间的整数或小数");
                return false;
            }else {
                check_information_bot("#discount","success","");
            }
        });
        $("#everyday").change(function () {
            text=$("#everyday").val();
            reg=/^周[一二三四五六日]$/;
            // 正则表达式测试，是否符合规范
            if(!reg.test(text)){
                check_information_bot("#everyday","error","请输入周一周二。。。周六周日");
                return false;
            }else {
                check_information_bot("#everyday","success","");
            }
        });
        $("#Ynumber").change(function () {
            check_information_flinumber("#Ynumber");
        });
        $("#Cnumber").change(function () {
            check_information_flinumber("#Cnumber");
        });
        $("#Fnumber").change(function () {
            check_information_flinumber("#Fnumber");
        });


        query_flicomInfo("#Selectcheck1");
        query_airInfo("#Selectcheck");
        //模态框点击空白不关闭
        $("#flightModal").modal({
            backdrop:"static"
        });
    });

});


//查找airtype信息放入combobox
function query_airInfo(ele){
    $(ele).empty();
    $.ajax({
        url:"air_info",
        type:"POST",
        success:function(result){
            //console.log(result);
            $.each(result.extend.airInfo,function (index,item) {
                str=$("<option></option>").append(item.airName).attr('value',item.airCode);
                $(ele).append(str);
                $("#Y").val(result.extend.airInfo[0].airYnumber);
                $("#C").val(result.extend.airInfo[0].airCnumber);
                $("#F").val(result.extend.airInfo[0].airFnumber);
                if(result.extend.airInfo[0].airCnumber==0){
                    $("#Cnumber").attr("disabled","disabled");
                    $("#Cnumber").val(0);
                }else{
                    $("#Cnumber").removeAttr("disabled");
                    $("#Cnumber").val("");
                }
                if(result.extend.airInfo[0].airFnumber==0){
                    $("#Fnumber").attr("disabled","disabled");
                    $("#Fnumber").val(0);
                }else{
                    $("#Fnumber").removeAttr("disabled");
                    $("#Fnumber").val("");
                }
            });
            $("select#Selectcheck").change(function(){

                for(i=0;i<result.extend.airInfo.length;i++){
                    //console.log($(this).val());
                    //console.log(result.extend.airInfo[i].airCode);
                    if($(this).val()==result.extend.airInfo[i].airCode){
                        $("#Y").val(result.extend.airInfo[i].airYnumber);
                        $("#C").val(result.extend.airInfo[i].airCnumber);
                        $("#F").val(result.extend.airInfo[i].airFnumber);
                        if(result.extend.airInfo[i].airCnumber==0){
                            $("#Cnumber").attr("disabled","disabled");
                            $("#Cnumber").val(0);
                        }else{
                            $("#Cnumber").removeAttr("disabled");
                            $("#Cnumber").val("");
                        }
                        if(result.extend.airInfo[i].airFnumber==0){
                            $("#Fnumber").attr("disabled","disabled");
                            $("#Fnumber").val(0);
                        }else{
                            $("#Fnumber").removeAttr("disabled");
                            $("#Fnumber").val("");
                        }
                    }
                }
             });
        }
    })
}
//查找flicom信息放入combobox
function query_flicomInfo(ele){
    //alert(1);
    $(ele).empty();
    $.ajax({
        url:"flicom_info",
        type:"POST",
        success:function(result){
            console.log(result);
            $.each(result.extend.flicom,function (index,item) {
                str=$("<option></option>").append(item.comName).attr('value',item.comCode);
                $("#fliNo").val(result.extend.flicom[0].comCode+fliNo1);
                $(ele).append(str);
            });
            $("#Selectcheck1").change(function(){
                //console.log($(this).val());
                for(i=0;i<result.extend.flicom.length;i++){
                    console.log($(this).val());
                    console.log(result.extend.flicom[i].comCode);
                    if($(this).val()==result.extend.flicom[i].comCode){
                        $("#fliNo").val(result.extend.flicom[i].comCode+fliNo1);
                    }
                }
            });
        }
    })
}
////////////////////////////////// 前端校验
//input信息校验
function check_information_flinumber(ele) {
    text=$(ele).val();
    reg=/^[0-9]+([.][0-9]+){0,1}$/;
    // 正则表达式测试，是否符合规范
    if(!reg.test(text)){
        check_information_bot(ele,"error","请输入整数或小数");
        flag=1;
    }else {
        check_information_bot(ele,"success","");
    }
}

function check_information(){
    //提取文本框信息
    flag=0;
    text=$("#discount").val();
    reg=/^(0(\.\d+)?|1)$/;
    // 正则表达式测试，是否符合规范
    if(!reg.test(text)){
        check_information_bot("#discount","error","只能0-1之间的整数或小数");
        flag=1;
    }else {
        check_information_bot("#discount","success","");
    }

    text=$("#everyday").val();
    reg=/^周[一二三四五六日]$/;
    // 正则表达式测试，是否符合规范
    if(!reg.test(text)){
        check_information_bot("#everyday","error","请输入周一周二。。。周六周日");
        flag=1;
    }else {
        check_information_bot("#everyday","success","");
    }
    check_information_flinumber("#Ynumber");
    check_information_flinumber("#Cnumber");
    check_information_flinumber("#Fnumber");
    if($("#atime").val()==""){
        check_information_bot("#atime","error","请输入时间");
        flag=1;
    }else {
        check_information_bot("#atime","success","");
    }
    if($("#btime").val()==""){
        check_information_bot("#btime","error","请输入时间");
        flag=1;
    }else {
        check_information_bot("#btime","success","");
    }



    text=$("#baddress").val();
    reg=/^[\u4e00-\u9fa5]{0,}$/;
    if(text==""){
        check_information_bot("#baddress","error","请输入地址");
        flag=1;
    }else {
        if(!reg.test(text)){
            check_information_bot("#baddress","error","请输入汉字");
            flag=1;
        }else {
            check_information_bot("#baddress","success","");
            text1=$("#aaddress").val();
            if(text1==""){
                check_information_bot("#aaddress","error","请输入地址");
                flag=1;
            }else {
                if(!reg.test(text1)){
                    check_information_bot("#aaddress","error","请输入汉字");
                    flag=1;
                }else {
                    check_information_bot("#aaddress","success","");
                    if($("#baddress").attr("ajax")=="fail"){
                        check_information_bot("#baddress","error","请输入正确地点");
                    }else{
                        check_information_bot("#baddress","success","");
                    }
                    if($("#aaddress").attr("ajax")=="fail"){
                        check_information_bot("#aaddress","error","请输入正确地点");
                    }else{
                        check_information_bot("#aaddress","success","");
                    }
                }
            }
        }
    }
    if($("#aaddress").val()==$("#baddress").val()){
        //alert($("#aaddress").val());
        //alert($("#baddress").val());
        check_information_bot("#aaddress","error","请不要输入相同地点");
        check_information_bot("#baddress","error","请不要输入相同地点");
        flag=1;
    }

    //alert("flag"+flag);
    return flag;
}


//提交航空信息
function submitFliinfor(){
    //1。先对input数据进行前端校验,返回true才进行ajax
    if(check_information()=="1"){
        //alert(check_information());
        return false;
    };
    //alert("hello");
    //后段校验成功才往下走
    if($("#baddress").attr("ajax")=="fail"){
        return false;
    };
    if($("#aaddress").attr("ajax")=="fail"){
        return false;
    };
    //alert("hello");
    // alert($("#flightModal form").serialize());//k=v;employee数据
    console.log($("#flightModal form").serialize());
    //校验完成后保存进数据库
    $.ajax({
        url:"insertFliinfo",
        data:$("#flightModal form").serialize(),
        type:"POST",
        success:function(result){
            console.log(result);
            if(result.code==100){
                ////////////////保存成功
                alert(result.msg);
                //关闭模态框
                $("#flightModal").modal('hide');
                //跳到最后一页
                to_flightpage(totalRecord2);
            }else {
                alert(result.msg);
            }

        }
    })
}


//校验出错时提醒,提示条和框颜色
function check_information_bot(element,infomation,msg){
    $(element).parent().removeClass(" has-error has-success");
    $(element).parent().parent().next("span").text("");
    if("error"==infomation){
        $(element).parent().addClass("has-error");
        $(element).parent().parent().next("span").text(msg);
    }else if("success"==infomation){
        $(element).parent().addClass("has-success");
        $(element).parent().parent().next("span").text(msg);
    }
}

