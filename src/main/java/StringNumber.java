import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
public class StringNumber {
    private static int n;
        private static CyclicBarrier barrier = new CyclicBarrier(4);

        public static void main(String[] args) {
            n = 15;

            Thread threadA = new Thread(() -> {
                try {
                    for (int i = 1; i <= n; i++) {
                        fizz(i);
                        barrier.await();
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

            Thread threadB = new Thread(() -> {
                try {
                    for (int i = 1; i <= n; i++) {
                        buzz(i);
                        barrier.await();
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

            Thread threadC = new Thread(() -> {
                try {
                    for (int i = 1; i <= n; i++) {
                        fizzbuzz(i);
                        barrier.await();
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

            Thread threadD = new Thread(() -> {
                try {
                    for (int i = 1; i <= n; i++) {
                        number(i);
                        barrier.await();
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

            threadA.start();
            threadB.start();
            threadC.start();
            threadD.start();
        }

        public static void fizz(int num) {
            if (num % 3 == 0 && num % 5 != 0)
                System.out.print("fizz, ");
        }

        public static void buzz(int num) {
            if (num % 5 == 0 && num % 3 != 0)
                System.out.print("buzz, ");
        }

        public static void fizzbuzz(int num) {
            if (num % 3 == 0 && num % 5 == 0)
                System.out.print("fizzbuzz, ");
        }

        public static void number(int num) {
            if (num % 3 != 0 && num % 5 != 0)
                System.out.print(num + ", ");
        }
    }


