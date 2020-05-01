<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/26
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade up" tabindex="-1" role="dialog" id="updateImportModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">修改导入项目信息</h4>
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
                        <label for="updateSickLeaveDay" class="control-label">病假天数</label>
                        <input type="number" placeholder="病假天数" class="form-control" id="updateSickLeaveDay"/>
                    </div>

                    <div class="form-group">
                        <label for="updatePersonalLeaveDay" class="control-label">事假天数</label>
                        <input type="number" placeholder="事假天数" class="form-control" id="updatePersonalLeaveDay"/>
                    </div>

                    <div class="form-group">
                        <label for="updateLateNum" class="control-label">迟到次数</label>
                        <input type="number" placeholder="迟到次数" class="form-control" id="updateLateNum"/>
                    </div>

                    <div class="form-group">
                        <label for="updateOvertimeDay" class="control-label">加班天数</label>
                        <input type="number" placeholder="加班天数" class="form-control" id="updateOvertimeDay"/>
                    </div>

                    <div class="form-group">
                        <label for="updateReissue" class="control-label">补发</label>
                        <input type="number" placeholder="补发" class="form-control" id="updateReissue"/>
                    </div>

                    <div class="form-group">
                        <label for="updateImportDate" class="control-label">导入日期</label>
                        <input type="text" placeholder="导入日期" class="form-control" id="updateImportDate" readonly/>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary confirmUpdateImportBtn">确定</button><!--确定修改-->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
