(function () {
    toastr.options.positionClass = 'toast-top-center';
    var oList = document.querySelectorAll('.list-group-item h3'),
        oHide = document.querySelectorAll('.ItemDet'),
        oIcon = document.querySelectorAll('.list-group-item i'),
        lastIndex = 0;
    for(var i=0;i<oList.length;i++){
        oList[i].index = i;//自定义属性
        oList[i].isClick = false;
        oList[i].initHeight = oHide[i].clientHeight;
        oHide[i].style.height = '0';
        oList[i].onclick = function () {
            if(this.isClick){
                oHide[this.index].style.height = '0';
                oIcon[this.index].className = '';
                oList[this.index].className = '';
                oList[this.index].isClick = false;
            }
            else{
                oHide[lastIndex].style.height = '0';
                oIcon[lastIndex].className = '';
                oList[lastIndex].className = '';
                oHide[this.index].style.height = '220px';
                oIcon[this.index].className = 'on';
                oList[this.index].className = 'on';
                oList[lastIndex].isClick = false;
                oList[this.index].isClick = true;
                lastIndex = this.index;
            }
        }
} })();
function altRows(id){
    if(document.getElementsByTagName){

        var table = document.getElementById(id);
        var rows = table.getElementsByTagName("tr");

        for(i = 1; i < rows.length; i++){
            if(i % 2 == 0){
                rows[i].className = "evenrowcolor";
            }else{
                rows[i].className = "oddrowcolor";
            }
        }
    }
}

window.onload=function(){
    altRows("alterColor");
};

//退出登录
function logout(){
    bootbox.confirm({
        size: "small",
        message: "你确定要退出登录吗?",
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
                 window.location.href = "/payroll_management_system_war_exploded/logout";
            }
        }
    })
}



function submitPass() {
    var p0 = $("#oldpass").val();
    var p1 = $("#newpass").val();
    var p2 = $("#confirmpass").val();
    if(p1 != p2){
        toastr.error("两次输入密码不一样！");
    }else {
        $.ajax({
            url: "/payroll_management_system_war_exploded/changePassword?old=" + p0 + "&new=" + p1,
            type: "POST",
            async: true,
            dataType: "json",
            success: function (res) {
                if (res.code == 1) {
                    toastr.success("修改密码成功");
                    $("#reset").click();
                    $("#accountManageModal").modal("hide");
                } else {
                    toastr.error("输入密码错误");
                }
            },
            error: function () {
                toastr.error("请求失败！！！");
            }
        });
    }
}
