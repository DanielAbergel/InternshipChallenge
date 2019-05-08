# InternshipChallenge
## Problem
Given the size of the magic carpet,
initial setup of boxes and already seated treasure hunters your goal is to find the maximum number of additionaltreasure hunters that can be seated while ensuring that in the end the magic carpet is stable.

- Magic carpet is a square with Nrows, Ncolumns and a total of N*N seats.
- It is considered balanced if: (a) its left and right halves carry the same weight and (b) its front and back halves carry the same weight.
- All treasure hunters have the same weight.
- Boxes are weightless.5.Boxes can’t be moved around.
- Already seated hunters can’t be moved around.
- A single seat can be occupied by either a box or a hunter,not both.
- Initial setup for the carpet is not guaranteed to be stable.
## Input
Your input is guaranteed to be valid and you don’t need to implement input validation.
The first line of the input gives the number of test cases.Each test case:
- Starts with 1line containing three integers 
- “ N B H ”, where N is the length and width of the magic carpet, B is the amount of already placed boxes, H is the amount of already seated treasure hunters.
- Continues with B lines containing two integers “ X Y ”, marking theposition of the box on the magic carpet.
- Ends with Hlines containing two integers “ X Y ”, marking the position of the hunteron the magic carpet.

## Output
For each test case, output one line containing “Case #C: A”, where Cis the test case number (starting from 1) and Ais the maximum number of additional treasure hunters that can be seated while ensuring the magic carpet is stable. If it is not possible to balance the magic carpet, Ashould be set to -1.

## Run : 
- open TEST_INPUT and run the main , This will print  task-1 and task-2 OUTPUT .
- for more inforemtion see doc folder files.(Carpet.html ,MiniCarpet.html , TEST_INPUT , Cross)
- works with Eclipse IDE 
