
    function jquery1(){
        $("#cargar").on('click',function() {
            $.get("https://jsonplaceholder.typicode.com/posts/1", function(data) {
                $("#resultado").html(`<h3>${data.title}</h3><p>${data.body}</p>`);
            });
        });
    }
    function  jquery2(){

        $("#miFormulario").submit(function(e) {
            e.preventDefault(); // Evita que se recargue la página
            $.post("https://jsonplaceholder.typicode.com/posts", $(this).serialize(), function(data) {
                $("#respuesta").html(`Formulario enviado. ID generado: ${data.id}`);
            });
        });
    }

