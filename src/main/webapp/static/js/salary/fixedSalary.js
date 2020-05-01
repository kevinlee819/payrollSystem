var wb;//读取完成的数据
var sendData;
var FILE_MAXSIZE = 1024;//导入文件最大大小
toastr.options.positionClass = 'toast-top-center';
$(function () {
    $(".subhead").text("固定工资管理");
    //查看
    $(".checkFixedBtn").click(function () {
        //获取部门名
        var depName = $(this).parent().parent().find("td:eq(1)").text();
        checkFixed(depName);
    });
    //搜索
    $(".sec").click(function () {
        var data = $(".secbox").val()
        if (data == 0) {//判断搜索框是否为空，是则弹窗"请输入一点东西"
            toastr("搜索不能为空");
        } else {//否则搜索内容为搜索框（.secbox）里的内容（val）的项将他的背景颜色改成淡蓝色
            $(".table tr:not(:first):contains(" + data + ")").css("background", "#D9EDF7")
            $(this).blur(function () {//离开搜索框是变成默认颜色
                $(".secbox").val("");
                $(".table tr").css("background", "#fff")
            })
            window.location.href = "/payroll_management_system_war_exploded/salary/fixedSalary/search?wd=" +data;
        }
    });
    //导入
    $(".importFixedBtn").click(function () {
        $.ajax({
            url: "/payroll_management_system_war_exploded/salary/fixedSalary/submit",
            type: "POST",
            contentType: 'application/json;charset=utf-8',
            dataType: "json",
            data: sendData,
            success: function (result) {
                toastr.success("导入文件" + result.message);
            },
            error: function (res) {
                toastr.error("导入文件失败:" + res.s);
            }
        })
    });
    //点击修改按钮,往模态框中填充信息
    $(".updateFixedBtn").click(function () {
        var data = [];
        for (var i = 0; i < 5; i++) {
            data[i] = $(this).parent().parent().find("td:eq(" + i + ")").text();

        }
        $("#updateEmpId").val(data[0]);
        $("#updateEmpName").val(data[1]);
        $("#updateBasicSalary").val(data[2]);
        $("#updateHeatingSubsidy").val(data[3]);
        $("#updateDepName").val(data[4]);
    });
    //确定修改
    $(".confirmUpdateFixedBtn").click(function () {
        //获取修改数据
        var updateData = {
            empId: parseInt($("#updateEmpId").val()),
            empName: $("#updateEmpName").val(),
            basicSalary: parseFloat($("#updateBasicSalary").val()),
            heatingSubsidy: parseFloat($("#updateHeatingSubsidy").val()),
            depName:  $("#updateDepName").val()
        };
        updateFixed(updateData);
    });

});

function updateFixed(updateData) {
    bootbox.confirm({
        size: "small",
        message: "你确定要修改该固定工资项目吗?",
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
                    url: "/payroll_management_system_war_exploded/salary/fixedSalary/doUpdateFixedPro/",
                    type: "POST",
                    contentType: 'application/json;charset=utf-8',
                    data: JSON.stringify(updateData),
                    success: function (result) {
                        location.reload();
                        toastr.success("修改固定工资项目" + result.message);

                    },
                    error: function () {
                        toastr.error("修改固定工资项目出现错误！！！");
                    }
                })
            }
        }
    })
}

function checkFixed(data) {
    window.location.href = "/payroll_management_system_war_exploded/salary/fixedSalary/check?wd=" + data;
}

function importExcel(obj) {//导入
    if (!obj.files) {
        return;
    }
    var suffix = obj.files[0].name.split(".")[1];
    if (suffix != 'xls' && suffix != 'xlsx') {
        toastr.error("导入的文件格式不正确！")
        //alert('导入的文件格式不正确!');
        return
    }
    if (obj.files[0].size / 1024 > FILE_MAXSIZE) {
        toastr.error("导入的表格文件不能大于1M");
        return
    }
    var f = obj.files[0];
    var reader = new FileReader();
    reader.onload = function (e) {
        var data = e.target.result;
        wb = XLSX.read(data, {
            type: 'binary'
        });
        sendData = JSON.stringify(XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]));
    };
    reader.readAsBinaryString(f);
}

function show() {
    var str = [];
    str = document.getElementById("upload").value.split("\\");
    document.getElementById("des").value = str[str.length - 1];
}