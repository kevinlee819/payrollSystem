<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/19
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--添加部门模态框--%>
<div class="modal fade" id="updateDepModal" role="dialog" aria-labelledby="updateDepModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title" id="updateDepModalLabel">修改部门</h3>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>

            </div>
            <div class="modal-body">
                <form class="updateDepForm" method="get">
                    <div class="updateDepId">
                        <label for="inputUpdatedDepId">Department ID(不可修改)</label>
                        <input id="inputUpdatedDepId" name="departmentId" class="form-control" type="number" readonly/>
                    </div>
                    <br>
                    <div class="updateDepName">
                        <label for="inputUpdatedDepName" class="control-label">Department Name
                        </label>
                        <input id="inputUpdatedDepName" name="departmentName" class="form-control" placeholder="部门名称" tabindex="1" required autofocus/>
                    </div>
                    <br>
                    <div class="updateDepTel">
                        <label for="inputUpdatedDepTel" class="control-label">Telephone Number</label>
                        <input id="inputUpdatedDepTel" name="departmentTel" class="form-control" placeholder="电话" tabindex="2"/>
                    </div>
                    <br>
                    <div class="updateDepType">
                        <label class="control-label">Department Type</label>
                        <select id="inputUpdatedDepType" class="form-control" name="departmentType">
                            <option>公司</option>
                            <option>部门</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary updateDepBtn">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
