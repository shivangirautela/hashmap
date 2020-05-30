import java.util.HashMap;
import java.util.PriorityQueue;
public class huffmaned{
   public static class Node{
       String data;
       Node left=NULL;
       Node right=NULL;
       int freq=0; 
       
       Node(String data,int freq,Node left,Node right)
       {
           this.data=data;
           this.freq=freq;
           this.left=left;
           this.right=right;
       }
    }
    static  HashMap<String,Character> decode=new HashMap<>();
    static  HashMap<Character,String> encode=new HashMap<>();
     
       public static void huffman_tree(String str)
       {
        for(int i=0;i<str.length;i++)
        {
            freq[str.charAt(i)-'a']++;
        }
        PriorityQueue<Node> pq=new PriorityQueue<Node>();
        for(int i=0;i<str.length;i++)
        {
            Node one=pq.remove();
            Node two=pq.remove();
            if(freq[i]>0)
            {
                Node node=new Node(one.data+two.data,one.freq+two.freq,null,null);
                pq.add(node);
            }
        }
        traverseTree(pq.remove()," ");
       }

       public static void traverseTree(Node node,String ans)
       {
           if(node.left==null && node.right==null)
           {
               decode.put(ans,node.data);
               encode.put(node.data,ans);
               return;
           }
           traverseTree(node.left,ans+"0");
           traverseree(node.right,ans+"1");
       }
       
       
}