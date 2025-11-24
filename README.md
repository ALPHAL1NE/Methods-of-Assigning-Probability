# Methods of Assigning Probability

A Java program that demonstrates classical and empirical probability assignment methods using weighted die rolls.

## Overview

This project implements and compares two fundamental approaches to probability:

- **Classical Probability**: Based on theoretical, uniform outcomes (favorable outcomes / total outcomes)
- **Empirical Probability**: Based on relative frequency from simulated trials

## Features

- Supports dice with any number of sides
- Weighted die rolls for non-uniform distributions
- Three event types: even, odd, or custom
- Side-by-side comparison of classical vs empirical probabilities

## Usage

Compile and run:

```bash
javac MethodsProbUserInput.java
java MethodsProbUserInput
```

Follow the prompts to enter:
1. Number of die sides
2. Event type (even/odd/custom)
3. Number of trials to simulate
4. Weight for each die face
5. Number of favorable outcomes (for classical) and target value (for empirical)

## Example

```
Enter number of sides on the die: 6
Enter event (even/odd/custom): even
Enter number of trials: 1000
Enter weights for each face: 1 1 1 1 1 1
Classical P(even) on d6 = 0.5
Empirical P(even) from simulation ~ 0.48
```

## Files

- `MethodsProbUserInput.java` - Main program with helper methods
- `.gitignore` - Git ignore rules for compiled files
- `README.md` - This file
