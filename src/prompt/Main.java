package prompt;

class A {
    private String field = "catch me if you can";

    public A(String str){
        this.field = str;
    }

    public void reveal(A brr){
        System.out.println(brr.field);
    }
}
/*  От потомка до родительского private не добраться
class B extends A {
    public void reveal() {
        System.out.println(super.field);
    }
}
*/

public class Main {

    public static void main(String[] args) {
	A first = new A("catch me if you can");
	A second = new A("lol");

	second.reveal(first);

	// два экземпляра одного класса имеют полный достпук к private атрибутам друг друга

    }
}
