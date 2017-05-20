/**
 * Created by Klaudia on 2017-05-19.
 */

import java.util.Scanner;
public class Init {

        public Init() {
            Scanner input = new Scanner(System.in);
            System.out.println("Aby zakończyć działanie programu wpisz polecenie: exit i zatwierdz ENTEREM");
            String value = input.nextLine();
            if(value.equals("exit")) {
                System.out.println("Program zakończył działanie");
            } else {
                new Init();
            }

        }
}

