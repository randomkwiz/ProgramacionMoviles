package es.iesnervion.avazquez.sharedpreferencespiedrapapeltijeras;

public class Util {

    public String randomGame(){
        // define the range
        int max = 3;
        int min = 1;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;
        String resultado = "";
        switch (rand){
            case 1:
                resultado = "rock";
                break;
            case 2:
                resultado = "paper";
                break;
            case 3:
                resultado = "scissors";
                break;
        }

            return resultado;
    }

    /*
        -1 -gana la maquina
        0 - empate
        1 - gana el jugador
     */
    public int evalGame(String maquina, String jugador){
        int resultado = 0;
        if(maquina.equals("rock")){
            switch (jugador){
                case "rock":
                    resultado = 0;
                    break;
                case "paper":
                    resultado = 1;
                    break;
                case "scissors":
                    resultado = -1;
                    break;
            }

        }else if(maquina.equals("paper")){
            switch (jugador){
                case "rock":
                    resultado = -1;
                    break;
                case "paper":
                    resultado = 0;
                    break;
                case "scissors":
                    resultado = 1;
                    break;
            }
        }else{
            switch (jugador){
                case "rock":
                    resultado = 1;
                    break;
                case "paper":
                    resultado = -1;
                    break;
                case "scissors":
                    resultado = 0;
                    break;
            }

        }


        return resultado;
    }
}
