<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${ctx}/js/business/barCode/add.js" />
<script>
    $("#package_type").change(function(){
        var packageType = $("#package_type").val();
        if(packageType=="0"){
            $("#package_material").empty();
            $("#package_cover").empty();
        }
        else if(packageType=="1") {
            var content_1 =  "<option value=''>请选择</option>"+
                    "<option value='A'>钢</option>" +
                    "<option value='B'>铝</option>" +
                    "<option value='D'>胶合板</option>" +
                    "<option value='G'>纤维板</option>" +
                    "<option value='H'>塑料</option>" +
                    "<option value='N'>金属（除钢、铝）</option>";
            $("#package_material").html(content_1);
            $("#package_cover").empty();
        }
        else if(packageType=="3") {
            var content_3 = "<option value=''>请选择</option>"+
                    "<option value='A'>钢</option>" +
                    "<option value='B'>铝</option>" +
                    "<option value='H'>塑料</option>";
            $("#package_material").html(content_3);
            $("#package_cover").empty();

        }
        else if(packageType=="4") {
            var content_4 = "<option value=''>请选择</option>"+
                    "<option value='A'>钢</option>" +
                    "<option value='B'>铝</option>" +
                    "<option value='C'>天然木</option>" +
                    "<option value='D'>胶合板</option>" +
                    "<option value='F'>再生木</option>" +
                    "<option value='G'>纤维板</option>" +
                    "<option value='H'>塑料</option>";
            $("#package_material").html(content_4);
            $("#package_cover").empty();
        }
        else if(packageType=="5") {
            var content_5 = "<option value=''>请选择</option>"+
                    "<option value='H'>编制塑料</option>" +
                    "<option value='L'>纺织品</option>" +
                    "<option value='M'>纸</option>";
            $("#package_material").html(content_5);
            $("#package_cover").empty();
        }
        else if(packageType=="6") {
            var content_6 = "<option value=''>请选择</option>"+
                    "<option value='H'>塑料贮器</option>";
            $("#package_material").html(content_6);
            $("#package_cover").empty();
        }
    });

    $("#package_material").change(function(){
        var packageType = $("#package_type").val();
        var package_material = $("#package_material").val();
        if(packageType=="1"){
            if(package_material=="A"||package_material=="B"||package_material=="H"||package_material=="N"){
                var content_1_1 = "<option value=''>请选择</option>"+
                        "<option value='1'>非活动盖</option>"+
                        "<option value='2'>活动盖</option>";
                $("#package_cover").html(content_1_1);
            }
            else if(package_material=="D"){
                 var content_1_2 = "<option value=''>请选择</option>"+
                        "<option value=''>无</option>";
                 $("#package_cover").html(content_1_2);
            }
            else if(package_material=="G"){
                var content_1_3 = "<option value=''>请选择</option>"+
                        "<option value=''>无</option>";
                        $("#package_cover").html(content_1_3);
            }
        }
        if(packageType=="3"){
            if(package_material=="A"||package_material=="B"||package_material=="H"){
                var content_2_1 = "<option value=''>请选择</option>"+
                        "<option value='1'>非活动盖</option>"+
                        "<option value='2'>活动盖</option>";
                $("#package_cover").html(content_2_1);
            }
        }
        if(packageType=="4"){
            if(package_material=="C"){
                var content_4_1 = "<option value=''>请选择</option>"+
                        "<option value='1'>普通箱壁</option>"+
                        "<option value='2'>防筛漏</option>";
                $("#package_cover").html(content_4_1);
            }
            else if(package_material=="A"||package_material=="B"||package_material=="D"||package_material=="F"||package_material=="G"){
                var content_4_3 = "<option value=''>请选择</option>"+
                        "<option value=''>无</option>";
                $("#package_cover").html(content_4_3);
            }
            else if(package_material=="H"){
                var content_4_2 = "<option value=''>请选择</option>"+
                        "<option value='1'>泡沫</option>"+
                        "<option value='2'>硬的</option>";
                $("#package_cover").html(content_4_2);
            }
        }
        if(packageType=="5"){
            if(package_material=="H"||package_material=="L"){
                var content_5_1 = "<option value=''>请选择</option>"+
                        "<option value='1'>无内衬或涂层</option>"+
                        "<option value='2'>防筛漏</option>"+
                        "<option value='3'>防水</option>";
                $("#package_cover").html(content_5_1);
            }
            else if(package_material=="A"||package_material=="B"||package_material=="D"||package_material=="F"||package_material=="G"){
                var content_5_2 = "<option value=''>请选择</option>"+
                        "<option value=''>无</option>";
                        $("#package_cover").html(content_5_2);
            }
            else if(package_material=="M"){
                var content_5_3 = "<option value=''>请选择</option>"+
                        "<option value=''>无</option>";
                        $("#package_cover").html(content_5_3);
            }
        }
        if(packageType=="6") {
            var content_6_1 = "<option value=''>请选择</option>"+
                    "<option value='A1'>在钢桶中</option>"+
                    "<option value='A2'>在钢板条箱或钢箱中</option>"+
                    "<option value='B1'>在铝桶中</option>"+
                    "<option value='B2'>在铝板条箱或铝箱中</option>"+
                    "<option value='C'>在木箱中</option>"+
                    "<option value='D1'>在胶合板桶中</option>"+
                    "<option value='D2'>在胶合板箱中</option>"+
                    "<option value='G1'>在纤维纸桶中</option>"+
                    "<option value='G2'>在纤维板箱中</option>"+
                    "<option value='H1'>在塑料桶中</option>"+
                    "<option value='H2'>在硬塑料箱中</option>";
            $("#package_cover").html(content_6_1);
        }

        $("#package_cover").change(function(){
            var package_code = $("#package_type").val()+$("#package_material").val()+$("#package_cover").val();
            $("#package_code").val(package_code);
        });
    });
