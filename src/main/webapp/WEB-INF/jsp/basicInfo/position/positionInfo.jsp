<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/20
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container topcard" style="padding-top: 15px;"><!--整个盒子居中-->
    <div class="form-group">
        <div class="row">
            <div class="col-md-5">
                <input type="text" class="form-control secPosBox" placeholder="输入岗位编号/名称/类型"/>
            </div>
            <div class="col-md-7">
                <%--<button class="btn btn-danger sec">搜索岗位信息</button><!--搜索-->--%>
                <button class="btn btn-success secPosEmp">搜索岗下员工</button>
                <button class="btn btn-default createPosBtn" data-toggle="modal"
                        data-target="#createPosModal">新建岗位
                </button>
                <!--data-toggle data-target 属性插入bootstrap事件自带的模态框事件-->
            </div>
        </div>
    </div>
</div>
<br>
<div class="positionInfo">
    <table class="table table-bordered text-center" id="alterColor">
        <tr>
            <th>编号</th>
            <th>岗位名称</th>
            <th>岗位类型</th>
            <th>岗位编制</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${positions}" var="position">
            <tr>
                <td>${position.positionId}</td>
                <td>${position.positionName}</td>
                <td>${position.positionType}</td>
                <td>${position.employeeNum}</td>
                <td>
                    <a href="#" role="button" class="btn btn-primary editPosBtn" data-toggle="modal"
                       data-target="#updatePosModal">编辑</a>
                    <a href="#" role="button" class="btn btn-danger deletePosBtn">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
