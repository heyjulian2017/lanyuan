<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@include file="/common/common.jspf" %>
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
<div style="width:60%;margin: 10px auto">
    <div class="l_err" style="width: 100%; margin-top: 2px;"></div>
    <form id="form" name="form" class="form-horizontal" method="post" action="">
        <section class="panel panel-default">
            <div class="panel-body">
                <div class="form-group">
                    <div class="col-sm-3">
                        <label class="control-label">条形码</label>
                    </div>
                    <div class="col-sm-9">
                        <input type="text" class="form-control"
                               name="barcode" id="barcode">
                    </div>
                </div>
                <div class="line line-dashed line-lg pull-in"></div>
            </div>
            <footer class="panel-footer text-right bg-light lter">
                <button type="submit" class="btn btn-success btn-s-xs">提交</button>
            </footer>
        </section>
    </form>
</div>
<script type="text/javascript">
    onloadurl();
</script>
<script type="text/javascript" src="${ctx}/notebook/notebook_files/bootstrap-filestyle.min.js"></script>
</body>
</html>