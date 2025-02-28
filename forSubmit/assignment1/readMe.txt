Assignment 1: Complexity and Sorting
Course: CPRG 304-A Object-Oriented Programming 3
Group: Team Riju
Created By:
	Bryan Benedict Teruel
	Navindu Tharinda Hettiarachchige
	Fazan Khan
	Elvis Olasode
Date: Feb 28, 2025

Using the specifications below, create an application to sort any object according to a specific
property. Implement and perform experimental analysis (benchmarking) on six
sorting algorithms:
• Bubble
• Insertion
• Selection
• Merge
• Quick
• A sorting algorithm of your choice

Installation Instructions:
	Open a command prompt or terminal.
	Navigate to the folder containing Sort.jar.
	Run the program with command-line arguments:
	java -jar Sort.jar -f<file_name> -t<sort_type> -s<sort_algorithm>

• The compare type will be provided as input from the command line to your program:
h for height, v for volume, and a for base area via the -t option.

To run the executable (jar) program, the user should be able to enter the following via the
command prompt using the following case insensitive format:
-f or -F followed by file_name (the file name and path) with no spaces
• -t or -T followed by v (volume), h (height) or a (base area) with no spaces
• -s or -S followed by b (bubble), s (selection), i (insertion), m (merge), q (quick) or z
(your choice of sorting algorithm) with no spaces.