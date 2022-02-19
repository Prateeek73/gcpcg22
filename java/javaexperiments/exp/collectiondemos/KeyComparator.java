package exp.collectiondemos;

import java.util.*;

public class KeyComparator implements Comparator<Integer>{

@Override
public int compare(Integer key1, Integer key2){
int comp=key1-key2;
return comp;
}

}
