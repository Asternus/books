<#import "parts/common.ftlh" as c>

<@c.page>
    ${book!""}

    <#if book.available>
        <div class="form-row">
            <div class="form-group col-md-6">
                <form method="post" action="/payFor/${id}" class="form-inline">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary ml-2">Pay for this book</button>
                </form>
            </div>
        </div>
    <#else>
        <div>Book is not available<div>
    </#if>



</@c.page>