
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bienvenidos
 */
public class Aplicacion_Agenda {

    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        Calendar fecha;
        int opcion;
        Agenda agenda;
        Pagina pagina;
        Cita cita;
        int hora, minutos, dia, mes, año;
        String texto, titulo;
        
        
        System.out.println("En que año estara ubicada la agenda?");
        año=teclado.nextInt();
        agenda=new Agenda(año);
        System.out.println("\n\n"+"*********CITAS****DEL****"+agenda.getAño()+"*********");
        
        int elec;
        do {
            verMenu();
            elec = teclado.nextInt();
            
            switch (elec) {
                case 1:
                    //Añadir los metodos para validar que el dia y el mes son correctos(Crear metodos!!(Estaticos en Aplacacion_Agenda))
                    System.out.print("Introduce dia: ");
                    dia=teclado.nextInt();
                    System.out.print("Introduce mes: ");
                    mes=teclado.nextInt();
                    agenda.abierta=agenda.buscarPagina(dia, mes);
                    System.out.println("La pagina seleccionada es: "+agenda.abierta.getDia()+" del mes "+agenda.abierta.getMes());
                    
                    break;
                case 2:
                    //Validar horas y minutos
                    System.out.print("Introduca hora: ");
                    hora=teclado.nextInt();
                    System.out.print("Introduce minutos: ");
                    minutos=teclado.nextInt();
                    System.out.print("Introduce titulo: ");
                    titulo=teclado.next();
                    System.out.println("Introduce texto: ");
                    texto=teclado.next();
                    //confirmar si la hora de la cita esta ya ocupada
                    cita=new Cita(hora, minutos, titulo, texto);
                    agenda.abierta.añadirCita(cita);
                    agenda.abierta.leerPagina();
                    
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        } while (elec != 0);      
    }
    public static void verMenu() {
        System.out.println("****************MENU****************");
        System.out.println("1. Selecciona una página");
        System.out.println("2. Crea una cita");
        
        System.out.println("0. Salir");
        System.out.println("************************************");
    }

}
