# Java-uninformed-equation-searcher
subset of the given set of N numbers and the 4 basic arithmetic operation ( +, -, x, / ) to reach the target. 
E.g: Given the set of numbers 1,2,3,4,6 and target 53, one way to reach the target is: (2 + 3 + 4) ∗ 6 1 (a) 
Define a suitable search space representation for the problem, and briefly outline a strategy to solve the problem. 
(b) (programming portion) Write a program to solve the problem, according to the program specification given below. 
You should implement different search strategies (BFS, DFS, IDS, UCS) for finding the best node. For UCS, use the following
costs for the different operators, which roughly relates to the number of CPU cycles for a typical modern processor: 
Addition: 4 units, Subtraction: 4 units, Multiplication: 6 units, Division: 32 units. The program should output one way 
of reaching the target in the usual arithmetic notation, using parentheses whenever necessary. Program Specification : 
Assume that all input numbers and the target are positive integers. Each number may be used at most once in the expression
. However, the set of input numbers may themselves have repeated numbers. Your program should not do division that will not result in integers. The java program should run on any of the lab machines . It will be invoked as follows: java HW1 &lt; debug > &lt; Search Strategy > &lt; target > &lt; set of numbers > Where &lt; debug > could be either 0 or 1. A value of 1 would mean that the program should output all states and the paths taken that it searches in the same order. (Whenever the program expands a node during search, it outputs the contents of the node and the label of the path it took to reach that node.) &lt; Search Strategy > could be either BFS, DFS, IDS, UCS &lt; target > is the goal number that we want to reach &lt; set of numbers > is just the input set of N numbers separated by spaces . Example invocation: java HW1 1 BFS 6 1 2 3
