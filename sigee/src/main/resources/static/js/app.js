/*Validar Formularios*/
(() => {
  "use strict";

  const forms = document.querySelectorAll(".needs-validation");

  Array.from(forms).forEach((form) => {
    form.addEventListener(
      "submit",
      (event) => {
        if (!form.checkValidity()) {
          event.preventDefault();
          event.stopPropagation();
        }

        form.classList.add("was-validated");
      },
      false
    );
  });
})();
/*************************************************************************************************/

/*-----------------------------------------Buscar imagen-----------------------------------------*/
$(document).on("click", ".browse", function () {
  var file = $(this).parent().parent().parent().find(".file");
  file.trigger("click");
});
$('input[type="file"]').change(function (e) {
  var fileName = e.target.files[0].name;
  $("#file").val(fileName);

  var reader = new FileReader();
  reader.onload = function (e) {
    // get loaded data and render thumbnail.
    document.getElementById("preview").src = e.target.result;
  };
  // read the image file as a data URL.
  reader.readAsDataURL(this.files[0]);
});
/*************************************************************************************************/


/*-------------------------------------Validar Solo Numeros--------------------------------------*/
function soloLetras(e) {
  var key = e.keyCode || e.which,
    tecla = String.fromCharCode(key).toLowerCase(),
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz",
    especiales = [8, 37, 39, 46],
    tecla_especial = false;

  for (var i in especiales) {
    if (key == especiales[i]) {
      tecla_especial = true;
      break;
    }
  }

  if (letras.indexOf(tecla) == -1 && !tecla_especial) {
    return false;
  }
}
/*************************************************************************************************/

/*-----------------------------------Validar igual Contraseña------------------------------------*/
function verificarPasswords() {
 
  // Ontenemos los valores de los campos de contraseñas 
  pass1 = document.getElementById('pass1');
  pass2 = document.getElementById('pass2');
 
  // Verificamos si las constraseñas no coinciden 
  if (pass1.value != pass2.value) {
 
      // Si las constraseñas no coinciden mostramos un mensaje 
      document.getElementById("error").classList.add("mostrar");
 
      return false;
  } else {
 
      // Si las contraseñas coinciden ocultamos el mensaje de error
      document.getElementById("error").classList.remove("mostrar");
 
      // Mostramos un mensaje mencionando que las Contraseñas coinciden 
      document.getElementById("ok").classList.remove("ocultar");
 
      // Desabilitamos el botón de login 
      document.getElementById("login").disabled = true;
 
      // Refrescamos la página (Simulación de envío del formulario) 
      setTimeout(function() {
          location.reload();
      }, 3000);
 
      return true;
  }
 
 }
 /*************************************************************************************************/
//validar fechas
function ValidarFechas()
{
    // Ontenemos los valores de los campos de contraseñas 
    var fechaInicio = document.getElementById("fechaInicio").value;
    var fechaFin = document.getElementById("fechaFin").value;
 
  // Verificamos si las constraseñas no coinciden 
  if(Date.parse(fechaInicio) > Date.parse(fechaFin)){
 
      document.getElementById("error").classList.add("mostrar");
      return false;
  } else {
      document.getElementById("error").classList.remove("mostrar");
      document.getElementById("ok").classList.remove("ocultar");
      document.getElementById("guardar").disabled = true;
      // Refrescamos la página (Simulación de envío del formulario) 
      setTimeout(function() {
          location.reload();
      }, 3000);
      return true;
  }
}

function validar() {
        var inicio = document.getElementById('fechaInicio').value; 
        var finalq  = document.getElementById('fechaFin').value;
        inicio= new Date(inicio);
        finalq= new Date(finalq);
        if(inicio>finalq){
            window.alert("La fecha de inicio puede ser mayor que la fecha fin");
            return false;
//        alert('La fecha de inicio puede ser mayor que la fecha fin');
        }else{
            return true;
        }
}