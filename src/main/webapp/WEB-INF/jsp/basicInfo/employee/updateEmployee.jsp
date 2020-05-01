<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/21
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--修改模态框-->
<div class="modal fade up" tabindex="-1" role="dialog" id="updateEmpModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">修改</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="inputUpdatedEmpId" class="control-label">Employee Number</label>
                        <input type="text" placeholder="员工号" class="form-control" id="inputUpdatedEmpId" readonly/>
                    </div>
                    <div class="form-group">
                        <label for="inputUpdatedEmpName" class="control-label">Employee Name</label>
                        <input type="text" placeholder="姓名" class="form-control" id="inputUpdatedEmpName"/>
                    </div>
                    <div class="form-group">
                        <label for="inputUpdatedEmpSex" class="control-label">Sex</label><br>
                        <select class="form-control" id="inputUpdatedEmpSex">
                            <option>男</option>
                            <option>女</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="inputUpdatedEmpBirth" class="control-label">Employee Birthday</label>
                        <input type="text" placeholder="出生日期" class="form-control" id="inputUpdatedEmpBirth"/>
                    </div>
                    <div class="form-group">
                        <label for="inputUpdatedIdNum" class="control-label">Employee ID</label>
                        <input type="text" placeholder="身份证号" class="form-control" id="inputUpdatedIdNum"/>
                    </div>
                    <div class="form-group">
                        <label for="inputUpdatedDepName" class="control-label">Department</label>
                        <%--<input type="text" placeholder="部门" class="form-control" id="inputUpdatedDepName"/>--%>
                        <select class="form-control" id="inputUpdatedDepName">
                             <c:forEach var="dep" items="${departments}">
                                 <option>${dep.departmentName}</option>
                             </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="inputUpdatedPosName" class="control-label">Position</label>
                        <%--<input type="text" placeholder="岗位" class="form-control" id="inputUpdatedPosName"/>--%>
                        <select class="form-control" id="inputUpdatedPosName">
                            <c:forEach var="pos" items="${positions}">
                                <option>${pos.positionName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="inputUpdatedDateOfEntry" class="control-label">Date of Entry</label>
                        <input type='text' placeholder="入职日期" class="form-control" id="inputUpdatedDateOfEntry"/>
                    </div>
                    <div class="form-group">
                        <label for="inputUpdatedDateOfParti" class="control-label">Date of Participation</label>
                        <input type="text" placeholder="参加工作日期" class="form-control" id="inputUpdatedDateOfParti"/>
                    </div>
                    <div class="form-group">
                        <label for="inputUpdatedForm" class="control-label">Form of Employment</label>
                        <select class="form-control" id="inputUpdatedForm">
                            <option>正式员工</option>
                            <option>临时员工</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="inputUpdatedSource" class="control-label">Source of Employment</label>
                        <select class="form-control" id="inputUpdatedSource">
                            <option>校园招聘</option>
                            <option>社会招聘</option>
                            <option>其他</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary updateEmpBtn">确定</button><!--确定修改-->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
</div>