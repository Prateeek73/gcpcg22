package exp.genericdemo;

public class Store<T>{
   private  T  element;


   void add(T element){
   this.element=element;
   }
   
   public T getElement(){
    return element;
   }
   

}
