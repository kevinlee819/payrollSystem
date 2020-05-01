<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/25
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="modal fade createProModal" tabindex="-1" role="dialog" id="createProModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">新建</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>

            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="createProName" class="control-label">新增工资名称</label>
                        <input type="text" placeholder="名称" class="form-control" id="createProName"/>
                    </div>
                    <div class="form-group">
                        <label for="createProType" class="control-label">类型</label>
                        <select class="form-control" id="createProType">
                            <option>固定项目</option>
                            <option>计算项目</option>
                            <option>导入项目</option>
                            <option>实发项目</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="createDisplay" class="control-label">是否在工资条显示</label>
                        <select class="form-control" id="createDisplay"><!--Show on salary sheet-->
                            <option>是</option>
                            <option>否</option>
                        </select>
                    </div>
                    <div>
                        <label for="createDisplayOrder" class="control-label">显示顺序</label>
                        <input class="form-control" placeholder="Display Order" type="number" id="createDisplayOrder"/>
                    </div>
                    <div class="form-group">
                        <label for="createIncOrDec" class="control-label">增减项</label>
                        <select class="form-control" id="createIncOrDec">
                            <option>增项</option>
                            <option>减项</option>
                            <option>无影响项</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary confirmCreateProBtn">确定</button><!--确定添加-->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>