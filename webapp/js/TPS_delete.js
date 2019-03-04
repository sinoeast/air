var currentPage2;//记录当前页
$(function(){
    //单一删除按钮
    $(document).on("click",".delete_btn",function() {
        Flino=$(this).parents("tr").find("td:eq(1)").text();
        if(confirm("确认删除航班["+Flino+"]吗？")){
            $.ajax({
                url:"deleteone/"+Flino,
                type:"DELETE",
                success:function (result) {
                    console.log(result);
                    if(result.code==100){
                        alert("成功删除");
                    }else{
                        alert(result.extend.va_mas);
                    }
                    to_flightpage(currentPage2);
                }
            })
        }
    });
    //全删除按钮
    $("#deleteall2").click(function(){
        var Flino="";
        $.each($(".checkItem:checked"),function () {
            Flino+=$(this).parents("tr").find("td:eq(1)").text()+',';
        });
        Flino=Flino.substring(0,Flino.length-1);
        if(confirm("确认删除航班["+Flino+"]吗？")){
            // $.ajax({
            //     url:"deleteSelect/"+Flino,
            //     type:"DELETE",
            //     success:function (result) {
            //         console.log(result);
            //         if(result.code==1){
            //             alert("成功删除");
            //         }else{
            //             alert(result.extend.va_mas);
            //         }
            //         to_flightpage(currentPage2);
            //     }
            // })
        }
    });


    //全选按钮
    $("#checkAll").click(function(){
        //attr获取自定义元素的值，prop获取dom原生的值
        //alert(1);
        $(".checkItem").prop("checked",$(this).prop("checked"));
    });
    //子按钮全选中，全选按钮也选中，因为是子按钮是动态数据产生的，也使用document，on方法
    $(document).on("click",".checkItem",function () {
        //选中的等于总的子按钮数
        var flag=$(".checkItem:checked").length==$(".checkItem").length
        $("#checkAll").prop("checked",flag);
    });
});