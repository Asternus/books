<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="post" action="/add" class="form-inline">
                <input type="text" name="name" class="form-control" placeholder="book name">
                <input type="number" name="count" class="form-control" placeholder="count of books">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-primary ml-2">Add new book</button>
            </form>
        </div>
    </div>
</@c.page>