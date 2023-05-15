<#import "parts/common.ftlh" as c>

<@c.page>

    <h1>Books List</h1>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <#list allBooks as book>
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.getUserId()}</td>
            </tr>
        </#list>
        </tbody>
    </table>

    <div>
        <#if currentPage?number gt 0>
            <a href="/books?page=${currentPage - 1}">Previous</a>
        </#if>

        Page ${currentPage + 1} of ${totalPages}

        <#if currentPage < totalPages - 1>
            <a href="/books?page=${currentPage + 1}">Next</a>
        </#if>
    </div>

</@c.page>