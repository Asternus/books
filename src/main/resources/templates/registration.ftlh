<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<div class="form-row">
    <div class="form-group col-md-6">
        <form method="post" action="/registration" class="form-inline">
            <input type="text" name="username" class="form-control" placeholder="username">
            <input type="password" name="password" class="form-control" placeholder="user password">
            <input type="email" name="email" class="form-control" placeholder="email">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn btn-primary ml-2">Save</button>
        </form>
    </div>
</div>

</body>
</html>