<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/27
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row topcard">
    <label for="department" class="col-md-1 col-lg-1 control-label"
           style="font-weight:bold; text-align:right; margin:5px 0 0 0; padding: 0 0 0 0;">部门:</label>
    <div class="col-md-2 col-lg-2">
        <select class="selectpicker form-control" data-live-search="true" name="department" id="department">
            <c:forEach var="dep" items="${departments}">
                <option>${dep.departmentName}</option>
            </c:forEach>
        </select>
    </div>
    <label for="month" class="col-md-1 col-lg-1 control-label"
           style="font-weight:bold; text-align:right; margin:5px 0 0 0; padding: 0 0 0 0;">月份:</label>
    <div class="col-md-2 col-lg-2">
        <input type="text" placeholder="选择计算月份" class="form-control" id="month"/>
    </div>
    <div class="col-md-1">
        <button type="button" class="btn btn-primary calculate">
            <i class="fa fa-plus"></i>
            <span class="hidden-xs">计算</span>
        </button>
    </div>
    <div class="col-md-1" style="margin-left: 30px">
        <button type="button" class="btn btn-primary save">
            <i class="fa fa-save"></i>
            <span class="hidden-xs">暂存</span>
        </button>
    </div>
    <div class="col-md-1" style="margin-left: 30px">
        <button type="button" class="btn btn-danger give">
            <i class="fa fa-money"></i>
            <span class="hidden-xs">发放</span>
        </button>
    </div>
</div>
<hr>
<div>
    <div style="float: left;">
        <h2 class="salaryTitle">研发部 2019-06工资信息</h2>
    </div>
    <div style="float: left">
        <c:if test="${status==0}">
            <h3 class="status" style="color:firebrick">(暂存状态)</h3>
        </c:if>
        <c:if test="${status==1}">
            <h3 class="status" style="color: firebrick">(已经发放)</h3>
        </c:if>
    </div>
    <table class="table table-bordered text-center" id="alterColor">
        <tr>
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
        <c:if test="${not empty calculateSalary}">
            <c:forEach var="salary" items="${calculateSalary}" varStatus="status">
                <tr>
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
    </table>
</div>