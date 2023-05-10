<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>

    <h1> Hello ${name} </h1>

    <div><h1> List of books </h1></div>

    <#list books as b>
        <a href="/pay/${b.getId()}"><p> ${b.getName()}</a>
        <#if currentUserId == b.getUserId()>
            <a href="/edit/${b.getId()}"> EDIT </a>
        </#if>
        <#if b.available>
           - is available
        <#else>
            - is not available
        </#if>
    </#list>

</@c.page>