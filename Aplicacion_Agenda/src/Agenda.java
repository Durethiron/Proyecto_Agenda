/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bienvenidos
 */
public class Agenda {
    private int año;
    
    private Pagina[] paginas;
    public Pagina abierta;
    
    Agenda (int año){
        this.año = año;
        if (año % 4==0){
            inicializa(true);
        }else{
            inicializa(false);
        }
    }
    
    private void inicializa(boolean b){
        this.paginas= new Pagina[b ? 366 : 365];
        int dia = 0;
        for(int i=1; i<=31; i++){
            paginas[dia++] = new Pagina(i , 1);
        }
        for(int i=1; i<=(b ? 29 : 28); i++){
            paginas[dia++] = new Pagina(i , 2);
        }
        for(int i=1; i<=31; i++){
            paginas[dia++] = new Pagina(i , 3);
        }
        for(int i=1; i<=30; i++){
            paginas[dia++] = new Pagina(i , 4);
        }
        for(int i=1; i<=31; i++){
            paginas[dia++] = new Pagina(i , 5);
        }
        for(int i=1; i<=30; i++){
            paginas[dia++] = new Pagina(i , 6);
        }
        for(int i=1; i<=31; i++){
            paginas[dia++] = new Pagina(i , 7);
        }
        for(int i=1; i<=31; i++){
            paginas[dia++] = new Pagina(i , 8);
        }
        for(int i=1; i<=30; i++){
            paginas[dia++] = new Pagina(i , 9);
        }
        for(int i=1; i<=31; i++){
            paginas[dia++] = new Pagina(i , 10);
        }
        for(int i=1; i<=30; i++){
            paginas[dia++] = new Pagina(i , 11);
        }
        for(int i=1; i<=31; i++){
            paginas[dia++] = new Pagina(i , 12);
        }
    }
    
    public Pagina buscarPagina(int dia, int mes){
        Pagina busqueda = null, temp;
        int cont = 0;
        boolean encontrado = false;
        
        while (cont < paginas.length && encontrado == false){
            temp = paginas[cont++];
            if(temp.getDia() == dia && temp.getMes() == mes){
                busqueda = temp;
                encontrado = true;
            }
        }
        return busqueda;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Pagina[] getPaginas() {
        return paginas;
    }

    public void setPaginas(Pagina[] paginas) {
        this.paginas = paginas;
    }

    public Pagina getAbierta() {
        return abierta;
    }

    public void setAbierta(Pagina abierta) {
        this.abierta = abierta;
    }
    
    
}
