<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/21
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--增加模态框-->
<div class="modal fade createEmpModal" tabindex="-1" role="dialog" id="createEmpModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">添加员工</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>

            </div>
            <div class="modal-body">
                <form>
                    <%--<div class="form-group">--%>
                        <%--<label for="inputCreatedEmpId" class="control-label">Employee Number</label>--%>
                        <%--<input type="text" placeholder="员工号" class="form-control" id="inputCreatedEmpId"/>--%>
                    <%--</div>--%>
                    <div class="form-group">
                        <label for="inputCreatedEmpName" class="control-label">Employee Name</label>
                        <input type="text" placeholder="姓名" class="form-control" id="inputCreatedEmpName"/>
                    </div>
                    <div class="form-group">
                        <label for="inputCreatedEmpSex" class="control-label">Sex</label><br>
                        <select class="form-control" id="inputCreatedEmpSex">
                            <option>男</option>
                            <option>女</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="inputCreatedEmpBirth" class="control-label">Employee Birthday</label>
                        <input type="text" placeholder="出生日期" class="form-control" id="inputCreatedEmpBirth"/>
                    </div>
                    <div class="form-group">
                        <label for="inputCreatedIdNum" class="control-label">Employee ID</label>
                        <input type="text" placeholder="身份证号" class="form-control" id="inputCreatedIdNum"/>
                    </div>
                    <div class="form-group">
                        <label for="inputCreatedDepName" class="control-label">Department</label>
                        <%--<input type="text" placeholder="部门" class="form-control" id="inputCreatedDepName"/>--%>
                        <select class="form-control" id="inputCreatedDepName">
                            <c:forEach var="dep" items="${departments}">
                                <option>${dep.departmentName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="inputCreatedPosName" class="control-label">Position</label>
                        <%--<input type="text" placeholder="岗位" class="form-control" id="inputCreatedPosName"/>--%>

                        <select class="form-control" id="inputCreatedPosName">
                            <c:forEach var="pos" items="${positions}">
                                <option>${pos.positionName}</option>
                            </c:forEach>
                        </select></div>
                    <div class="form-group">
                        <label for="inputCreatedDateOfEntry" class="control-label">Date of Entry</label>
                        <input type='text' placeholder="入职日期" class="form-control" id="inputCreatedDateOfEntry"/>
                    </div>
                    <div class="form-group">
                        <label for="inputCreatedDateOfParti" class="control-label">Date of Participation</label>
                        <input type="text" placeholder="参加工作日期" class="form-control" id="inputCreatedDateOfParti"/>
                    </div>
                    <div class="form-group">
                        <label for="inputCreatedForm" class="control-label">Form of Employment</label>
                        <select class="form-control" id="inputCreatedForm">
                            <option>正式员工</option>
                            <option>临时员工</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="inputCreatedSource" class="control-label">Source of Employment</label>
                        <select class="form-control" id="inputCreatedSource">
                            <option>校园招聘</option>
                            <option>社会招聘</option>
                            <option>其他</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary createEmpBtn">确定</button><!--确定添加-->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>