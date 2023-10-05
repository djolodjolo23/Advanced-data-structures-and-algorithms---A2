package helpers;

public class Timer{
  private long startTime;
  private long endTime;

  private long elapsedTime;


  public String timeItString(MyMethod method) {
    start();
    method.execute();
    stop();
    elapsedTime = getElapsedTime();
    return toString();
  }

  public long timeItNanoTime(MyMethod method) {
    start();
    method.execute();
    stop();
    return getElapsedTime();
  }

  private void start() {
    startTime = System.nanoTime();
  }

  private void stop() {
    endTime = System.nanoTime();
  }

  private long getElapsedTime() {
    if (startTime != 0 && endTime != 0) {
      return endTime - startTime;
    } else {
      throw new IllegalStateException("Timer not started or stopped correctly.");
    }
  }

  private long findAverageRunningTime(long[] times) {
    long avg = 0;
    int avg_counter = 0;
    for (long t : times) {
      avg += t;
      avg_counter += 1;
    }
    return avg / avg_counter;
  }


  @Override
  public String toString() {
    long milliseconds = elapsedTime / 1_000_000;
    long microseconds = (elapsedTime % 1_000_000) / 1_000;
    long nanoseconds = elapsedTime % 1_000;
    return
        "Elapsed time = " + milliseconds + "ms, " +
        microseconds + " µs, " +
        nanoseconds + " ns.";
  }


}
