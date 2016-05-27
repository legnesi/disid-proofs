<#macro menu>
      <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
              data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
              aria-expanded="false">
              <span class="sr-only">Desplegable</span> <span class="icon-bar"></span> <span
                class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Menú principal</a>
          </div>
          <div id="bs-example-navbar-collapse-1" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Menú 1 activo</a></li>
              <li><a href="#">Menú 2</a></li>
              <li class="dropdown"><a href="#" class="dropdown-toggle"
                data-toggle="dropdown" role="button" aria-haspopup="true"
                aria-expanded="false">Menú 3 desplegable<span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Submenú 1</a></li>
                  <li><a href="#">Submenú 2</a></li>
                  <li><a href="#">Submenú 3</a></li>
                </ul></li>
            </ul>
          </div>
        </div>
      </nav>
</#macro>