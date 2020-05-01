var sendData = {};//发送数据
$(function () {
    //改变标题
    $(".subhead").text("员工管理");
    toastr.options.positionClass = 'toast-top-center';
    $("#inputCreatedDateOfParti,#inputCreatedDateOfEntry,#inputCreatedEmpBirth,#inputUpdatedDateOfParti,#inputUpdatedDateOfEntry,#inputUpdatedEmpBirth").datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
    //搜索
    $(".secEmp").click(function () {
        var searchInfo = $(".secEmpBox").val();
        if (searchInfo == 0) {
            toastr.error("搜索不能为空");
        } else {
            window.location.href = "/payroll_management_system_war_exploded/basicInfo/employee/search?wd=" + searchInfo;

        }
    });
    //编辑按钮被点击，将该表中的信息填充到模态框中
    $(".editEmpBtn").click(function () {
        var array = [];
        for (var i = 0; i < 11; i++) {
            array[i] = $(this).parent().parent().find("td:eq(" + i + ")").text();
        }
        $("#inputUpdatedEmpId").val(array[0]);
        $("#inputUpdatedEmpName").val(array[1]);
        $("#inputUpdatedEmpSex").val(array[2]);
        $("#inputUpdatedEmpBirth").val(array[3]);
        $("#inputUpdatedIdNum").val(array[4]);
        $("#inputUpdatedDepName").val(array[5]);
        $("#inputUpdatedPosName").val(array[6]);
        $("#inputUpdatedDateOfEntry").val(array[7]);
        $("#inputUpdatedDateOfParti").val(array[8]);
        $("#inputUpdatedForm").val(array[9]);
        $("#inputUpdatedSource").val(array[10]);
    });
//增加员工
    $(".createEmpBtn").click(function () {//点开增加按钮弹出的模态框后的确定按钮事件
        if (createEmpVerify()) {
            createEmp();
            $(".createEmpModal").modal("hide");
        }
    });
//删除
    $(document).on("click", ".deleteEmpBtn", function () {//找到点击的类目为del的按钮实现删除
        var employeeId = $(this).parent().parent().find("td:eq(0)").text();
        bootbox.confirm({
            size: "small",
            message: "你确定要删除该员工吗?",
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
                        url: "employee/doDeleteEmployee/" + employeeId,
                        type: "GET",
                        data: {"employeeId": employeeId},
                        success: function (result) {
                            //$(this).parent().parent("tr").remove();
                            toastr.success("删除员工" + result.message);
                        },
                        error: function () {
                            toastr.error("删除员工出现错误！！！");
                        }
                    })
                }
            }
        })

    });
//确定修改
    $(".updateEmpBtn").click(function () {//同增加事件
        if (updateEmpVerify()) {
            updateEmp();
            $("#updateEmpModal").modal("hide");
        }

    });
//搜索
    $(".sec").click(function () {//搜索岗位基本信息的点击事件
        var data = $(".secbox").val();
        if (data == 0) {//判断搜索框是否为空，是则弹窗"请输入一点东西"
            alert("搜索不能为空");
        } else {//否则搜索内容为搜索框（.secbox）里的内容（val）的项将他的背景颜色改成淡蓝色
            $(".table tr:not(:first):contains(" + data + ")").css("background", "#D9EDF7")
            $(this).blur(function () {//离开搜索框是变成默认颜色
                $(".secbox").val("");
                $(".table tr").css("background", "#fff");
            })
        }
    });


});

function createEmp() {
    bootbox.confirm({
        size: "small",
        message: "你确定要添加该员工吗?",
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
                    url: "employee/doCreateEmployee",
                    type: "POST",
                    contentType: 'application/json;charset=utf-8',
                    data: JSON.stringify(sendData),
                    success: function (result) {
                        toastr.success("添加员工" + result.message);
                    },
                    error: function () {
                        toastr.error("添加员工出现错误！！！");
                    }
                })
            }
        }
    })
}

