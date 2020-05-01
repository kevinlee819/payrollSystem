<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/25
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="modal fade up" tabindex="-1" role="dialog" id="updateProModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">修改</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>

            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="updateProId" class="control-label">Salary Project ID</label>
                        <input type="text" placeholder="工资项目编号" class="form-control" id="updateProId" readonly/>
                    </div>
                    <div class="form-group">
                        <label for="updateProName" class="control-label">Salary Project Name</label>
                        <input type="text" placeholder="工资项目名称" class="form-control" id="updateProName"/>
                    </div>
                    <div class="form-group">
                        <label for="updateProType" class="control-label">Salary Project Type</label>
                        <select class="form-control" id="updateProType">
                            <option>固定项目</option>
                            <option>计算项目</option>
                            <option>导入项目</option>
                            <option>实发项目</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="updateDisplay" class="control-label">是否在工资条显示</label>
                        <select class="form-control" id="updateDisplay">
                            <option>是</option>
                            <option>否</option>
                        </select>
                    </div>
                    <div>
                        <label for="updateDisplayOrder" class="control-label">显示顺序</label>
                        <input class="form-control" placeholder="Display Order" type="number" id="updateDisplayOrder"/>
                    </div>
                    <div class="form-group">
                        <label for="updateIncOrDec" class="control-label">增减项</label>
                        <select class="form-control" id="updateIncOrDec">
                            <option>增项</option>
                            <option>减项</option>
                            <option>无影响项</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary confirmUpdateProBtn">确定</button><!--确定修改-->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
