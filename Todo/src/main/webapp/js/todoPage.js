$('#date_term').datepicker({
    format : 'yyyy/mm/dd'
});

const form = document.getElementById("form");

const button = document.getElementById("button");

form.addEventListener("input", update);
form.addEventListener("textarea", update);


function update() {
    const isRequired = form.checkValidity();
    if (isRequired) {
        button.disabled = false;
        return;
    }else{
        button.disabled = true;
        return;
    }
}


