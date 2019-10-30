import java.util.Scanner;

public class Ordenamientos{
  public void ordena(int opc){

    Scanner datos=new Scanner(System.in);
    int tamanho,pos,aux,i,j,tempx,contA=0,contI=0,contD=0,min;
    int left,rigth,centro,inf=0,sup=0,valorBusqueda;
    Boolean sorteo=true,band,swapped=true;
    Double half;

    System.out.print("\nIngresa el tamanho del areglo: ");
    tamanho=datos.nextInt();
    int[] arreglo=new int[tamanho];
    if(opc<6){
      System.out.println("\nAsigna el valor de las casillas del arreglo.\n");
      for(i=0;i<tamanho;i++){
        System.out.print("Casilla "+(i+1)+": ");
        arreglo[i]=datos.nextInt();
      }
    }
    //En cada case se ordenaran los arreglos sin mas.
    switch(opc){
      case 1:
      int j,temp;
      boolean sorteo;
       for(int i=0;i<tamanho-1;i++){
         sorteo=true;
         for(j=tamanho-1;j>i;j--){
           if(arreglo[j]<=arreglo[j-1]){
             temp=arreglo[j];
             arreglo[j]=arreglo[j-1];
             arreglo[j-1]=temp;
             sorteo=false;
           }
         }
       }System.out.println("Arreglo Ordenado");
      break;

      case 2://Insercion
        for(i=0;i<tamanho;i++){
          pos=i;
          aux=arreglo[i];
          while(pos>0 && arreglo[pos-1]>aux){
            arreglo[pos]=arreglo[pos-1];
            pos--;
          }
          arreglo[pos]=aux;
        }
      break;

      case 3://seleccion
        for(i=0;i<tamanho;i++){
          min=i;
          for(j=i+1;j<tamanho;j++){
            if(arreglo[j]<arreglo[min]){
              min=j;
            }
          }
          if(i!=min){
            aux=arreglo[i];
            arreglo[i]=arreglo[min];
            arreglo[min]=aux;
          }
        }
      break;

      case 4:
      System.out.println("Ordenamiento por método shell");
      int salto, aux, i;
      boolean cambios;
      for(salto=arreglo.length/2; salto!=0; salto/=2){
        cambios=true;
        while(cambios){ // Mientras se intercambie algún elemento
          cambios=false;
          for(i=salto; i< arreglo.length; i++){ // se da una pasada
            if(arreglo[i-salto]>arreglo[i]){ // y si están desordenados
              aux=arreglo[i]; // se reordenan
              arreglo[i]=arreglo[i-salto];
              arreglo[i-salto]=aux;
              cambios=true; // y se marca como cambio.
            }
          }
        }
      }break;

      case 5://Cocktail shaker
        while(swapped==true){
          swapped=false;
          for(i=0;i<tamanho-1;i++){
            if(arreglo[i]>arreglo[i+1]){
              temp=arreglo[i];
              arreglo[i]=arreglo[i+1];
              arreglo[i+1]=temp;
              swapped=true;
            }
          }
          if(swapped==false)
            break;
          swapped=false;
          tamanho=tamanho-1;
          for(i=tamanho-1;i>=0;i--){
            if(arreglo[i]>arreglo[i+1]){
              temp=arreglo[i];
              arreglo[i]=arreglo[i+1];
              arreglo[i+1]=temp;
              swapped=true;
            }
          }
      }
      break;

      case 6://busuqeda
        sup=tamanho-1;
        System.out.print("Ingrese el valor que desea buscar: ");
        valorBusqueda=datos.nextInt();

        while(inf<=sup){
         centro=(sup+inf)/2;
         if(arreglo[centro]==valorBusqueda)
            pos=arreglo[centro];
         else if(valorBusqueda<arreglo[centro]){
            sup=centro-1;
         }
         else {
           inf=centro+1;
         }
        }

        System.out.println("El valor "+valorBusqueda+" se encuentra en la casilla");//Revisar, no muestra el valor
      break;

      default: System.out.println("Adios.");
     }
    if(opc<6){
      System.out.println("\nMostrando el arreglo ordenado");
      for(i=0;i<tamanho;i++){
        System.out.println("Casilla "+(i+1)+": "+arreglo[i]);
      }
    }
  }
}
