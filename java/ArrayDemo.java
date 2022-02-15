class ArrayDemo{

public static void main(String args[]){

int array[]=new int[3];

array[0]=10;
array[1]=11;
array[2]=12;

int length=array.length;
for(int i=0;i<length;i++){
int iteratedElement=array[i];
System.out.println(iteratedElement);
}

}

}
