/**
 * MethodsProbUserInput.java
 * Calculates classical and empirical probabilities using weighted die rolls.
 */
import java.util.*;
import java.util.function.IntPredicate;

public class MethodsProbUserInput {

  // Classical probability: favorable outcomes / total outcomes
  static double classicalProb(int favorable, int total) {
    return (double) favorable / total;
  }

  // Empirical probability: count matches in trials / total trials
  static double empiricalProb(int[] trials, IntPredicate event) {
    int count = 0;
    for (int x : trials)
      if (event.test(x)) count++;
    return (double) count / trials.length;
  }

  // Weighted die roll: returns face 1..n according to weight distribution
  static int weightedRoll(int[] weights, Random rand) {
    int totalWeight = 0;
    for (int w : weights) totalWeight += w;

    int r = rand.nextInt(totalWeight) + 1;
    int cumulative = 0;

    for (int i = 0; i < weights.length; i++) {
      cumulative += weights[i];
      if (r <= cumulative) return i + 1;
    }
    return -1; // should not happen
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random(123);

    // === User Input ===
    System.out.print("Enter number of sides on the die: ");
    int dieSides = sc.nextInt();
    sc.nextLine(); // consume newline

    System.out.print("Enter event (even/odd/custom): ");
    String eventType = sc.nextLine().toLowerCase();

    System.out.print("Enter number of trials: ");
    int N = sc.nextInt();

    int[] weights = new int[dieSides];
    System.out.println("Enter weights for each face:");
    for (int i = 0; i < dieSides; i++) {
      System.out.print("Weight for face " + (i + 1) + ": ");
      weights[i] = sc.nextInt();
    }

    // === Classical Probability ===
    int favorable = 0;
    if (eventType.equals("even")) {
      favorable = dieSides / 2;
    } else if (eventType.equals("odd")) {
      favorable = dieSides - dieSides / 2;
    } else {
      System.out.print("Enter number of favorable outcomes for your custom event: ");
      favorable = sc.nextInt();
    }
    System.out.println("Classical P(" + eventType + ") on d" + dieSides + " = " +
        classicalProb(favorable, dieSides));

    // === Empirical Probability ===
    int[] trials = new int[N];
    for (int i = 0; i < N; i++) {
      trials[i] = weightedRoll(weights, rand);
    }

    double pHat = 0;
    if (eventType.equals("even")) {
      pHat = empiricalProb(trials, x -> x % 2 == 0);
    } else if (eventType.equals("odd")) {
      pHat = empiricalProb(trials, x -> x % 2 != 0);
    } else {
      System.out.print("Enter the number for your custom event: ");
      int num = sc.nextInt();
      pHat = empiricalProb(trials, x -> x == num);
    }

    // === Output ===
    System.out.println("Empirical P(" + eventType + ") from simulation ~ " + pHat);
    sc.close();
  }

}