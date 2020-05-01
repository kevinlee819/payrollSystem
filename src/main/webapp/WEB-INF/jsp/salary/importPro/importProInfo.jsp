<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/24
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row topcard">
    <div class="col-md-5" style="padding-right: 0px; padding-left:10px">
        <input type="text" class="form-control secbox" placeholder="通过员工ID或者部门名搜索导入项目"/>
    </div>
    <div class="col-md-1" style="padding: 0 0 0 0;">
        <button type="button" class="btn btn-success sec">
            <i class="fa fa-search"></i>
            <span>搜索</span>
        </button>
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
            <button type="button" class="btn btn-default importProBtn">
                <i class="fa fa-upload"></i>
                <span class="hidden-xs">提交</span>
            </button>
        </form>
    </div>
    <div class="col-md-2" style="padding-top: 5px; padding-left: 0px">
        <input type="text" id="des" placeholder="尚无文件被导入" disabled="disabled" style="width:210px"/>
    </div>
</div>
<br>
<c:if test="${not empty date}">
<div class="row">
    <table class="table table-bordered text-center" id="alterColor">
        <tr>
            <th>序号</th>
            <th>日期</th>
            <th>操作</th>
        </tr>
        <c:forEach var="date" items="${date}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${date}</td>
                <td>
                    <a href="#" role="button" class="btn btn-primary checkImportBtn">查看</a>
                    <a href="#" role="button" class="btn btn-danger deleteImportBtn">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</c:if>

<c:if test="${not empty importPros}">
    <div class="row">
        <table class="table table-bordered text-center">
            <tr>
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>病假天数</th>
                <th>事假天数</th>
                <th>迟到次数</th>
                <th>加班天数</th>
                <th>补发</th>
                <th>导入日期</th>
                <th>操作</th>
            </tr>
            <c:forEach var="importPro" items="${importPros}" varStatus="status">
                <tr>
                    <td>${importPro.empId}</td>
                    <td>${importPro.empName}</td>
                    <td>${importPro.sickLeaveDay}</td>
                    <td>${importPro.personalLeaveDay}</td>
                    <td>${importPro.lateNum}</td>
                    <td>${importPro.overtimeDay}</td>
                    <td>${importPro.reissue}</td>
                    <td>${importPro.importDate}</td>
                    <td>
                        <a href="#" role="button" class="btn btn-info updateImportBtn" data-toggle="modal"
                           data-target="#updateImportModal">更新</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>