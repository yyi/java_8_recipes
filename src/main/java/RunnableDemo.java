public class RunnableDemo {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("inside runnable using a lambda");
        new Thread(r).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("inside runnable using anonymous inner class");
            }
        }).start();

        new Thread(() -> System.out.println("inside Thread as arg")).start();
    }
}
