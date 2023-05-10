<#import "parts/common.ftlh" as c>

<@c.page>

    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="post" action="/registration" class="form-inline">
                <input type="text" name="username" class="form-control" placeholder="username">
                <input type="password" name="password" class="form-control" placeholder="user password">
                <input type="email" name="email" class="form-control" placeholder="email">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-primary ml-2">Save</button>
            </form>
        </div>
    </div>

</@c.page>