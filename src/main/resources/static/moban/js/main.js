$(function(){
    //上传显示图片
    function   show(){
        var p=document.getElementById("file1").value;
        document.getElementById("s").innerHTML="<input type=image id=pic width=150 height=100 /> ";
        document.getElementById("pic").src=p;
        //alert(p);
    }
    //教材区
    $(".one li").hover(function(){
        $(this).find(".two").show();
    },function(){
        $(this).find(".two").hide();
    });
    //工具书区
    $(".tab li").click(function(){
        $(this).find("a").addClass("on");
        $(this).siblings().find("a").removeClass("on");
        var index = $(this).index();
        $("#item2 .tabs").hide();
        $(".tab"+index).show()
    });

    //右侧导航
    $(".fixnav a").click(function(){
        var index = $(this).attr("title");
        var id = "#item"+index;
        $("html,body").animate({scrollTop: $(id).offset().top}, 500);
    });
    //图书编辑上传
    $(".product-edit-item").hover(function(){
        $(this).find("p").css("color","#333");
    },function(){
        $(this).find("p").css("color","#BBB")
    });
    //选择购买书籍
    $(".pay").click(function(){
        $(".full").show();
    });
    $(".confirm a").click(function () {
        $(".full").hide();
    });
    // item selection
    $('.select-book li').click(function () {
        $(this).toggleClass('selected');
        if ($('.select-book li.selected').length == 0)
            $('.select-book .select').removeClass('selected');
        else
            $('.select-book .select').addClass('selected');
        counter();
    });

// all item selection
    $('.select-book .select').click(function () {
        if ($('.select-book li.selected').length == 0) {
            $('.select-book li').addClass('selected');
            $('.select-book .select').addClass('selected');
        }
        else {
            $('.select-book li').removeClass('selected');
            $('.select-book .select').removeClass('selected');
        }
        counter();
    });

// number of selected items
    function counter() {
        if ($('.select-book li.selected').length > 0)
            $('.select-book .send').addClass('selected');
        else
            $('.select-book .send').removeClass('selected');
        $('.select-book .send').attr('data-counter',$('li.selected').length);
    }

    //条件筛选
    $("#select1 dd").click(function () {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $("#selectA").remove();
        } else {
            var copyThisA = $(this).clone();
            if ($("#selectA").length > 0) {
                $("#selectA a").html($(this).text());
            } else {
                $(".select-result dl").append(copyThisA.attr("id", "selectA"));
            }
        }
    });

    $("#select2 dd").click(function () {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $("#selectB").remove();
        } else {
            var copyThisB = $(this).clone();
            if ($("#selectB").length > 0) {
                $("#selectB a").html($(this).text());
            } else {
                $(".select-result dl").append(copyThisB.attr("id", "selectB"));
            }
        }
    });

    $("#select3 dd").click(function () {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $("#selectC").remove();
        } else {
            var copyThisC = $(this).clone();
            if ($("#selectC").length > 0) {
                $("#selectC a").html($(this).text());
            } else {
                $(".select-result dl").append(copyThisC.attr("id", "selectC"));
            }
        }
    });

    $("#select4 dd").click(function () {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $("#selectD").remove();
        } else {
            var copyThisC = $(this).clone();
            if ($("#selectD").length > 0) {
                $("#selectD a").html($(this).text());
            } else {
                $(".select-result dl").append(copyThisC.attr("id", "selectD"));
            }
        }
    });

    $("#selectA").live("click", function () {
        $(this).remove();
        $("#select1 .select-all").addClass("selected").siblings().removeClass("selected");
    });

    $("#selectB").live("click", function () {
        $(this).remove();
        $("#select2 .select-all").addClass("selected").siblings().removeClass("selected");
    });

    $("#selectC").live("click", function () {
        $(this).remove();
        $("#select3 .select-all").addClass("selected").siblings().removeClass("selected");
    });
    $("#selectD").live("click", function () {
        $(this).remove();
        $("#select4 .select-all").addClass("selected").siblings().removeClass("selected");
    });

    $(".select dd").live("click", function () {
        if ($(".select-result dd").length > 1) {
            $(".select-no").hide();
        } else {
            $(".select-no").show();
        }
    });

});