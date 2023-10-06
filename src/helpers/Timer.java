package helpers;

import java.util.ArrayList;
import java.util.List;

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

  public List<Long> findAverageRunningTime(List<List<Long>> listOfValues) {
    int totalLists = listOfValues.size();
    int totalEntries = listOfValues.get(0).size();

    List<Long> averages = new ArrayList<>();

    for (int i = 0; i < totalEntries; i++) {
      long sum = 0;
      for (List<Long> list : listOfValues) {
        sum += list.get(i);
      }
      averages.add(sum / totalLists);
    }
    return averages;
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
