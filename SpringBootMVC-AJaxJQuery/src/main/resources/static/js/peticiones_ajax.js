

function cargar1(){
    const client = new XMLHttpRequest();
    client.addEventListener("readystatechange", () => {
        if (client.readyState === 4 && client.status === 200)
            //console.log("valores-->"+client.responseText);
            document.getElementById('respuesta_html').value=client.responseText;
        else
            console.log("Error-->"+client.statusText);
    });


    client.open("GET", "http://localhost:9090/listado");
    client.send();
}

function cargar2(){
    var client = new XMLHttpRequest();
    client.open('POST', 'http://localhost:9090/ingresar_detalle', true);
    client.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    // Obtener los datos del formulario
    var nombre = "JUAN";
    var mensaje = "123" ;
    var datos = 'nombres=' + nombre + '&apellidos=' + mensaje;

    client.onload = function() {
        if (client.status === 200) {
            //console.log("valores-->"+xhr.responseText);
            document.getElementById('respuesta_html').value=client.responseText;
        } else {
            console.error('Error en la solicitud');
        }
    };
    client.send(datos); // Envía los datos al servidor
}


function cargar3() {
    const datos = new URLSearchParams();
    datos.append("nombres", "JUAN");
    datos.append("apellidos", "123");

    fetch('http://localhost:9090/ingresar_detalle', {
        method: 'POST',
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: datos.toString()
    })
        .then(res => res.text())
        .then(data => {
            //console.log("Respuesta del servidor:", data);
            document.getElementById('respuesta_html').value = data;
        })
        .catch(error => {
            console.error("Error en la solicitud:", error);
        });

}


