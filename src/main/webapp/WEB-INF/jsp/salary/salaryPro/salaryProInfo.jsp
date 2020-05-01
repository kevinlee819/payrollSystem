<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/25
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="form-group topcard">
    <div class="row">
        <div class="col-md-7">
            <input type="text" class="form-control secbox" placeholder="输入工资项目的名称、类型"/>
        </div>
        <div class="col-md-5">
            <button class="btn btn-danger sec">搜索工资信息</button><!--搜索-->
            <button class="btn btn-default createProBtn" data-toggle="modal" data-target="#createProModal">新建工资项目
            </button>
            <!--data-toggle data-target 属性插入bootstrap事件自带的模态框事件-->
        </div>
    </div>
</div>
<table class="table table-bordered text-center" id="alterColor">
    <tr>
        <th>序号</th>
        <th>名称</th>
        <th>类型</th>
        <th>是否在工资条显示</th>
        <th>显示顺序</th>
        <th>增减项</th>
        <th>操作</th>
    </tr>
    <c:if test="${empty salaryPros}">
        <h3 style="color: #b21f2d">没有搜索到信息！</h3>
    </c:if>
    <c:if test="${not empty salaryPros}">
        <h3>${title}</h3>
        <c:forEach var="salaryPro" items="${salaryPros}">
            <tr>
                <td>${salaryPro.salaryProId}</td>
                <td>${salaryPro.salaryProName}</td>
                <td>${salaryPro.salaryProType}</td>
                <td>${salaryPro.isDisplayed}</td>
                <td>${salaryPro.displayOrder}</td>
                <td>${salaryPro.incOrDec}</td>
                <td>
                    <a href="#" role="button" class="btn btn-primary updateProBtn" data-toggle="modal"
                       data-target="#updateProModal">编辑</a>
                    <a href="#" role="button" class="btn btn-danger deleteProBtn">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>