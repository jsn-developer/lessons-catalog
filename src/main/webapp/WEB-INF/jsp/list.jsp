<%@ page pageEncoding="UTF-8" %>
<%@ page import="jp.co.solxyz.lessons.catalog.entity.GoodsEntity,java.util.List"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/app.css">
    <script src="./js/jquery-3.4.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>

</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">商品リスト</a>
    </nav>
    <%

    List<GoodsEntity> list = (List<GoodsEntity>)request.getAttribute("list");

    %>
    <!-- Container Zone-->
    <div class="container">
        <div class="row">
            <%
            for( GoodsEntity item : list) {
            %>
            <div class="col-md-4 col-sm-6 col-xs-12 item">
                <div class="view" 
                    style="background-image:url(./image.png)" 
                    onClick="location.href='./detail?id=<%= item.getId() %>'">
                    
                    <h2><%= item.getName() %></h2>
                    <div class="content">
                        <span><%= item.getDescription() %></span>
                    </div>
                </div>
            </div>
            <%
            }
            %>
        </div>
    </div>
    <div style="height: 5em;">
    </div>
    <script>
        // On Loaded Event
        $(()=> {
            // const _row = $('.container .row');
            // for(let i = 0; i < 13; i++) {
            //     _row.append(`
            //         <div class="col-md-4 col-sm-6 col-xs-12 item">
            //             <div class="view" style="background-image:url(${"./image.png"})" onClick="location.href='./detail'">
                            
            //                 <h2>Card ${i + 1} xxxxxxxxxxxxxxxxxxxxxxx</h2>
            //                 <div class="content">
            //                     <span>label</span>
            //                 </div>
            //             </div>
            //         </div>
            //     `);
            // }
        });
    </script>
</body>
</html>
