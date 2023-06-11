import java.util.Timer;
import java.util.TimerTask;
public class Time {
    private static Timer timer;

        public static void main(String[] args) {
            timer = new Timer();

            // Запускаем поток для отображения времени каждую секунду
            timer.scheduleAtFixedRate(new TimeTask(), 0, 1000);

            // Запускаем поток для вывода сообщения каждые 5 секунд
            timer.scheduleAtFixedRate(new MessageTask(), 0, 5000);
        }

        private static class TimeTask extends TimerTask {
            private long startTime = System.currentTimeMillis();

            @Override
            public void run() {
                long elapsedTime = System.currentTimeMillis() - startTime;
                System.out.println("Прошло " + (elapsedTime / 1000) + " секунд");
            }
        }

        private static class MessageTask extends TimerTask {
            @Override
            public void run() {
                System.out.println("Прошло 5 секунд");
            }
        }
    }

