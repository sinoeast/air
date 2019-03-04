$(function(){
    //定位到第一页
    to_flightpage(1);
});

function to_flightpage(pn){
    $.ajax({
        url:"selectFlightinformation",
        data:"pn="+pn,
        type:"POST",
        success:function (result) {
            console.log(result);
            //1.解析航空数据数据
            bulid_flightinformation_table(result);
            //2。解析分页数据
            bulid_flightinformation_info(result);
            //3。解析分页条
            bulid_flightinformation_nav(result);
        }
    })
}
function bulid_flightinformation_table(result){
    $("#flightinformation").empty();
    var flightinformation=result.extend.pageInfo.list;
    $.each(flightinformation,function (key,value) {

        if(value.booBerth=='Y'){
            value.booBerth='经济舱';
        }else if(value.booBerth=='C'){
            value.booBerth='公务舱';
        }else if(value.booBerth=='F'){
            value.booBerth='头等舱';
        }


        str='<tr> <td> <h4 style="text-align: center">'+value.fliBaddress+'-->飞往-->'+value.fliAaddress+'</h4>';
        str+='<h4 class="card-title" style="text-align: center">¥'+value.fliYfare+'</h4>';
        str+='<h4 class="card-title" style="text-align: center">起飞时间:'+value.fliBtime+'</h4>';
        str+='<div style="text-align: center"><button edit_fliAutoid="'+value.fliAutoid+'" type="button" class="btn btn-default" aria-label="Left Align" ><span class="glyphicon glyphicon glyphicon-pencil" aria-hidden="true" >点击购买</span></button></div>';

        $("#flightinformation").append(str);
    })
}

function bulid_flightinformation_info(result){
    $("#page_info2").empty();
    info=result.extend.pageInfo;
    str='当前第'+info.pageNum+'页,共'+info.pages+'页，'+info.total+'条数据';
    $("#page_info2").append(str);
    totalRecord2=info.total;//用于跳转到最后一ye
    currentPage2=info.pageNum;//用于记录当前页
}


function bulid_flightinformation_nav(result){

    $("#page_nav2").empty();

    var info=result.extend.pageInfo;

    beforepage=$("<li></li>").append($("<a></a>").append("&laquo;"));
    firstpage=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
    nextpage=$("<li></li>").append($("<a></a>").append("&raquo;"));
    lastpage=$("<li></li>").append($("<a></a>").append("尾页").attr("href","#"));

    firstpage.click(function(){
        to_flightpage(1);
    });
    beforepage.click(function(){
        to_flightpage(info.pageNum-1);
    });

    $("#page_nav2").append(firstpage,beforepage);
    //each遍历k，v
    $.each(info.navigatepageNums,function (key,value){
        newPage=$("<li></li>").append($("<a></a>").append(value));
        if(info.pageNum==value){
            newPage.addClass("active");
        }
        newPage.click(function () {
            to_flightpage(value);
        });
        $("#page_nav2").append(newPage);
    });

    nextpage.click(function(){
        to_flightpage(info.pageNum+1);
    });
    lastpage.click(function(){
        to_flightpage(info.pages);
    });
    $("#page_nav2").append(nextpage,lastpage);

}