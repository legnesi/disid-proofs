<#import "head.ftl" as head>
<#import "body.ftl" as body>


<#macro page>
<!DOCTYPE html>
<html data-layout-decorator="layouts/default-layout-intranet">
    <@head.head />
    <@body.body>
        <#nested>
    </@body.body>
</html>
</#macro>