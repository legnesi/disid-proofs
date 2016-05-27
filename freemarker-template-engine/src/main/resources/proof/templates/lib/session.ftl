<#macro session>
  <div class="container upper-nav navbar-fixed-top">
    <div class="session">
      <div>
        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>${r"${username}"}
      </div>
      <div>
        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>Last Access: ${r"${last_access_info}"}
      </div>
      <button type="submit" class="exit">
        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>Exit
      </button>
    </div>
  </div>
</#macro>