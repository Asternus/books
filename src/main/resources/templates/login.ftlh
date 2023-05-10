<#import "parts/common.ftlh" as c>

<@c.page>
<form action="/login" method="post">
    <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Login</button>
    </div>
</form>
</@c.page>