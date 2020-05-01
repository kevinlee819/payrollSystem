toastr.options.positionClass = 'toast-top-center';
$(function () {
    $(".subhead").text("工资查询报表");
    //搜索
    $(".sec").click(function () {
        var depName = $("#department").val();
        var startDate = $("#startTime").val();
        var endDate = $("#endTime").val();
        var empId = $("#empId").val();
        if(depName != 0){
            window.location.href = "/payroll_management_system_war_exploded/form/search?depName=" + depName;
        }else if(startDate != 0 && endDate != 0){
            window.location.href = "/payroll_management_system_war_exploded/form/search?startDate=" + startDate + "&endDate=" + endDate;
        }else if(empId != 0){
            window.location.href = "/payroll_management_system_war_exploded/form/search?empId=" + empId;
        }else{
            toastr.error("搜索内容不能为空");
        }
    });

    $('#startTime,#endTime').datetimepicker({
        format:'YYYY-MM'
    });
});
function print1(){
    $("#print_area").jqprint({
        debug: false,
        importCSS: true,
        printContainer: true,
        operaSupport: false
    });
}
function showSel(){
    $.ajax({
        "type" : 'get',
        "url": '#' , //!!在这添加URL
        "dataType" : "json",
        "success" : function(data) {
            var depart_list = data.data;
            var opts = "";
            for( var depart_index = 0 ; depart_index < depart_list.length; depart_index++ ){
                var depart = depart_list[depart_index];
                opts += "<option value='"+需要加的.id+"'>"+显示的名称.name+"</option>";
            }
// 查询界面
            $("#firmsalary").append(opts);
            $("#firmsalary").selectpicker("refresh");
        }
    });
}
