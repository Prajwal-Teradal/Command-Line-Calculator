Command-Line Calculator in Java

A simple Command-Line Calculator built in Java that parses and evaluates mathematical expressions the way an interpreter does. This project demonstrates expression parsing, operator precedence, parentheses handling, and stack-based evaluation.

Features

✅ Supports basic arithmetic operations:

Addition (+)

Subtraction (-)

Multiplication (*)

Division (/)

✅ Handles parentheses for grouping expressions.

✅ Supports multi-digit and decimal numbers.

✅ Proper operator precedence handling.

✅ Detects invalid expressions and provides meaningful error messages.

Optional Enhancements (Future Scope)

Power operator (^)

Modulus (%)

Unary minus (e.g., -5 + 3)

Variables (e.g., x = 5, then x + 3)

How It Works

Tokenization
The input expression is split into numbers, operators, and parentheses.

Input: 3 + 5 * (2 - 4)
Tokens: ['3', '+', '5', '*', '(', '2', '-', '4', ')']


Infix to Postfix Conversion
Uses Dijkstra’s Shunting Yard Algorithm to handle operator precedence and parentheses.

Infix: 3 + 5 * (2 - 4)
Postfix: 3 5 2 4 - * +


Postfix Evaluation
Uses a stack to compute the result from the postfix expression.

Result: -7

Example Runs
Enter expression: 3 + 5 * (2 - 4)
Result: -7.0

Enter expression: 10 / 2 + 6 * 3
Result: 23.0

Enter expression: 3 + * 5
Invalid expression: missing operand for operator +

Enter expression: 5 + (2 * 3
Invalid expression: mismatched parentheses




How to Run

Clone the repository: 

git clone <repository_url>

Navigate to the project folder: 

cd CommandLineCalculator

Compile the Java code:

javac CommandLineCalculator.java

Run the program: 

java CommandLineCalculator

Enter any mathematical expression to get the result.


Code Highlights

Uses Stacks for numbers and operators.

Checks for invalid characters, mismatched parentheses, and missing operands.

Implements proper operator precedence.


Technologies Used

Java

Command-Line Interface


License
This project is open-source and free to use.
