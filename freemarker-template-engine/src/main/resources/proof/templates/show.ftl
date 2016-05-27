<#import "lib/page.ftl" as page>
<#import "lib/fields/display.ftl" as display>
<#import "lib/fields/checkbox.ftl" as checkbox>

<@page.page>
    <section data-layout-fragment="content">
      <div class="container-fluid content">
        <section class="main">
          <h2>Show</h2>
          <#list fields as field>
          <#if field.type == "String">
            <@display.display id=field.id name=field.name />
          <#elseif field.type == "Boolean">
            <@checkbox.checkbox id=field.id name=field.name />             
          </#if>
          </#list>
        </section>
      </div>
    </section>
</@page.page>  