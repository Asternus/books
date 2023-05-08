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

${error!""}

${notExist!""}

${notExist!""}

${book!""}

<div class="form-row">
    <div class="form-group col-md-6">
        <form method="post" action="/payFor/${id}" class="form-inline">
            <input type="number" name="id" class="form-control" placeholder="id">
            <button type="submit" class="btn btn-primary ml-2">Pay for this book</button>
        </form>
    </div>
</div>

</body>
</html>