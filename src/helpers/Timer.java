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

  public List<Long> findAverageRunningTimeLong(List<List<Long>> listOfValues) {
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

  public List<Integer> findAverageIntegers(List<List<Integer>> listOfValues) {
    int totalLists = listOfValues.size();
    int totalEntries = listOfValues.get(0).size();

    List<Integer> averages = new ArrayList<>();

    for (int i = 0; i < totalEntries; i++) {
      long sum = 0;
      for (List<Integer> list : listOfValues) {
        sum += list.get(i);
      }
      double average = (double) sum / totalLists; // Use double division here
      averages.add((int) Math.round(average)); // Round to the nearest integer
    }
    return averages;
  }

  public double findAverageInt(List<Integer> list) {
    double sum = 0.0;
    for (Integer val : list) {
      sum += val;
    }
    return sum/list.size();
  }

  public double findAverageLong(List<Long> list) {
    double sum = 0.0;
    for (Long val : list) {
      sum += val;
    }
    return sum/list.size();
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
