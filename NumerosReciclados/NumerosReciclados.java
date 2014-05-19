import java.io.*;

/**
 * Created by David on 18/05/14.
 */
public class NumerosReciclados {
    private BufferedReader bufer;
    private File file;
    private FileReader lector;
    private String  contenido;

    public NumerosReciclados() {
              Numero();
    }
  public void Numero(){
      String  direccion = null;
      String  datos="",Reciclar="";
      int inferior,superior,numero,reciclable = 0;

      String cambio,aux,cambio2,cambio3;
      char temp;
        try {
            bufer=new BufferedReader(new InputStreamReader(System.in));
              System.out.println("Escriba la Direccion del archivo");
              direccion= null;
              direccion = bufer.readLine();
              contenido="";
              datos=LeerArchivo(direccion);
        } catch (IOException e) {
            System.out.println("error en la lectura");
        }

try{
    String data[]=datos.split("\n");
    int tamanio= Integer.parseInt(data[0]);


    String [][]dta2=new String [tamanio][];
    for(int i=1;i<dta2.length;i++){
     //   System.out.println(data[i]+" datos");
    dta2[i]=data[i].split(" ");//separacion de numeros
     //   System.out.println((String.valueOf(dta2[i][0])+"  datos  "+dta2[i][1]));
        inferior=Integer.parseInt(dta2[i][0]);//limite1
        superior=Integer.parseInt(dta2[i][1]);//limite2

        if(inferior<superior){
            cambio=String.valueOf(inferior);//conversion de int a cadena
            temp=cambio.charAt(0);//se saco la primera posicion
            aux=cambio.substring(1,cambio.length());//este es el resto de  los otros numeros
            cambio2=aux+temp;//nuevo numero
            System.out.println(cambio2+"  el primer cambio");
            numero=Integer.parseInt(cambio2);

            while(inferior<superior){
//C:\Users\David\Documents\GitHub\ExamenFinal-1\NumerosReciclados\dataset1.txt
                if(cambio.equalsIgnoreCase(cambio2)){
                    System.out.println("El primer if");
                    inferior++;
                    cambio=String.valueOf(inferior);//conversion de int a cadena
                    //temp=cambio.charAt(0);//se saco la primera posicion
                    //aux=cambio.substring(1,cambio.length());//este es el resto de  los otros numeros
                    //cambio2=cambio;//nuevo numero
                    numero=Integer.parseInt(cambio);

                 } else if(numero>superior){
               System.out.println(numero+"  el primer if");
                    cambio3=String.valueOf(numero);//conversion de int a cadena
                    temp=cambio3.charAt(0);//se saco la primera posicion
                    aux=cambio3.substring(1,cambio3.length());//este es el resto de  los otros numeros
                    cambio2=aux+temp;//nuevo numero
                    numero=Integer.parseInt(cambio2);
                 }else if(numero<inferior){
                    System.out.println(numero+"  segundo if");
                    cambio3=String.valueOf(numero);//conversion de int a cadena
                    temp=cambio3.charAt(0);//se saco la primera posicion
                    aux=cambio3.substring(1,cambio3.length());//este es el resto de  los otros numeros
                    cambio2=aux+temp;//nuevo numero
                    numero=Integer.parseInt(cambio2);
                }
                else {//if(numero>inferior && numero<superior)
                    System.out.println(numero+"  ultimo if");
                    cambio3=String.valueOf(numero);//conversion de int a cadena
                    temp=cambio3.charAt(0);//se saco la primera posicion
                    aux=cambio3.substring(1,cambio3.length());//este es el resto de  los otros numeros
                    cambio2=aux+temp;//nuevo numero
                    System.out.println(cambio2+" este es el cambio");
                    numero=Integer.parseInt(cambio2);
                    System.out.println( "reciclable ");
                    reciclable++;
                Reciclar=Reciclar+reciclable+";";
                }

                break;
            }
        }else if(inferior==superior){
            System.out.println("Los limites son iguales");
            //son iguales y no hay reciclables
        }
        else{
            System.out.println("limite inferior es mayor que el superior");
        }
    }
   // System.out.println(data[0].length());//dice el numero de columnas
  }catch(NullPointerException es){
    System.out.println("no hay datos");
    }

        if(direccion.indexOf("dataset1")!=-1){
           String archi=direccion.replaceAll("dataset1.txt","NumerosReciclados1_201314694.txt");
            Guardar(archi,Reciclar);
            System.out.println("Archivo Guardado");
        }else if(direccion.indexOf("dataset2")!=-1){
            String archi=direccion.replaceAll("dataset2.txt","NumerosReciclados2_201314694.txt");
            Guardar(archi,Reciclar);
       }else{
            System.out.println("No hay ruta");
        }
    }

    public String  LeerArchivo(String  direc){
	 try {
         file=new File(direc);//archivo
         lector=new FileReader(file);//archivo leido
         bufer=new BufferedReader(lector);//lee linea por linea
        String  linea="";
            while((linea=bufer.readLine())!=null){
                if(contenido.length()==0){
                    contenido=linea;//entra cuando no hay nada en el contenido
                    }else{
                    contenido=contenido+"\n"+linea;//contiene los datos almacenados en el archivo
                    }
            }
         bufer.close();
         lector.close();
         return  contenido;
     }catch (Exception e){
         System.out.println(Error.class+"error");
return null;
     }
  }

    public void Guardar(String  Archivo,String datos){
FileWriter fichero;
 BufferedWriter buffer;
     PrintWriter escribir;
      try{fichero=new FileWriter(Archivo);
          buffer=new BufferedWriter(fichero);
          escribir=new PrintWriter(buffer);

          escribir.println(datos);
            escribir.close();
      }catch(Exception ex){
          System.out.println("error en escritura");
      }
    }

    public static void main(String []ar) throws IOException {
    NumerosReciclados jk= new NumerosReciclados();
   }
}
