
# Children's Game Simulator

This is a command line Java application that simulates a children's counting game

## Description

- n children stand around a circle.
- To play the game there needs to be more than 1 child.
- Starting with a given child and working clockwise, each child gets a sequential
  number, which we will refer to as it’s id.
- Then starting with the first child, they count out from 1 until k. The k’th child
  is now out and leaves the circle. The count starts again with the child
  immediately next to the eliminated one.
- k can be larger than or less than the number of children
- Children are so removed from the circle one by one. The winner is the child
  left standing last.
  

## Example Input and Output:
    
a)

	Number of Players : 3
    Counter Limit : 2
    Output: player 2 is removed from the game!
            player 1 is removed from the game!
            player 3 WINS!


b)

	Number of Players : 3
    Counter Limit : 5
    Output: player 2 is removed from the game!
            player 3 is removed from the game!
            player 1 WINS!



## Compile, Test, Run and Packaging

- Compile: `mvn compile`

- Test: `mvn test`

- Packaging: `mvn package`, compiled jar in *target/* folder

- Run: `java -jar <compiled jar in target folder>`
