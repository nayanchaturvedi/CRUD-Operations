let create_form = document.getElementById('create-validation');
let update_form = document.getElementById('update-validation');
let read_form = document.getElementById('read-validation');

create_form.onsubmit = async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (create_form.checkValidity() === true) {
        let form_data = new FormData();
        form_data.append('description', document.getElementById('description').value);
        form_data.append('amount', document.getElementById('amount').value);
        form_data.append('date', document.getElementById('date').value);
        form_data.append('status', document.getElementById('status').value);
        // $.ajax({
        //   type: "POST",
        //   url: "api/courses/register",
        //   enctype: 'multipart/form-data',
        //   data: form_data,
        //   processData: false,
        //   contentType: false,
        // }).done(function(response, status) {
        //   console.log(response, status);
        // });
        let response = await fetch('api/operation/create', {
            method: 'POST',
            body: form_data
        });
        let result = await response;
        if (result['status'] === 200) {
            document.getElementById("give_create_status").innerHTML = "Successful";
        } else {
            document.getElementById("give_create_status").innerHTML = "Failed";
        }
        console.log(result);
    } else {
        create_form.classList.add('was-validated');
    }
};

update_form.onsubmit = async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (read_form.checkValidity() === true) {
        let form_data = new FormData();
        form_data.append('student_id', document.getElementById('student_id').value);
        form_data.append('new_amount', document.getElementById('new_amount').value);
        form_data.append('new_status', document.getElementById('new_status').value);
        // $.ajax({
        //   type: "POST",
        //   url: "api/courses/register",
        //   enctype: 'multipart/form-data',
        //   data: form_data,
        //   processData: false,
        //   contentType: false,
        // }).done(function(response, status) {
        //   console.log(response, status);
        // });
        let response = await fetch('api/operation/update', {
            method: 'POST',
            body: form_data
        });
        let result = await response;
        console.log(result);
        if (result['status'] === 200) {
            // document.getElementById("course-success").style.display = "none";
            // document.getElementById("course-alert").style.display = "block";
            document.getElementById("give_update_status").innerHTML = "Successful";
        } else {
            // document.getElementById("course-alert").style.display = "none";
            // document.getElementById("course-success").style.display = "block";
            document.getElementById("give_update_status").innerHTML = "Failed";
        }
    } else {
        create_form.classList.add('was-validated');
    }
};
read_form.addEventListener("submit", async (e) => {
    e.preventDefault();
    e.stopPropagation();

    // const email = signin_form.email.value;
    // const password = signin_form.inputPassword.value;
    let response = await fetch('api/operation/read', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            bill_id: document.getElementById('bill_id_read').value
        })
    });
    window.sessionStorage["curr_session"] = document.getElementById('bill_id_read').value;
    let result = await response;
    console.log(response);

    if(result['status'] === 200){
        document.getElementById("give_read_status").innerHTML = "Successful!!";
    }
    else{
        document.getElementById("give_read_status").innerHTML = "Failed!!";
    }
});

// let create_form = document.getElementById('create-validation');
//
// create_form.addEventListener('submit', async (e) => {
//   e.preventDefault();
//   e.stopPropagation();
//   if (create_form.checkValidity() === true) {
//     let response = await fetch('api/operation/create', {
//       method: 'POST',
//       headers: {
//           'Content-Type': 'application/json;charset=utf-8'
//       },
//       body: JSON.stringify({
//           description: document.getElementById('description').value,
//           amount: document.getElementById('amount').value,
//           date: document.getElementById('date').value,
//           status: document.getElementById('status').value
//       })
//     });
//       window.sessionStorage["curr_bill"] = document.getElementById('description').value;
//       let result = await response;
//     console.log(result);
//       if(result['status'] === 200){
//           // let data = response.json();
//           document.getElementById("give_status").innerHTML = "Successful";
//       }
//       else{
//           document.getElementById("give_status").innerHTML = "Failed";
//       }
//   }
//   create_form.classList.add('was-validated');
// });

// create_form.addEventListener('submit', async (e) => {
//     e.preventDefault();
//     e.stopPropagation();
//     if (create_form.checkValidity() === true) {
//         let response = await fetch('api/operation/create', {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json;charset=utf-8'
//             },
//             body: JSON.stringify({
//                 description: document.getElementById('description').value,
//                 amount: document.getElementById('amount').value,
//                 date: document.getElementById('date').value,
//                 status: document.getElementById('status').value,
//             })
//         });
//         let result = await response;
//         console.log(result);
//     }
//     create_form.classList.add('was-validated');
// });