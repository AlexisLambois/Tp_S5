public class IteratorPourArrayList implements Iterator{

    ArrayList list;
    
    public IteratorPourArrayList(ArrayList list){
	this.list = list;
    }

    public E next(){
	return null;
    }

    public boolean hasNext(){
	return true;
    }

    public void remove(){

    }

}
