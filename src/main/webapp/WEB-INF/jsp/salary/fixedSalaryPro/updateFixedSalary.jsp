<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/26
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade up" tabindex="-1" role="dialog" id="updateFixedModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">修改固定工资项目信息</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="updateEmpId" class="control-label">员工ID</label>
                        <input type="text" class="form-control" id="updateEmpId" readonly/>
                    </div>
                    <div class="form-group">
                        <label for="updateEmpName" class="control-label">员工名称</label>
                        <input type="text" class="form-control" id="updateEmpName" readonly/>
                    </div>
                    <div class="form-group">
                        <label for="updateBasicSalary" class="control-label">基本工资</label>
                        <input type="number" placeholder="Basic Salary" class="form-control" id="updateBasicSalary"/>
                    </div>

                    <div class="form-group">
                        <label for="updateHeatingSubsidy" class="control-label">采暖补贴</label>
                        <input type="number" placeholder="Heating Subsidy" class="form-control" id="updateHeatingSubsidy"/>
                    </div>

                    <div class="form-group">
                        <label for="updateDepName" class="control-label">部门名</label>
                        <input type="number" placeholder="Department" class="form-control" id="updateDepName" readonly/>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary confirmUpdateFixedBtn">确定</button><!--确定修改-->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
