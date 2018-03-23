package dictionnaire;
import java.util.Iterator;
public class DictIterator<K> implements Iterator<K>{

	private TabDict<K,?> t;
	private int index;

	public DictIterator(TabDict<K,?> t){
		this.t = t;
		this.index = 0;
	}

	public boolean hasNext(){
		return t.nbElements() != index;
	}

	public K next(){
		K tmp = t.clefPourIndex(index);
		index++;
		return tmp;
	}

	public void remove(){
		t.remove(index);
	}
}
