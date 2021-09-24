public class BoundedBlockingBuffer<T> {
    private T data;
    

    public synchronized void put(T data) {
        if (this.data != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.data=data;
        notifyAll();
    }


    public synchronized T take(){
        if (this.data == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T temp=this.data;
        this.data=null;
        notifyAll();
        return temp;
    }
}
