<#import "banner.ftl" as banner>
<#import "menu.ftl" as menu>

<#macro header>
    <header role="banner">
      
      <!-- Including banner -->
      <@banner.banner />

      <!-- Including menu -->
      <@menu.menu />
      
    </header>
</#macro>