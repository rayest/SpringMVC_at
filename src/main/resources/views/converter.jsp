<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transactional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>HttpMessageConverter</title>
</head>
<body>
<div id="response"></div>
<input type="button" onclick="response();" value="请求"/>
<script type="text/javascript" src="../assets/js/jquery.js"></script>
<script>
    function response() {
        $.ajax({
            url: "convert",
            data: "Rayest-Lee",
            type: "POST",
            contentType: "application/rayest",
            success: function (data) {
                $("#response").html(data);
            }
        });
    }
</script>
</body>
</html>