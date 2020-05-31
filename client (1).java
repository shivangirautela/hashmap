import java.util.HashMap;

public class client {
    public static void main(String[] args) {
      //  DynamicStack st = new DynamicStack();
        // MyQueue qu = new MyQueue();
       // for (int i = 0; i < 30; i++) {
       //     st.push(i + 100);
       // }
       // st.print();

       HashMap<String,Integer> map=new HashMap();
       map.put("abc",1000);
       map.put("asd", 1001);
       map.put("abc", 1002);
       map.put("erg", 1002);
       map.put("erg", 1003);
       map.put("erg", 11111);
       System.out.println(map);
       map.put("sd", 500);
       System.out.println(map);
    }
}