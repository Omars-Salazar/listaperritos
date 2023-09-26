<%@include file="templates/header.jsp" %>
 
<div class ="container p-1">
    <div> <img src="imagenes/perros.jpg" alt="alt" /></div>  
    <div class="row">
        <div class="col-md-4">
            <h2>Ingrese un nuevo perro</h2>
    <form>
        <div class="mb-2">
        <label for="nombre" class="form-label">Nombre</label>
        <input type="text" class="form-control" id="nombre" aria-describedby="nombrePerros">
        <div id="nombrePerros" class="form-text"></div>
     </div>
     <div class="mb-2">
        <label for="raza" class="form-label">Raza</label>
        <input type="text" class="form-control" id="raza" aria-describedby="razaPerros">
        <div id="raza" class="form-text"></div>
     </div>
        <div class="mb-2">
        <label for="foto" class="form-label">Foto</label>
        <input type="text" class="form-control" id="foto" aria-describedby="fotoPerros">
        <div id="foto" class="form-text"></div>
     </div>
       
            <div class="mb-3">
      <label for="disabledSelect" class="form-label">Puntos</label>
      <select id="disabledSelect" class="form-select">   
            <option selected>seleccionar</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
      </select>
            </div>
        <div class="mb-2">
        <label for="edad" class="form-label">Edad</label>
        <input type="text" class="form-control" id="edad" aria-describedby="edadPerros">
        <div id="edad" class="form-text"></div>
     </div>
         <div class="mb-2">
        <label for="acciones" class="form-label">Acciones</label>
        <input type="text" class="form-control" id="acciones" aria-describedby="accionesPerros">
        <div id="acciones" class="form-text"></div>
     </div>

    
        <button type="submit" class="btn btn-primary">ingresar</button>
    </form>
        </div>
        <div class="col-md-8 " >
            <table class="table table-striped table-dark ">
                <thead> 
                    <tr>
                        <th>Nombre</th>
                        <th>Raza</th>
                        <th>Foto</th>
                        <th>Puntos</th>
                        <th>Edad</th>
                        <th>Acciones</th>
                    </tr>   
                </thead>
                <tbody>
                    <tr>
                        <td>omar</td>
                        <td>negro</td>
                        <td>img</td>
                        <td>1</td>
                        <td>19</td>
                        <td>fumar</td>
                    </tr>
                </tbody>  
            </table>

        </div>
    </div>
  </div>  
<%@include file="templates/footer.jsp" %>

