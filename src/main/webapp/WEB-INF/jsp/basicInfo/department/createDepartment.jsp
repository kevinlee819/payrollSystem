<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/19
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"--%>
      <%--rel="stylesheet">--%>

<%--添加部门模态框--%>
<div class="modal fade" id="createDepModal" role="dialog" aria-labelledby="createDepModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title" id="createDepModalLabel">添加部门</h3>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>

            </div>
            <div class="modal-body">
                <form class="createDepForm" method="get">
                    <div class="createDepName">
                        <label for="departmentName" class="control-label">Department Name
                        </label>
                        <input id="departmentName" name="departmentName" class="form-control" placeholder="部门名称" tabindex="1"/>
                    </div>
                    <br>
                    <div class="createDepTel">
                        <label for="departmentTel" class="control-label">Telephone Number</label>
                        <input id="departmentTel" name="departmentTel" class="form-control" placeholder="电话" tabindex="2"/>
                    </div>
                    <br>
                    <div class="createDepType">
                        <label class="control-label">Department Type</label>
                        <select class="form-control" name="departmentType" id="departmentType">
                            <option>公司</option>
                            <option>部门</option>
                        </select>
                    </div>
                    <br>
                    <%--日期--%>
                    <div class="form-group">
                        <label class="control-label">Start Date</label>
                        <!--指定 date标记-->
                        <div class='input-group date' >
                            <input type='text' id='startDate' class="form-control" name="startDate" placeholder="YYYY-MM-DD"/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary createDepBtn">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
