public class Main {
    public static void main(String[] args) {
        BoundedBlockingBuffer<String> B = new BoundedBlockingBuffer<String>();


        Runnable putting = new Runnable(){
            public void run() {
                String[] str = {"first","second","third"};
                for (String s : str) {
                    B.put(s);
                }
            }
        };

        Runnable taking = new Runnable(){
            public void run() {
                String taken = B.take();
                while (!taken.equals("third")) {
                    System.out.println(taken);
                    taken = B.take();
                }
                System.out.println(taken);
                
            }
        };

        Thread p = new Thread(putting,"p");
        Thread t = new Thread(taking, "t");
        p.start();
        t.start();

    }
}