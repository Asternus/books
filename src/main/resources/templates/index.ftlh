<#import "parts/common.ftlh" as c>

<@c.page>

<h1> Hello User </h1>

<#list books as b>
<a href="/pay/${b.getId()}"> <p> ${b.getName()} </a>
</#list>

</@c.page>