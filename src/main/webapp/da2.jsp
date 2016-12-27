<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/easyui-lang-zh_CN.js"></script>
    <script>
        $(function () {
            var buttons = $.extend([], $.fn.datebox.defaults.buttons);
            buttons.splice(1, 0, {
                text: '新增',
                handler: function(target){
                    alert('新增');
                }
            });

            $('#box').datebox({
                //panelWidth : 300,
                //panelHeight : 300,
                //currentText : 'T',
                //closeText : 'C',
                //okText : 'O',
                //buttons : buttons,
                //formatter : function (date) {
                //	return date.getFullYear() + '/' + date.getMonth() + 1 + '/' + date.getDate();
                //},
                //parser : function (date) {
                //	return new Date(2015,6,1);
                //}
                //onSelect : function (date) {
                //	alert('触发！');
                //}
            });

            $('#box').datebox('calendar').calendar({
                firstDay : 1,
            });
            $('#box').datebox('setValue', '2015-6-1');
        });
    </script>
</head>
<body>
    <form  action="${pageContext.request.contextPath}/dept/string2Date.action">
        <input id="box" name="hireDate">
        <input type="submit" value="date">
    </form>

</body>
</html>