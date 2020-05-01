toastr.options.positionClass = 'toast-top-center';
var sendData = {};
$(function () {
    $(".subhead").text("工资项目管理");
    //创建工资项目
    $(".confirmCreateProBtn").click(function () {
        if (verifyCreate()) {
            createPro();
        }
    });
    //点击编辑按钮,往模态框中填充数据
    $(".updateProBtn").click(function () {
        //注意：表单元素的存取使用val()函数
        var salaryProId = $(this).parent().parent().find("td:eq(0)").text();
        var salaryProName = $(this).parent().parent().find("td:eq(1)").text();
        var salaryProType = $(this).parent().parent().find("td:eq(2)").text();
        var isDisplayed = $(this).parent().parent().find("td:eq(3)").text();
        var displayOrder = $(this).parent().parent().find("td:eq(4)").text();
        var incOrDec = $(this).parent().parent().find("td:eq(5)").text();
        $("#updateProId").val(salaryProId);
        $("#updateProName").val(salaryProName);
        $("#updateProType").val(salaryProType);
        $("#updateDisplay").val(isDisplayed);
        $("#updateDisplayOrder").val(displayOrder);
        $("#updateIncOrDec").val(incOrDec);
    });
    //确定更新工资项目
    $(".confirmUpdateProBtn").click(function () {
        if (verifyUpdate()) {
            updatePro();
        }
    });
    //删除工资项目
    $(".deleteProBtn").click(function () {
        var salaryProName = $(this).parent().parent().find("td:eq(1)").text();
        deletePro(salaryProName);
    });

    $(".sec").click(function () {
        searchPro();
    })

});

//根据名称、类型搜索
function searchPro(){
    var data = $(".secbox").val();
    if (data == "") {//判断搜索框是否为空，是则弹窗"请输入一点东西"
        toastr.error("搜索不能为空");
    } else {//否则搜索内容为搜索框（.secbox）里的内容（val）的项将他的背景颜色改成淡蓝色

        $(".table tr:not(:first):contains(" + data + ")").css("background", "#D9EDF7")
        $(this).blur(function () {//离开搜索框是变成默认颜色
            $(".secbox").val("");
            $(".table tr").css("background", "#fff")
        });
        window.location.href = "/payroll_management_system_war_exploded/salary/salaryPro/search/" + data;
    }
}
//创建项目
function createPro() {
    bootbox.confirm({
        size: "small",
        message: "你确定要删除该工资项目吗?",
        buttons: {
            confirm: {
                label: 'Yes',
                className: 'btn-success'
            },
            cancel: {
                label: 'No',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/payroll_management_system_war_exploded/salary/salaryPro/doCreateSalaryPro",
                    type: "POST",
                    contentType: 'application/json;charset=utf-8',
                    data: JSON.stringify(sendData),
                    success: function (result) {
                        if(result.message.toString() === "200"){
                            location.reload();
                            toastr.success("工资项目创建成功");
                            //隐藏模态框
                            $("#createProModal").modal("hide");
                        }else {
                            toastr.error(result.message);
                        }
                    },
                    error: function () {
                        toastr.error("工资项目创建失败");
                    }
                });
            }
        }
    })

}

function verifyCreate() {
    var salaryProName = $("#createProName").val();
    var salaryProType = $("#createProType").val();
    var isDisplayed = $("#createDisplay").val();
    var displayOrder = parseInt($("#createDisplayOrder").val());
    var incOrDec = $("#createIncOrDec").val();
    if(salaryProName == 0 || salaryProType == 0 || isDisplayed == 0 || displayOrder == 0 || incOrDec == 0){
        toastr.error("表单不能有空");
        return false;
    }else{
        sendData = {
            salaryProName: salaryProName,
            salaryProType: salaryProType,
            isDisplayed: isDisplayed,
            displayOrder: displayOrder,
            incOrDec: incOrDec
        };
        return true;
    }

}

//更新项目
function updatePro() {
    bootbox.confirm({
        size: "small",
        message: "你确定要更新该工资项目吗?",
        buttons: {
            confirm: {
                label: 'Yes',
                className: 'btn-success'
            },
            cancel: {
                label: 'No',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/payroll_management_system_war_exploded/salary/salaryPro/doUpdateSalaryPro",
                    type: "POST",
                    contentType: 'application/json;charset=utf-8',
                    data: JSON.stringify(sendData),
                    success: function (result) {
                        if(result.message.toString() === "200"){
                            location.reload();
                            toastr.success("修改工资项目成功");
                            //隐藏模态框
                            $("#updateProModal").modal("hide");
                        }else{
                            toastr.error(result.message);
                        }
                    },
                    error: function (res) {
                        toastr.error("修改工资项目失败" + res.message);
                    }
                });
            }
        }
    })

}

function verifyUpdate() {
    var salaryProId = $("#updateProId").val();
    var salaryProName = $("#updateProName").val();
    var salaryProType = $("#updateProType").val();
    var isDisplayed = $("#updateDisplay").val();
    var displayOrder = $("#updateDisplayOrder").val();
    var incOrDec = $("#updateIncOrDec").val();
    sendData = {
        salaryProId: parseInt(salaryProId),
        salaryProName: salaryProName,
        salaryProType: salaryProType,
        isDisplayed: isDisplayed,
        displayOrder: parseInt(displayOrder),
        incOrDec: incOrDec
    };
    return true;
}

//删除项目
function deletePro(salaryProName) {
    bootbox.confirm({
        size: "small",
        message: "你确定要删除该工资项目吗?",
        buttons: {
            confirm: {
                label: 'Yes',
                className: 'btn-success'
            },
            cancel: {
                label: 'No',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/payroll_management_system_war_exploded/salary/salaryPro/doDeleteSalaryPro/" + salaryProName,
                    type: "GET",
                    data: {"salaryProName": salaryProName},
                    success: function (result) {
                        location.reload();
                        toastr.success("删除工资项目" + result.message);

                    },
                    error: function () {
                        toastr.error("删除工资项目出现错误！！！");
                    }
                })
            }
        }
    })
}
