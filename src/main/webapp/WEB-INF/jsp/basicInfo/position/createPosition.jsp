<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/20
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--增加模态框-->
<div class="modal fade addmd" tabindex="-1" role="dialog" id="createPosModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">新建</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>

            </div>
            <div class="modal-body">
                <form class="createPosForm">
                    <%--<div class="form-group">--%>
                    <%--<label for="inputCreatedPosId" class="control-label">Position Id</label>--%>
                    <%--<input type="number" name="positionId" placeholder="岗位编号" class="form-control" id="inputCreatedPosId">--%>
                    <%--</div>--%>
                    <div class="form-group">
                        <label for="inputCreatedPosName" class="control-label">Position Name</label>
                        <input type="text" name="positionName" placeholder="岗位名称" class="form-control"
                               id="inputCreatedPosName"/>
                    </div>
                    <div class="form-group">
                        <label for="inputCreatedPosType" class="control-label">Position Type</label>
                        <select type="text" name="positionType" class="form-control" id="inputCreatedPosType">
                            <option>管理</option>
                            <option>技术</option>
                            <option>市场</option>
                            <option>营销</option>
                            <option>文职</option>
                            <option>普通工人</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="inputCreatedEmpNum" class="control-label">Employee Num</label>
                        <input type="text" name="employeeNum" placeholder="岗位编制" class="form-control"
                               id="inputCreatedEmpNum"/>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary confirmCreatePosBtn">确定</button><!--确定添加-->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

