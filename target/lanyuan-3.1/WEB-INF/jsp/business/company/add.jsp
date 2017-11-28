<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/business/company/add.js">
	
</script>
<style type="text/css">
.col-sm-3 {
	width: 22%;
	float: left;
	text-align: right;
}

.col-sm-9 {
	width: 78%;
	float: left;
	text-align: left;
}

label[class^="btn btn-default"] {
	margin-top: -4px;
}
</style>
</head>
<body>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
	<form id="form" name="form" class="form-horizontal" method="post" action="${ctx}/company/addEntity.shtml">
		<section class="panel panel-default">
		<div class="panel-body">
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">企业名称</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class="form-control"
						placeholder="请输入企业名称" name="companyFormMap.company_name" id="company_name">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">组织机构代码</label>
				<div class="col-sm-9">
					<input type="text" class="form-control"
						placeholder="请输入组织机构代码" name="companyFormMap.organization_code" id="organization_code">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">检验检疫代码</label>
				<div class="col-sm-9">
					<input type="text" class="form-control"
						   placeholder="请输入检验检疫代码" name="companyFormMap.inspection_code" id="inspection_code">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">法人代表</label>
				<div class="col-sm-9">
					<input type="text" class="form-control"
						   placeholder="请输入法人代表" name="companyFormMap.corporate_representative" id="corporate_representative">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">联系方式</label>
				<div class="col-sm-9">
					<input type="text" class="form-control"
						   placeholder="请输入联系方式" name="companyFormMap.contact" id="contact">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">注册地址</label>
				<div class="col-sm-9">
					<input type="text" class="form-control"
						   placeholder="请输入注册地址" name="companyFormMap.register_address" id="register_address">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">经营范围</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入经营范围"
						   name="companyFormMap.business_scope" id="business_scope">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">是否禁用</label>
				<div class="col-sm-9">
					<div class="btn-group m-r">
						<button data-toggle="dropdown"
							class="btn btn-sm btn-default dropdown-toggle">
							<span class="dropdown-label">是</span> <span class="caret"></span>
						</button>
						<ul class="dropdown-menu dropdown-select">
							<li class=""><a href="#"><input type="radio" name="companyFormMap.locked" value="0" checked="checked">是</a></li>
							<li class=""><a href="#"><input type="radio" name="companyFormMap.locked" value="1">否</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<footer class="panel-footer text-right bg-light lter">
		<button type="submit" class="btn btn-success btn-s-xs">提交</button>
		</footer> </section>
	</form>
	<script type="text/javascript">
	onloadurl();
	</script>
	<script type="text/javascript" src="${ctx}/notebook/notebook_files/bootstrap-filestyle.min.js"></script>
</body>
</html>