$(function () {
    $(".subhead").text("岗位管理");
    toastr.options.positionClass = 'toast-top-center';
    //搜索岗位下员工
    $(".secPosEmp").click(function () {
        var searchInfo = $(".secPosBox").val();
        if (searchInfo == 0) {
            toastr.error("搜索不能为空");
        } else {
            window.location.href = "/payroll_management_system_war_exploded/basicInfo/position/search?wd=" + searchInfo;
        }
    });
    //编辑按钮被点击，将该表中的信息填充到模态框中
    $(".editPosBtn").click(function () {
        var positionId = $(this).parent().parent().find("td:eq(0)").text();
        var positionName = $(this).parent().parent().find("td:eq(1)").text();
        var positionType = $(this).parent().parent().find("td:eq(2)").text();
        var employeeNum = $(this).parent().parent().find("td:eq(3)").text();
        $("#inputUpdatedPosId").val(positionId);
        $("#inputUpdatedPosName").val(positionName);
        $("#inputUpdatedPosType").val(positionType);
        $("#inputUpdatedEmpNum").val(employeeNum);
    });
//增加
    $(".confirmCreatePosBtn").click(function () {//点开增加按钮弹出的模态框后的确定按钮事件
        var arr = [];
        var name = $("#inputCreatedPosName").val();//找到input框的内容并存放在命名为Pname的变量中
        var type = $("#inputCreatedPosType").val();//找到input框的内容并存放在命名为Ptype的变量中
        var pnum = $("#inputCreatedEmpNum").val();

        $(this).parent().siblings().find("input").each(function () {//将3个input的内容用each方法遍历并用push方法逐个存放到叫arr的数组中
            arr.push($(this).val());
            $(this).val("");
        })
        if (name == 0 || type == 0 || pnum == 0) {//判断内容是否为空，否则弹窗
            toastr.error("表单不能为空!");
        } else if (isNaN(pnum) || (!(/^(\+|-)?\d+$/.test(pnum)) || pnum < 0)) {
            toastr.error("请填写正确的编制格式(正整数)!");
        } else if (!isNaN(name)) {
            toastr.error("请填写正确的岗位名称!");
        } else if (!isNaN(type)) {
            toastr.error("请填写正确的岗位类型!");
        } else {//是则加入到table中（表格）并把模态框关闭;
            var data = {
                "positionName": name,
                "positionType": type,
                "employeeNum": parseInt(pnum)
            };
            $.ajax({
                url: "position/doCreatePosition",
                type: "POST",
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify(data),
                success: function (result) {
                    toastr.success("部门创建" + result.message);
                    //隐藏模态框
                    $("#createPosModal").modal("hide");
                },
                error: function () {
                    toastr.error("部门创建失败");
                }
            });
        }
    });
//删除
    $(".deletePosBtn").click(function () {
        var positionId = $(this).parent().parent().find("td:eq(0)").text();
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
                        url: "position/doDeletePosition/" + positionId,
                        type: "GET",
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
//确定修改
    $(".doUpdatePosBtn").click(function () {//同增加事件
        var id = parseInt($("#inputUpdatedPosId").val());
        var name = $("#inputUpdatedPosName").val();
        var type = $("#inputUpdatedPosType").val();
        var pnum = parseInt($("#inputUpdatedEmpNum").val());
        bootbox.confirm({
            size: "small",
            message: "你确定要修改该部门吗?",
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
                    var data = {
                        "positionId": id,
                        "positionName": name,
                        "positionType": type,
                        "employeeNum": pnum
                    };
                    $.ajax({
                        url: "position/doUpdatePosition",
                        type: "POST",
                        contentType: 'application/json;charset=utf-8',
                        data: JSON.stringify(data),
                        success: function (result) {
                            toastr.success("修改部门" + result.message);
                            $("#updatePosModal").modal("hide");
                        },
                        error: function () {
                            toastr.error("修改部门出现错误！！！");
                        }
                    })
                }
            }
        })
    });
//搜索
    $(".sec").click(function () {//搜索岗位基本信息的点击事件
        var data = $(".secbox").val()
        if (data == 0) {//判断搜索框是否为空，是则弹窗"请输入一点东西"
            alert("搜索不能为空")
        } else {//否则搜索内容为搜索框（.secbox）里的内容（val）的项将他的背景颜色改成淡蓝色
            $(".table tr:not(:first):contains(" + data + ")").css("background", "#D9EDF7")
            $(this).blur(function () {//离开搜索框是变成默认颜色
                $(".secbox").val("")
                $(".table tr").css("background", "#fff")
            })
        }
    });


    $(".secEmply").click(function () {//搜索岗下员工的点击事件
        var data = $(".secbox").val()
        if (data == 0) {//判断搜索框是否为空，是则弹窗"请输入一点东西"
            alert("搜索不能为空")
        } else {//否则搜索内容为搜索框（.secbox）里的内容（val）的项将他的背景颜色改成淡蓝色

            //在这添加查询数据库

        }
    });
});

