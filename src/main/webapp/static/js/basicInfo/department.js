$(function () {
    $(".subhead").text("部门管理");
    toastr.options.positionClass = 'toast-top-center';
    $('#startDate').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
    //搜索部门下员工
    $(".secDepEmp").click(function () {
        var searchInfo = $(".secDepBox").val();
        if (searchInfo == 0) {
            toastr.error("搜索不能为空");
        } else {
            window.location.href = "/payroll_management_system_war_exploded/basicInfo/department/search?wd=" + searchInfo;

        }
    });
    //创建部门的提交按钮被点击
    $('.createDepBtn').click(function () {
        if (verifyCreate()) {
            $.ajax({
                url: "department/doCreateDepartment",
                type: "GET",
                contentType: 'charset=utf-8',
                data: $('.createDepForm').serialize(),
                success: function (result) {
                    toastr.success("部门创建" + result.message);
                    //隐藏模态框
                    $("#createDepModal").modal("hide");
                },
                error: function () {
                    toastr.error("部门创建失败");
                }
            });
        }
    });
    //编辑部门按钮点击
    $(".editDepBtn").click(function () {
        var departmentId = $(this).parent().parent().find("td:eq(0)").text();
        var departmentName = $(this).parent().parent().find("td:eq(1)").text();
        var departmentTel = $(this).parent().parent().find("td:eq(2)").text();
        var departmentType = $(this).parent().parent().find("td:eq(3)").text();
        $("#inputUpdatedDepId").val(departmentId);
        $("#inputUpdatedDepName").val(departmentName);
        $("#inputUpdatedDepTel").val(departmentTel);
        $("#inputUpdatedDepType").val(departmentType);
    });
    //更新部门的提交按钮被点击
    $('.updateDepBtn').click(function () {
        $.ajax({
            url: "department/doUpdateDepartment",
            type: "GET",
            contentType: 'charset=utf-8',
            data: $('.updateDepForm').serialize(),
            success: function (result) {
                toastr.success("修改部门" + result.message);
                $("#updateDepModal").modal('hide');
            },
            error: function () {
                toastr.error("修改部门失败");
            }
        })
    });
    $('.deleteDepBtn').click(function () {
        var departmentId = $(this).parent().parent().find("td:eq(0)").text();
        bootbox.confirm({
            size: "small",
            message: "你确定要删除该部门吗?",
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
                        url: "department/doDeleteDepartment/" + departmentId,
                        type: "GET",
                        data: {"departmentId": departmentId},
                        success: function (result) {
                            toastr.success("删除部门" + result.message);
                        },
                        error: function () {
                            toastr.error("删除部门出现错误！！！");
                        }
                    })
                }
            }
        })
    });
});

function verifyCreate() {
    var name = $("#departmentName").val();
    var tel = $("#departmentTelTel").val();
    var type = $("#departmentType").val();
    var date = $("#startDate");
    if (name == 0 || tel == 0 || type == 0 || date == 0) {
        toastr.error("输入不能存在空");
        return false;
    }
    return true;
}