<#import "footer.ftl" as footer>
<#import "session.ftl" as session>
<#import "header.ftl" as header>

<#macro body>
<body>

  <!-- Include user session information -->
  <@session.session />

  <div class="container bg-container">

    <!-- Include header -->
    <@header.header />
    
    <!-- Include content -->
    <#nested>
    
  </div>
  
  <@footer.footer />
  
 </body>
</#macro>