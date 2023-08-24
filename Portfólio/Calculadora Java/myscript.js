function insert(num) {
    var numero = document.getElementById('visor').innerHTML;
    document.getElementById('visor').innerHTML = numero + num;
}

function clean() {
    document.getElementById('visor').innerHTML = "";
}

function calcular() {
    var visor = document.getElementById('visor').innerHTML;
    if (visor) {
        document.getElementById('visor').innerHTML = eval(visor);
    }

}