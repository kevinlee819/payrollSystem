<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/27
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row topcard">
    <label for="department" class="col-md-1 ]control-label"
           style="font-weight:bold; text-align:right; margin:5px 0 0 0; padding: 0 0 0 0;">部门:</label>
    <div class="col-md-2">
        <select class="selectpicker form-control" data-live-search="true" name="department" id="department">
            <option></option>
            <c:forEach var="dep" items="${departments}">
                <option>${dep.departmentName}</option>
            </c:forEach>
        </select>
    </div>
    <label for="startTime" class="col-md-1 control-label"
           style="font-weight:bold; text-align:right; margin:5px 0 0 0; padding: 0 5px 0 0;">Start</label>
    <div class="col-md-1" style="padding-left:0; padding-right:0;">
        <input type="text" placeholder="选择起始日期" class="form-control" id="startTime"/>
    </div>
    <label for="endTime" class="col-md-1 control-label"
           style="font-weight:bold; text-align:right; margin:5px 0 0 0; padding: 0 5px 0 0;">End</label>
    <div class="col-md-1" style="padding-left:0; padding-right:0;">
        <input type="text" placeholder="选择结束日期" class="form-control" id="endTime"/>
    </div>
    <div class="col-md-2" style="padding-right: 0px; padding-left:20px">
        <input type="number" class="form-control secbox" placeholder="输入员工号(可不填)" id="empId"/>
    </div>
    <div class="col-md-1" style="padding: 0 0 0 0;">
        <button type="button" class="btn btn-success sec">
            <i class="fa fa-search"></i>
            <span>搜索</span>
        </button>
    </div>
    <div class="col-md-1">
        <button type="button" class="btn btn-default print" onclick="print1()">
            <i class="fa fa-print"></i>
            <span>打印</span>
        </button>
    </div>

</div>
<hr>
<div id="print_area">

    <table class="table table-bordered text-center" id="alterColor">
        <caption style="text-align: center;caption-side: top;font-weight:bold;font-size: 25px">${title}</caption>
        <thead>
        <tr>
            <th>日期</th>
            <th>部门名</th>
            <th>员工编号</th>
            <th>姓名</th>
            <th>实发工资</th>
            <th>基本工资</th>
            <th>采暖补贴</th>
            <th>病假天数</th>
            <th>事假天数</th>
            <th>加班天数</th>
            <th>迟到次数</th>
            <th>病假扣款</th>
            <th>事假扣款</th>
            <th>加班工资</th>
            <th>迟到扣款</th>
            <th>补发</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty calculateSalary}">
            <c:forEach var="salary" items="${calculateSalary}" varStatus="status">
                <tr>
                    <td>${salary.importProjectInfo.importDate}</td>
                    <td>${salary.depName}</td>
                    <td>${salary.empId}</td>
                    <td>${salary.empName}</td>
                    <td>${salary.realSalary}</td>
                    <td>${salary.fixedSalaryPro.basicSalary}</td>
                    <td>${salary.fixedSalaryPro.heatingSubsidy}</td>
                    <td>${salary.importProjectInfo.sickLeaveDay}</td>
                    <td>${salary.importProjectInfo.personalLeaveDay}</td>
                    <td>${salary.importProjectInfo.overtimeDay}</td>
                    <td>${salary.importProjectInfo.lateNum}</td>
                    <td>${salary.sickCharge}</td>
                    <td>${salary.personalCharge}</td>
                    <td>${salary.overtimeSalary}</td>
                    <td>${salary.lateCharge}</td>
                    <td>${salary.reissue}</td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>