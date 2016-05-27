<#macro head>
<head lang="es">
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" 
        content="Spring Roo Application" data-th-attr="content=${r"|#{application_description}|"}"/>
    
    <title data-th-text="${r"|#{text_show}|"}">Show Entity</title>
    
    <!-- CSS -->
    <link data-th-href="@{/css/bootstrap-intranet.min.css}" data-th-remove="all"
      href="../../static/css/bootstrap-intranet.min.css" rel="stylesheet" />
    <link data-th-href="@{/css/sanidad-intranet.css}" data-th-remove="all"
      href="../../static/css/sanidad-intranet.css" rel="stylesheet" />
    <noscript>
      <link data-th-href="@{/css/nojs-sanidad-intranet.css}" data-th-remove="all"
        href="../../static/css/nojs-sanidad-intranet.css" rel="stylesheet" />
    </noscript>
    <!--[if IE 8 ]> <html class="ie8" lang="es"/> <![endif]-->
    <!--[if lt IE 9]><script data-th-remove="all" data-th-src="@{/js/html5shiv.min.js}" src="../../static/js/html5shiv.min.js"></script><![endif]-->

</head>
</#macro>
