$(function(){
    //定位到第一页
    to_bookpage(1);
    to_flightpage(1);
});


//bookinformation
function to_bookpage(pn){
    $.ajax({
        url:"selectBookinformation",
        data:"pn="+pn,
        type:"POST",
        success:function (result) {
            console.log(result);
            //1.解析订单数据
            bulid_bookinformation_table(result);
            //2。解析分页数据
            bulid_bookinformation_info(result);
            //3。解析分页条
            bulid_bookinformation_nav(result);
        }
    })
}

function bulid_bookinformation_table(result) {
    $("#bookinformation").empty();
    var bookinformation=result.extend.pageInfo.list;
    $.each(bookinformation,function (key,value) {

        if(value.booBerth=='Y'){
            value.booBerth='经济舱';
        }else if(value.booBerth=='C'){
            value.booBerth='公务舱';
        }else if(value.booBerth=='F'){
            value.booBerth='头等舱';
        }


        str='<tr ><td><input type="checkbox" class="check_item"/></td>';
        str+='<td>'+value.booAutoid+'</td>';
        str+='<td>'+value.customer.cusAccount+'</td>' ;
        str+='<td>'+value.booBaddress+'</td>';
        str+='<td>'+value.booAaddress+'</td>';
        str+='<td>'+value.booBtime+'</td>';
        str+='<td>'+value.booAtime+'</td>';
        str+='<td>'+value.booBerth+'</td>';
        str+='<td>'+value.booNumber+'</td>';
        str+='<td class="col-md-4 "><button edit_booAutoid="'+value.booAutoid+'" class="btn btn-primary btn-xs edit_btn"><span class="glyphicon glyphicon-pencil"  aria-hidden="true"></span>编辑</button>'+' ';
        str+='<button class="btn btn-danger btn-xs delete_btn"edit_booAutoid="'+value.booAutoid+'"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除</button></td>\n</tr>';
        $("#bookinformation").append(str);
    })
}
function bulid_bookinformation_info(result){
    $("#page_info").empty();
    info=result.extend.pageInfo;
    str='当前第'+info.pageNum+'页,共'+info.pages+'页，'+info.total+'条数据';
    $("#page_info").append(str);
    totalRecord=info.total;//用于跳转到最后一ye
    currentPage=info.pageNum;//用于记录当前页
}


function bulid_bookinformation_nav(result){

    $("#page_nav").empty();

    var info=result.extend.pageInfo;

    beforepage=$("<li></li>").append($("<a></a>").append("&laquo;"));
    firstpage=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
    nextpage=$("<li></li>").append($("<a></a>").append("&raquo;"));
    lastpage=$("<li></li>").append($("<a></a>").append("尾页").attr("href","#"));

    firstpage.click(function(){
        to_bookpage(1);
    });
    beforepage.click(function(){
        to_bookpage(info.pageNum-1);
    });

    $("#page_nav").append(firstpage,beforepage);
    //each遍历k，v
    $.each(info.navigatepageNums,function (key,value){
        newPage=$("<li></li>").append($("<a></a>").append(value));
        if(info.pageNum==value){
            newPage.addClass("active");
        }
        newPage.click(function () {
            to_bookpage(value);
        });
        $("#page_nav").append(newPage);
    });

    nextpage.click(function(){
        to_bookpage(info.pageNum+1);
    });
    lastpage.click(function(){
        to_bookpage(info.pages);
    });
    $("#page_nav").append(nextpage,lastpage);

}

// flightinformation

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


        str='<tr ><td><input type="checkbox" class="checkItem"/></td>';
        str+='<td>'+value.fliNo+'</td>';
        str+='<td>'+value.comCode+'</td>' ;
        str+='<td>'+value.fliBaddress+'</td>';
        str+='<td>'+value.fliAaddress+'</td>';
        str+='<td>'+value.fliBtime+'</td>';
        str+='<td>'+value.fliAtime+'</td>';
        str+='<td>'+value.airCode+'</td>';
        str+='<td>'+value.fliDiscount+'</td>';
        str+='<td class="col-md-4 "><button edit_fliAutoid="'+value.fliAutoid+'" class="btn btn-primary btn-xs edit_btn"><span class="glyphicon glyphicon-pencil"  aria-hidden="true"></span>编辑</button>'+' ';
        str+='<button class="btn btn-danger btn-xs delete_btn" delete_fliAutoid="'+value.fliAutoid+'"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除</button></td>\n</tr>';
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


