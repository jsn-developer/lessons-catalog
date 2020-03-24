<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>問い合わせ</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/app.css">
    <script src="../../js/jquery-3.4.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">お問い合わせ</a>
    </nav>

    <div style="height: 5em;"></div>

    <div class="container input-fields">
        <div class="row">
            <div class="col-md-3 offset-md-1 right">
                氏名
            </div>
            <div class="col-md-5">
                <input type="text" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 offset-md-1 right">
                会社名
            </div>
            <div class="col-md-5">
                <input type="text" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 offset-md-1 right">
                連絡先
            </div>
            <div class="col-md-5">
                <input type="text" class="form-control" placeholder="電話番号またはメールアドレス">
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
                <button class="btn btn-success">送信</button>
            </div>
        </div>
    </div>
</body>
</html>