<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/26
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<div class = "row topcard">

    <div class="col-md-5 col-lg-5" style="padding-right: 0px; padding-left:10px">
        <input  type="text" class="form-control secbox" placeholder="请输入员工号或者部门名" /><!--搜索框-->
    </div>
    <div class="col-md-1 col-lg-1" style="padding: 0 0 0 0;">
         <button type="button" class="btn btn-success sec">
            <i class="fa fa-search"></i>
            <span>搜索</span>
        </button><!--搜索-->
    </div>
    <div class="col-md-3" style="padding-left:30px; padding-right:0px">
        <form>
            <label class="input-group-btn">
                            <span class="btn btn-primary">
                                <i class="fa fa-folder-open"></i>导入
                            </span>
                <input type="file"
                       accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel"
                       onchange="show();importExcel(this)" style="display: none;" id="upload" single>
            </label>
            <button type="button" class="btn btn-default importFixedBtn">
                <i class="fa fa-upload"></i>
                <span class="hidden-xs">提交</span>
            </button>
        </form>
    </div>
    <div class="col-md-2" style="padding-top: 5px; padding-left: 0px">
        <input type="text" id="des" placeholder="尚无文件被导入" disabled="disabled" style="width:180px"/>
    </div>
</div>
<br>
<c:if test="${not empty departments}">
    <div class="row">
        <table class="table table-bordered text-center" id="alterColor">
            <tr>
                <th>序号</th>
                <th>部门</th>
                <th>操作</th>
            </tr>
            <c:forEach var="dep" items="${departments}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${dep}</td>
                    <td>
                        <a href="#" role="button" class="btn btn-dark checkFixedBtn">查看</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>

<c:if test="${not empty fixedSalary}">
    <div class="row">
        <table class="table table-bordered text-center">
            <tr>
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>基本工资</th>
                <th>采暖补贴</th>
                <th>部门</th>
                <th>操作</th>
            </tr>
            <c:forEach var="fix" items="${fixedSalary}" varStatus="status">
                <tr>
                    <td>${fix.empId}</td>
                    <td>${fix.empName}</td>
                    <td>${fix.basicSalary}</td>
                    <td>${fix.heatingSubsidy}</td>
                    <td>${fix.depName}</td>
                    <td>
                        <a href="#" role="button" class="btn btn-info updateFixedBtn" data-toggle="modal"
                           data-target="#updateFixedModal">更新</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>