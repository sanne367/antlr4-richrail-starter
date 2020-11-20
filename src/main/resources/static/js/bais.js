function showtrain(){
    fetch("http://localhost:8080/alltrains")
        .then(response => response.json())
        .then(function(myJson){
            var kop = document.createElement("tr");
            kop.setAttribute("id", "kop");

            var kop1 = document.createElement("th");
            kop1.setAttribute("id", "id");
            kop1.innerHTML = "TrainID";

            var kop2 = document.createElement("th");
            kop2.setAttribute("id", "naam");
            kop2.innerHTML = "Naam";

            var kop3 = document.createElement("th");

            kop.appendChild(kop1);
            kop.appendChild(kop2);
            kop.appendChild(kop3);

            document.querySelector("#treinen").appendChild(kop);
            for(const Object of myJson){
                console.log(Object);
                var rij = document.createElement("tr");
                rij.setAttribute("id", Object.id);

                var treinId = document.createElement("td");
                var naamTekst = document.createTextNode(Object.id);
                treinId.appendChild(naamTekst);
                rij.appendChild(treinId);

                var treinNaam = document.createElement("td");
                var codeTekst = document.createTextNode(Object.name);
                treinNaam.appendChild(codeTekst);
                rij.appendChild(treinNaam);

                document.querySelector("#treinen").appendChild(rij);
            }

        });


}


function showtrainimg(){
    fetch("http://localhost:8080/alltraincomponents")
        .then(response => response.json())
        .then(function(myJson){
            for(const Object of myJson){
                console.log(Object);
                document.querySelector("#trein").innerHTML += Object.train.id;
                document.querySelector("#trein").innerHTML += '&#9822;';
                 var i = Object.quantity;
                 console.log(i);
                 while(i > 0){
                     i -= 1;
                    document.querySelector("#trein").innerHTML += '&#9898;';
                 }
            }
                
                

        
            

        });


}