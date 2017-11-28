<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/business/inspection/list.js"></script>
	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm" name="searchForm" style="margin-top: 5px">
			<div class="form-group">
				<label class="control-label"> <span class="h4 font-thin v-middle">组织机构代码:</span></label>
				<input class="input-medium ui-autocomplete-input" id="organization_code"
					name="inspectionRecordFormMap.organization_code">
			</div>
			<div class="form-group">
				<label class="control-label"> <span class="h4 font-thin v-middle">公司名称:</span></label>
				<input class="input-medium ui-autocomplete-input" id="company_name"
					   name="inspectionRecordFormMap.company_name">
			</div>
			<div class="form-group">
				<label class="control-label"> <span class="h4 font-thin v-middle">生产批次:</span></label>
				<input class="input-medium ui-autocomplete-input" id="batch"
					   name="inspectionRecordFormMap.batch">
			</div>
			<div class="form-group">
				<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
			</div>
		</form>
	</div>
	<header class="panel-heading">
	<div class="doc-buttons">
		<c:forEach items="${res}" var="key">
			${key.description}
		</c:forEach>
	</div>
	</header>
	<div class="table-responsive">
		<div id="paging" class="pagclass"></div>
	</div>
	
	<div class="table-responsive">
		<div id="paging2" class="pagclass"></div>
	</div>
