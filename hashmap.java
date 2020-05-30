import java.util.*;
public class hashmap{
    public class Node{
        K key;
        V val;
        Node(K key,V val)
        {
            this.key=key;
            this.val=val;
        }
        @Override
        public String to_string()
        {
            return this.key + "=" + this.value;
        } 
    }
    int size=0;
    LinkedList<Node>[] buckets=new LinkedList[10];
    hashmap()
    {
        for(int i=0;i<hm.length;i++)
        {
            buckets[i]=new LinkedList<>();
        }
    }
        @Override
        public String to_string()
        {
            StringBuilder sb=new StringBuilder();
            sb.append("{");
            for(int i=0;i< buckets.length;i++)
            {
                 if(buckets[i].size()>0)
                 {
                    int size=buckets[i].size();
                    LinkedList<Node> group= buckets[i];
                    while(size-->0)
                    {
                       Node tnode=group.getFirst();
                       sb.append(tnode.to_string()+ ",");
                       group.addLast(group.removeFirst());
                    }
                 }
            }
            sb.deleteCharAt(sb.length-1);
            sb.deleteCharAt(sb.length-1);
            sb.append("}");
            return sb.to_string();
        }
    public void put(K key,V val)
    {
        int code=myhashcode(key);
        LinkedList<Node> group=buckets[code];
        
        Node rn=foundingroup(group,key);
        if(rn!=null)
        {
            rn.val=val;
        }
        else
        {
            Node node=new Node(key,val);
            group.addFirst(node);
            this.size++;

            double lambda=group.size()* 1.0/buckets.length;
            if(lambda>=1.0)
            {
                rehash();
            }
        }
    }
    public void rehash()
    {
        LinkedList<Node>[] oldbuckets= buckets;
        buckets=new LinkedList[buckets.length *2];

        for(int i=0;i<buckets.length;i++)
        {
            buckets[i]=new LinkedList<>();
        }
        for(int i=0;i<oldbuckets.length;i++)
        {
            if(oldbuckets[i].size()>0)
            {
                int size=oldbuckets[i].size();
                LinkedList<Node> group=oldbuckets[i];
                while(size-->0)
                {
                   Node tnode=group.removeFirst();
                   put(tnode.key,tnode.val);
                }
            }
        }
    }
    public Node get(K key)
    {
       int code=myhashcode(key);
      LinkedList<Node> group=buckets[code];

      Node rn=foundingroup(group,key);
      return rn;
    }
    public boolean containskey(K key)
    {
        int code=myhashcode(key);
        LinkedList<Node> group =buckets[code];

        Node rn=foundingroup(group,key);
        return rn ? true: false;
    }
    public ArrayList<K> keyset()
    {
        ArrayList<Integer> keys=new ArrayList<>();

        for(int i=0;i<buckets.length;i++)
        {
            if(buckets[i].size()>0)
            {
                int size=buckets[i].size();
                LinkedList<Node> group=buckets[i];
                while(size-->0)
                {
                    Node tnode=group.getFirst();
                    keys.add(tnode.key);
                    group.addLast(group.removeFirst);
                }
            }
        }
        return keys;
    }
    public Node remove(K key) throws Exception{
        int code=myhashcode(key);
        LinkedList<Node> group=buckets[code];

        Node rn=foundingroup(group,key);
        if(rn !=null)
        {
           this.size--;
           return group.removeFirst();
        }
        else
        {
            throw new Exception("Element not found: -1");
        }
    }
    public Node foundingroup(LinkedList<Node> bucket,K key)
    {
      Node rn=null;
      int size=bucket.size();
      while(size-->0)
      {
          Node tnode=bucket.getFirst();
          if(tnode.key==key)
          {
              rn=tnode;
              break;
          }

          bucket.addLast(bucket.removeFirst());
      }
      return rn;
    }
    public int myhashcode(K key)
    {
        Integer code=key.hashCode();
        return abs(code) % buckets.length;
    }

}