</script>
<div style="width:60%;margin: 10px auto">
    <div class="l_err" style="width: 100%; margin-top: 2px;"></div>
    <form id="form" name="form" class="form-horizontal" method="post"
          action="barcode/generateBarcode.shtml">
        <section class="panel panel-default">
            <div class="panel-body">
                <div class="form-group">
                    <label class="col-sm-3 control-label">企业组织机构代码</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control"
                               placeholder="请输入企业组织机构代码" name="organization_code" id="organization_code">
                    </div>
                </div>
                <div class="line line-dashed line-lg pull-in"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">生产批次</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control"
                               placeholder="请输入生产批次" name="batch" id="batch">
                    </div>
                </div>
                <div class="line line-dashed line-lg pull-in"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">数量</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control"
                               placeholder="请输入产品数量" name="quantity" id="quantity">
                    </div>
                </div>
                <div class="line line-dashed line-lg pull-in"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">包装种类</label>
                    <div class="col-sm-9">
                        <select id="package_type" name="package_type" class="form-control m-b">
                            <option value="0">请选择</option>
                            <option value="1">桶</option>
                            <option value="3">罐</option>
                            <option value="4">箱</option>
                            <option value="5">袋</option>
                            <option value="6">复合容器</option>
                        </select>
                    </div>
                </div>
                <div class="line line-dashed line-lg pull-in"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">包装材料</label>
                    <div class="col-sm-9">
                        <select id="package_material" name="package_material" class="form-control m-b">
                        </select>
                    </div>
                </div>
                <div class="line line-dashed line-lg pull-in"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">盖子类别</label>
                    <div class="col-sm-9">
                        <select id="package_cover" name="package_cover" class="form-control m-b">
                        </select>
                    </div>
                </div>
                <div class="line line-dashed line-lg pull-in"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">生成的包装码</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control"
                               placeholder="可通过上方选项选择或手动输入" name="package_code" id="package_code">
                    </div>
                </div>
            <footer class="panel-footer text-right bg-light lter">
                <button type="submit" class="btn btn-success btn-s-xs">生成条形码</button>
            </footer>
            <%--<div class="line line-dashed line-lg pull-in"></div>--%>
                <%--<div class="form-group">--%>
                    <%--<label class="col-sm-3 control-label">生产批次格式说明</label>--%>
                    <%--<div class="col-sm-9">--%>
                        <%--编码规则：A+B+C+D--%>
                        <%--<br />--%>
                        <%--A：年    （四位数 格式 2016）--%>
                        <%--<br />--%>
                        <%--B：月    （两位数 格式 01）--%>
                        <%--<br />--%>
                        <%--C：日    （两位数 格式 30）--%>
                        <%--<br />--%>
                        <%--D：批次  （三位数 格式 001）--%>
                    <%--</div>--%>
                <%--</div>--%>
        </section>
    </form>
</div>
