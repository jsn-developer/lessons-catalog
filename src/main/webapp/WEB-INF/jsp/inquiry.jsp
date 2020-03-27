<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>問い合わせ</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/app.css">
    <script src="./js/jquery-3.4.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
</head>
<body>
    <%
    String message = (String)request.getAttribute("message");
    message = message == null ? "" : message;

    String name = (String)request.getAttribute("name");
    String company = (String)request.getAttribute("company");
    String contact = (String)request.getAttribute("contact");

    boolean checked = (boolean) request.getAttribute("check");

    %>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">お問い合わせ</a>
    </nav>

    <div style="height: 5em;"></div>

    <form action="inquiry" method="post">

        <input type="hidden" id="id" name="id">

        <div class="container input-fields">
            <div class="row">
                <div class="col-md-3 offset-md-1 right">
                    氏名
                </div>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="name" name="name" value="<%=name %>">
                </div>
            </div>
            <div class="row">
                <div class="col-md-3 offset-md-1 right">
                    会社名
                </div>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="company" name="company">
                </div>
            </div>
            <div class="row">
                <div class="col-md-3 offset-md-1 right">
                    連絡先
                </div>
                <div class="col-md-5">
                    <input type="text" class="form-control" placeholder="電話番号またはメールアドレス" id="contact" name="contact">
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-md-12 center">
                    <input type="checkbox" name="check" id="check" class="checkbox-inline">
                    <label for="check" style="margin:0; padding:0;">
                        規約に同意する
                    </label>
                </div>
                <div class="col-xs-12 col-sm-12 center">
                    <input type="submit" class="btn btn-success" id="submit" disabled="disabled" value="送信">
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-md-12 center">
                    <%= message %>
                </div>
            </div>
        </div>
    </form>
    <script>
        $(() => {
            $('#check').on('click', function() {
                $('#submit').prop('disabled', !$(this).is(':checked'));
            })

            <%
            if (checked) {
            %>
                $('#check').prop('checked', true);
            <%
            } 
            %>

            // setTimeout(()=>{
                $('#submit').prop('disabled', !$('#check').is(':checked'));
            // }, 100);
        })
    </script>
</body>
</html>
