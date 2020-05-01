toastr.options.positionClass = 'toast-top-center';
$(function () {

    $(".subhead").text("工资结算");
    var date = getQueryVariable("date");
    var depName = decodeURIComponent(getQueryVariable("depName"));
    displayTitle(date, depName);
    $('#month').datetimepicker({
        format: 'YYYY-MM'
    });

    $(".calculate").click(function () {
        var depName = $("#department").val();
        var date = $("#month").val();
        if (depName == 0) {
            toastr.error("部门不能为空");
        } else if (date == 0) {
            toastr.error("时间不能为空");
        } else {
            window.location.href = "/payroll_management_system_war_exploded/salary/calculate?depName=" + depName + "&date=" + date;
        }
    });
    //暂存
    $(".save").click(function () {
    if(depName ==0 || date == 0){
       toastr.error("请先计算工资");
    }else{
        $.ajax({
            url: "/payroll_management_system_war_exploded/salary/saveSalary?depName=" + depName + "&date=" + date,
            type: "GET",
            success: function (result) {
                if (result.message == 1) {
                    toastr.error("已经发放，不能暂存!");
                } else {
                    toastr.success("暂存成功");
                }
            },
            error: function () {
                toastr.error("暂存失败");
            }
        });
         }
    });
    //发放
    $(".give").click(function () {
        $.ajax({
            url: "/payroll_management_system_war_exploded/salary/paySalary?depName=" + depName + "&date=" + date,
            type: "GET",
            success: function (result) {
                if (result.message == 1) {
                    toastr.error("不能重复发放工资");
                } else {
                    toastr.success("发放工资成功");
                }

            },
            error: function () {
                toastr.error("发放工资失败");
            }
        });
        //window.location.href = "/payroll_management_system_war_exploded/salary/calculate/calculateManagement";
    })

});

function displayTitle(date, depName) {

    if (depName != false && date != false) {
        $(".salaryTitle").text(depName + " " + date + "工资信息");
    }
}

//获取URL参数
function getQueryVariable(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
    return (false);
}