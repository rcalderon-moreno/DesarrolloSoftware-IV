
function cargarGet(){

        fetch('http://localhost:9090/gestion/clientes', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'X-Custom-Header': 'MiHeaderPersonalizado'
            }
        })
            .then(response => {
                console.log('🔍 Response completa:', response);
                console.log('✅ Código de estado:', response.status);
                console.log('📄 Headers:', Array.from(response.headers.entries()));
                return response.text();
            })
            .then(body => {
                console.log('🧾 Cuerpo de la respuesta (texto):', body);
            })
            .catch(error => {
                console.error('❌ Error:', error);
            });

}

cargarGet();