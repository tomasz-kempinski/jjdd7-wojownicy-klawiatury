<div id="form-container" class="container">
  <div class="col-md-8 col-md-offset-2">
    <h3>Panel administratora</h3>
    <hr>
      <#if upload??>
        <div class="alert alert-success" role="alert"><h5>Plik został przesłany!</h5></div></#if>
    <form method="POST" action="#" enctype="multipart/form-data">
      <!-- COMPONENT START -->
      <div class="form-group">
        <div class="input-group input-file" name="file">
          <input type="text" class="form-control" placeholder='Wybierz plik z dysku...'/>
          <span class="input-group-btn">
       			 <button class="btn btn-warning btn-reset" type="button">Zresetuj</button>
    		</span>
        </div>
      </div>
      <!-- COMPONENT END -->
      <div class="form-group">
        <button type="submit" class="btn btn-primary pull-right">Wyślij</button>
      </div>
    </form>
  </div>
