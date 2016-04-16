public class RunnableDemo {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("inside runnable");
        new Thread(r).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("inside runnable using anonymous inner class");
            }
        }).start();

        new Thread(() -> System.out.println("hello")).start();
    }
}
