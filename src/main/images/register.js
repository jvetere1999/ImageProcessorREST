function checkForm() {
   let      error       = false;
   let      div         = document.getElementById("formErrors");
    //ZyBook implies every soulution they come up with is the best but theyre wrong
   let      full        = document.getElementById("fullName");
   let      email       = document.getElementById("email");
   let      pass        = document.getElementById("password");
   let      passCheck   = document.getElementById("passwordConfirm");
   let ul;
   if (div.querySelector("ul")){
      ul = document.getElementById("un")
      ul.innerHTML = "";
   }
   else {
      ul = document.createElement("ul")
      ul.setAttribute("id", "un")
      div.appendChild(ul);
   }
   

   const    reFull      = /^[a-zA-Z]{1,}$/;   
   const    reEmail     = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,5}$/;
   const    rePassLen   = /^[a-zA-Z0-9]{10,20}$/;
   const    rePassUp    = /[A-Z]/
   const    rePassDown  = /[a-z]/
   const    rePassNum   = /[0-9]/
   if (!reFull.test(full.value)) { 
      
      full.classList.add("error");
      div.classList.remove("hide");
      const li = document.createElement("li")
      li.setAttribute("id", "nameError")
      li.textContent = ("Missing full name.");
      ul.appendChild(li);
      error = true;
   }
   else {
      full.classList.remove("error");
   }
  
   if (!reEmail.test(email.value)){
      email.classList.add("error");
      div.classList.remove("hide");
      const li = document.createElement("li")
      li.textContent="Invalid or missing email address.";
      ul.appendChild(li);
      error = true;
   }
   else {
      email.classList.remove("error")
   }

   if (!rePassLen.test(pass.value)) {
      pass.classList.add("error")
      div.classList.remove("hide");
      const li = document.createElement("li")
      li.textContent = ("Password must be between 10 and 20 characters.");
      ul.appendChild(li);
      error = true;
   }
   else {
      if (!(passCheck.value === pass.value) || (passCheck.value === "")) {
         
         div.classList.remove("hide");
         const li = document.createElement("li")
         pass.classList.add("error");
         passCheck.classList.add("error");
         li.textContent = ("Password and confirmation password don't match.");
         ul.appendChild(li);
         error = true;
      }
      else {

         pass.classList.remove("error");
         passCheck.classList.remove("error")
      }
      pass.classList.remove("error")
   }

   if (!rePassUp.test(pass.value)) {
      pass.classList.add("error");
      div.classList.remove("hide");
      const li = document.createElement("li")
      li.textContent = ("Password must contain at least one lowercase character.");
      ul.appendChild(li);
      error = true;
      
   }
   else {

      pass.classList.remove("error")
   }
   
    if (!rePassDown.test(pass.value)) {
     pass.classList.add("error");
      div.classList.remove("hide");
      const li = document.createElement("li")

      li.textContent = ("Password must contain at least one uppercase character.");
      ul.appendChild(li);
      error = true;
   }
   else {

      pass.classList.remove("error")
   }

   if (!rePassNum.test(pass.value)) {
       pass.classList.add("error");
      div.classList.remove("hide");
      const li = document.createElement("li")

      li.textContent=("Password must contain at least one digit.");
      ul.appendChild(li);
      error = true;
   }
   else {
      
      pass.classList.remove("error")
      
   }

   
   
   
}

document.getElementById("submit").addEventListener("click", function(event) {
   checkForm();

   // Prevent default form action. DO NOT REMOVE THIS LINE
   event.preventDefault();
});