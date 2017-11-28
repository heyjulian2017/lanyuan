var pageii = null;
var grid = null;
$(function() {
	
	grid = lyGrid({
		pagId : 'paging',
		l_column : [ {
			colkey : "id",
			name : "id",
			hide:true
		}, {
			colkey : "organization_code",
			name : "组织机构代码",
			//isSort:true,
			width : '120px',
		}, {
			colkey : "company_name",
			name : "企业名称",
			//isSort:true,
			width : '150px',
		}, {
			colkey : "corporate_representative",
			name : "法人代表",
			width : '100px',
		}, {
			colkey : "register_address",
			name : "注册地址",
		}, {
			colkey : "contact",
			name : "联系方式",
			width : '150px',
		},  {
			colkey : "business_scope",
			name : "经营范围"
		},{
			colkey : "locked",
			name : "是否禁用",
			renderData : function(rowindex, data, rowdata, column) {
				if(data=="0"){
					return "是";
				}else if(data=="1"){
					return "否";
				}
			}
		},{
			colkey : "create_time",
			name : "录入时间",
			isSort:true,
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		//}, {
		//	name : "操作",
		//	renderData : function( rowindex ,data, rowdata, colkeyn) {
		//		return "测试渲染函数";
		//	}
		} ],
		jsonUrl : rootPath + '/company/findByPage.shtml?locked=1',
		checkbox : true,
		serNumber : false
	});
	$("#search").click("click", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		grid.setOptions({
			data : searchParams
		});
	});
	$("#addCompany").click("click", function() {
		addCompany();
	});
	$("#editCompany").click("click", function() {
		editCompany();
	});
	$("#delCompany").click("click", function() {
		delCompany();
	});
});
function editCompany() {
	var cbox = grid.getSelectedCheckbox();
	if (cbox.length > 1 || cbox == "") {
		layer.msg("只能选中一个");
		return;
	}
	pageii = layer.open({
		title : "编辑",
		type : 2,
		area : [ "600px", "80%" ],
		content : rootPath + '/company/editUI.shtml?id=' + cbox
	});
}
function addCompany() {
	pageii = layer.open({
		title : "新增",
		type : 2,
		area : [ "600px", "80%" ],
		content : rootPath + '/company/addUI.shtml'
	});
}
function delCompany() {
	var cbox = grid.getSelectedCheckbox();
	if (cbox == "") {
		layer.msg("请选择删除项！！");
		return;
	}
	layer.confirm('是否删除？', function(index) {
		var url = rootPath + '/company/deleteEntity.shtml';
		var s = CommnUtil.ajax(url, {
			ids : cbox.join(",")
		}, "json");
		if (s == "success") {
			layer.msg('删除成功');
			grid.loadData();
		} else {
			layer.msg('删除失败');
		}
	});
}