function randomNumber(min, max) { 
    return Math.floor(Math.random() * (max - min) + min);
} 

function calculatePercentageStep(distance, step)
{
    distance = parseInt(distance.replace("km", "")) * 1000;
    step = step * 100;
    let percentageStep = (step * 90)/distance;

    return percentageStep;
}

function hasFinished()
{
    let finished = true;

    for (let i=0; i<5; i++)
    {
        current_position = document.getElementById("player".concat(i.toString()))
        .style.left.replace("%", "");
        current_position = parseInt(current_position);

        if (current_position < 90)
        {
            finished = false;
            break;
        }
    }
    return finished;
}

let player_id = 0;
let winnersIteratorId = 0;

document.getElementById("move").addEventListener("click",function()
{
    if(hasFinished())
    {
        document.getElementById("move").setAttribute("disabled", "disabled");
        document.getElementById("status").innerText = "Juego terminado. Gracias por jugar :D [Desarrollado por Andres Mauricio Cano]"
        document.getElementById("finish").removeAttribute("hidden");
    }
    else
    {
        document.getElementById("turn").innerText = player_id.toString();
        let dado = randomNumber(1,7);
        document.getElementById("dado").innerText = dado;

        let trackElement = document.getElementById("track");
        percentageStep = calculatePercentageStep(trackElement.innerText, dado);
        let current_position;
        do
        {
            current_position = document.getElementById("player".concat(player_id.toString()))
            .style.left.replace("%", "");

            current_position = parseInt(current_position);
            if (current_position >= 90)
            {
                if (player_id < 4)
                    player_id++;
                else
                    player_id = 0;

                document.getElementById("turn").innerText = player_id.toString();
            }

        }while(current_position >= 90 && !hasFinished())

        current_position += percentageStep;

        document.getElementById("player".concat(player_id.toString()))
        .style.left = current_position.toString().concat("%");

        if (current_position >= 90)
        {
            if (winnersIteratorId < 3)
            {
                let winner = document.getElementById("driver".concat(player_id.toString()))
                .innerText;

                document.getElementById("place".concat(winnersIteratorId.toString()))
                .value = winner;

                winnersIteratorId++;
            }
        }

        if (player_id < 4)
            player_id++;
        else
            player_id = 0;
    }
})