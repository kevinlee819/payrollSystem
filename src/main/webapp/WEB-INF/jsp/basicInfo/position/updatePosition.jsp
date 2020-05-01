<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/20
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--修改模态框-->
<div class="modal fade up" tabindex="-1" role="dialog" id="updatePosModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">修改(UPDATE)</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

            </div>
            <div class="modal-body">
                <form class="updatePosForm">
                    <div class="form-group">
                        <label for="inputUpdatedPosId" class="control-label">Position Id</label>
                        <input type="number" name="positionId" placeholder="岗位编号" class="form-control" id="inputUpdatedPosId" readonly>
                    </div>
                    <div class="form-group">
                        <label for="inputUpdatedPosName" class="control-label">Position Name</label>
                        <input type="text" name="positionName" placeholder="岗位名称" class="form-control" id="inputUpdatedPosName"  />
                    </div>
                    <div class="form-group">
                        <label for="inputUpdatedPosType" class="control-label">Position Type</label>
                        <select type="text" name="positionType" class="form-control" id="inputUpdatedPosType">
                            <option>管理</option>
                            <option>技术</option>
                            <option>市场</option>
                            <option>营销</option>
                            <option>文职</option>
                            <option>普通工人</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="inputUpdatedEmpNum" class="control-label">Employee Num</label>
                        <input type="text" name="employeeNum" placeholder="岗位编制" class="form-control" id="inputUpdatedEmpNum"/>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary doUpdatePosBtn">确定</button><!--确定修改-->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>