function createEmpVerify() {
    var name = $("#inputCreatedEmpName").val();
    var sex = $("#inputCreatedEmpSex").val();
    var birthday = $("#inputCreatedEmpBirth").val();
    var ID = $("#inputCreatedIdNum").val();
    var depart = $("#inputCreatedDepName").val();
    var position = $("#inputCreatedPosName").val();
    var entry = $("#inputCreatedDateOfEntry").val();
    var jobStart = $("#inputCreatedDateOfParti").val();
    var form = $("#inputCreatedForm").val();
    var source = $("#inputCreatedSource").val();
    if (name == 0 || sex == "" || birthday == 0 || ID == "" || depart == 0 || position == 0 || entry == 0 || form == "" || source == "" || jobStart == "") {//判断内容是否为空，否则弹窗
        alert("请完整地填写表单!");
        return false;
    } else if (isNaN(ID) || (!(/^(\+|-)?\d+$/.test(ID)) || ID < 0)) {
        alert("请填写正确的身份证格式(正整数)!");
        return false;
        //身份证的正则表达式:(/^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/)
    } else if (!isNaN(name)) {
        alert("请填写正确的姓名!");
        return false;
    } else if (!isNaN(position)) {
        alert("请填写正确的岗位类型!");
        return false;
    } else if (!isNaN(depart)) {
        alert("请填写正确的部门类型!");
        return false;
    } else {
        sendData = {
            "employeeName": name,
            "employeeSex": sex,
            "employeeBirth": birthday,
            "idNumber": ID,
            "departmentName": depart,
            "positionName": position,
            "dateOfEntry": entry,
            "dateOfParti": jobStart,
            "formOfEmployment": form,
            "sourceOfEmployment": source
        };
    }
    return true;
}

function updateEmp() {
    bootbox.confirm({
        size: "small",
        message: "你确定要修改该员工吗?",
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
                    url: "employee/doUpdateEmployee",
                    type: "POST",
                    contentType: 'application/json;charset=utf-8',
                    data: JSON.stringify(sendData),
                    success: function (result) {
                        toastr.success("修改员工" + result.message);
                    },
                    error: function () {
                        toastr.error("修改员工出现错误！！！");
                    }
                })
            }
        }
    })
}

function updateEmpVerify() {
    var arr = [];
    var empId = $("#inputUpdatedEmpId").val();
    var name = $("#inputUpdatedEmpName").val();
    var sex = $("#inputUpdatedEmpSex").val();
    var birthday = $("#inputUpdatedEmpBirth").val();
    var ID = $("#inputUpdatedIdNum").val();
    var depart = $("#inputUpdatedDepName").val();
    var position = $("#inputUpdatedPosName").val();
    var entry = $("#inputUpdatedDateOfEntry").val();
    var jobStart = $("#inputUpdatedDateOfParti").val();
    var form = $("#inputUpdatedForm").val();
    var source = $("#inputUpdatedSource").val();
    $(this).parent().siblings().find(".form-control").each(function () {
        arr.push($(this).val());
        if ($(this).attr("id") != "addemplySex" && $(this).attr("id") != "addemplyForm" && $(this).attr("id") != "addemplySource") {
            $(this).val("");
        }
    });
    if (name == 0 || sex == "" || birthday == 0 || ID == "" || depart == 0 || position == 0 || entry == 0 || form == "" || source == "" || jobStart == "") {//判断内容是否为空，否则弹窗
        alert("请完整地填写表单!");
        return false;
    } else if (isNaN(ID) || (!(/^(\+|-)?\d+$/.test(ID)) || ID < 0)) {
        alert("请填写正确的身份证格式(正整数)!");
        return false;
        //身份证的正则表达式:(/^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/)
    } else if (!isNaN(name)) {
        alert("请填写正确的姓名!");
        return false;
    } else if (!isNaN(position)) {
        alert("请填写正确的岗位类型!");
        return false;
    } else if (!isNaN(depart)) {
        alert("请填写正确的部门类型!");
        return false;
    } else {
        sendData = {
            "employeeId": parseInt(empId),
            "employeeName": name,
            "employeeSex": sex,
            "employeeBirth": birthday,
            "idNumber": ID,
            "departmentName": depart,
            "positionName": position,
            "dateOfEntry": entry,
            "dateOfParti": jobStart,
            "formOfEmployment": form,
            "sourceOfEmployment": source
        };
        return true;
    }
}