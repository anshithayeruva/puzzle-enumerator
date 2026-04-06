Puzzle Enumerator:
A constraint-based solution generator that explores all valid permutations using an efficient backtracking approach.

What is this?
Puzzle Enumerator is a dynamic problem-solving application that generates all valid arrangements of elements under user-defined constraints.
Instead of brute-forcing blindly, the system intelligently explores possibilities and filters out invalid combinations in real time.
This project demonstrates how classical algorithms like **backtracking** can be applied to solve real-world constraint-based problems.


 Key Features:
- Accepts custom elements (e.g., 1 2 3 4)
-  Supports constraint rules (e.g. 1 & 2 should not be adjacent)
-  Generates all valid permutations
-  Displays total solution count
-  Fast and efficient using recursion + pruning
-  Clean, interactive UI for better user experience

 Core Concept:
At the heart of this project lies the Backtracking Algorithm.

 How it works:
1. Generate permutations recursively
2. At each step, validate constraints
3. Reject invalid paths early (pruning)
4. Store only valid solutions

This avoids unnecessary computation and improves performance significantly.

  Tech Stack:
- Java (Core Logic)
- Spring Boot (Backend Framework)
- Thymeleaf (Template Engine)
- HTML + CSS (Frontend UI)

 Running the Project
```bash
1. Clone the repository
2. Open in IntelliJ IDEA
3. Run PuzzleEnumeratorApplication.java
4. Visit http://localhost:8080

