C was developed as a **Middle-Level** programming language by **Dennis Ritchie in 1972**. It is extremely fast and simple, allowing for **high manual control** and is **good for systems which have performance limitations** but the tradeoff being it being **system-specific** sometimes and **cumbersome to code in** compared to languages like Python and JS. Frameworks are written in C, like Windows and game engines (eg: Direct X).
###### *Part of:* [[ComLang List]]
###### *Tags:* #cse

---
---
---
## Header Library Functions

---
### Functions

#### `<stdlib.h> <stdio.h>` and other standard functions

##### Memory Allocations

| Function    | Use                                                       | Examples                                       |
| ----------- | --------------------------------------------------------- | ---------------------------------------------- |
| `malloc()`  | Memory Allocation                                         | `int *n = malloc(sizeof(int) * 5);`            |
| `calloc()`  | `malloc()` w/ initialization w/ `0`                       |                                                |
| `realloc()` | Reallocate memory<br>Point to new block<br>Free old block | `int *new = realloc(old, 10);`<br>`free(old);` |

---
#### `<math.h>`

> [!caution] `x` and `y` are Floats

> [!caution] Trigonometric Functions use **Radians**

| Function                  | Use                                                    |
| ------------------------- | ------------------------------------------------------ |
| `sqrt(x)`                 | Returns square root                                    |
| `cbrt(x)`                 | Returns cube root                                      |
| `pow(x, y)`               | Returns $x^y$                                          |
| `fabs(x)`                 | Returns absolute value of float                        |
| `round(x)`                | Rounds number                                          |
| `ceil(x)`                 | Rounds number to ceiling                               |
| `floor(x)`                | Rounds number to floor                                 |
| `log(x)`                  | Returns $ln(x) = log_{e}(x)$                           |
| `log10(x)`                | Returns $log_{10}(x)$                                  |
| `exp(x)`                  | Returns $e^x$                                          |
| `sin(x), cos(), tan()`    | *Basic Trigonometric Functions*                        |
| `asin(x), acos(), acot()` | *Inverse Trigonometric Functions like **$sin^{-1}$** * |
| `hypot(x, y)`             | Returns hypotenuse of right-angled triangle            |

---
#### `<time.h>`

- **`time_t`** - Large integer representing Unix Time
- **`clock_t`** - Integer used to measure CPU storage "ticks"
- **`size_t`** - Unsigned Integer type used for loop counters or sizes
- **`struct tm`** - Calendar structure which breaks time down into human-readable components
	`tm_year, tm_mon, tm_mday, tm_hour, tm_min, tm_sec`

```c
#include <stdio.h>
#include <time.h>

int main() 
{
    // Get current time
    time_t rawTime = time(NULL); 
    printf("Raw Unix Time: %ld sec", raw_time);
	
    // Convert raw time to a local human-readable struct
    struct tm *humanTime = localtime(&raw_time);
	
    // Fix calendar components
    printf("Year: %d\n", local_time->tm_year + 1900); // ADD 1900
    printf("Month: %d\n", local_time->tm_mon + 1);    // ADD 1
	
    // ctime() converts raw time to human-readable string
    printf("Readable String: %s", ctime(&raw_time));
    // Output: "Sat Jun 20 21:32:05 2026" for June 20th 2026, 9:32:05 PM
}
```

---
#### `<string.h>`

| Function          | Prototype      | Use                                                                                                         |
| ----------------- | -------------- | ----------------------------------------------------------------------------------------------------------- |
| `strlen`          | `(s)`          | Find length of string (Doesn't include '\0' character)                                                      |
| `strcpy`          | `(tgtS, srcS)` | Copy one string to another                                                                                  |
| `strcmp`          | `(s1, s2)`     | **Returns 0 if strings are equal,** **1 if `string1 < string2` alphabetically** and **-1 if vice versa**    |
| `stricmp/strcmpi` | `(s1, s2)`     | Like `strcmp` but ignoring case                                                                             |
| `strrev`          | `(s)`          | Reverses string                                                                                             |
| `strchr`          | `(s, 'char')`  | Finds first occurrence of given character in string                                                         |
| `strstr`          | `(s1, s2)`     | Finds first occurrence of given **`string2` in `string1`**                                                  |
| `strcspn`         | `(s1, s2)`     | Returns index of any character in `string2` in `string1` if found. Returns length of `string1` if not found |
| `strcat`          | `(s1, s2)`     | Appends **`string2` at end of `string1`**                                                                   |
| `strdup`          | `(s)`          | Duplicates `string`, `mallocs()` space for you, must be freed with `free()`                                 |

| Function   | Prototype         | Use                                              |
| ---------- | ----------------- | ------------------------------------------------ |
| `strncat`  | `(tgtS, srcS, n)` | Appends first `n` characters of `srcS` to `tgtS` |
| `strncmp`  | `(s1, s2, n)`     | Like `strcmp` but with first `n` characters      |
| `strnicmp` | `(s2, s2, n)`     | Like `stricmp` but with first `n` character      |
| `strrchr`  | `(s, c)`          | Finds last occurrence of `c` in `s`              |
| `strnset`  | `(s, c, n)`       | Sets first `n` characters of `s` to `c`          |

---
---
## C Programs

---

This section gives examples to concepts which require it the most and most vulnerable to reviewing again. Safety Checking is excluded most of the time

---
[[#Case Control Program - Difficulty Printer]]
[[#Function + Loop Logic Program - Area of Triangle]]
[[#Recursive Function - Summation of natural numbers up to `n` + `goto`]]
[[#Pointer and Address Demonstrator - Values]]
[[#Pointer Arithmetic - Array Printer]]
[[#Arrays - Manual Allocation]]
[[#Multidimensional Arrays - Matrix Multiplication]]
[[#String Program - Simple Display and Input]]
[[#Array of Pointers to Strings - Simple Display]]
[[#String Versatile Approach - Array of Pointers to Pointer to Strings]]
[[#Multidimensional Strings - Skeleton Syntax]]
[[#File IO - Reading Number of Vowels]]
[[#File IO - Writing to file from console]]
[[#File IO - Writing to file from console]]
[[#File IO - Binary IO]]
[[#File IO - Low Level IO]]
[[#Bitwise Operators - Check status of a certain bit]]
[[#Bitwise Operators - Store four 4-bit integers inside a short int]]
[[#Bit Fields - Color Venn Diagram]]
$\cdots$

---
#### Case Control Program - Difficulty Printer

The objective with this program is to let the user choose a number from 1 to 10 and print a difficulty value based on the number chosen. 
 `1-3 = Easy | 4-6 = Normal | 7-8 = Advanced | 9 = Extreme | 10 = Maximum`

```c
#include <stdio.h>

int main()
{
    int difficulty;

    printf("Enter difficulty level: ");
    scanf("%d", &difficulty);

    switch (difficulty)
    {
        case 1:
        case 2:
        case 3:
            printf("You have chosen EASY difficulty");
            break;
        case 4:
        case 5:
        case 6:
            printf("You have chosen REGULAR difficulty");
            break;   
        case 7:
        case 8:
            printf("You have chosen ADVANCED difficulty");
            break;
        case 9:
            printf("You have chosen EXTREME difficulty");    
            break;
        case 10:
            printf("You have chosen MAXIMUM difficulty");
            break;
    }

    return 0;
}
```

#### Function + Loop Logic Program - Area of Triangle

The objective with this program is to use a function to return the area of a triangle. Also, it's made sure that the input is valid.

```c
#include <stdio.h>
#include <math.h>

float trianglearea(float , float , float );

int main()
{
    float s1, s2, s3;
    short int check;

    do {
        printf("Enter 3 sides of a triangle: " );
        scanf(" %f %f %f", &s1, &s2, &s3);
        check = 0;
        if ((s1 >= (s2 + s3) || s2 >= (s1 + s3) || s3 >= (s1 + s2)))
        {
            printf("Invalid side lengths entered, try again\n");
            check = 1;
        }
    }while (check); // Keeps prompting user until sides are valid

    printf("Area of the triangle is %f", trianglearea(s1, s2, s3));
}

float trianglearea(float s1, float s2, float s3)
{
    float semiPerimeter = (s1 + s2 + s3) / 2; // sp === semiperimeter

    float area = sqrt(semiPerimeter * (semiPerimeter - s1) * (semiPerimeter - s2) * (semiPerimeter - s3));
    // Herons Formula ^^

    return area;
}
```
#### Recursive Function - Summation of natural numbers up to n + `goto
`
```c
#include <stdio.h>

long long int summation(int n)
{
    if (n == 1)
        return 1;
    else
        return n + summation(n-1);
}

int main()
{
    int num;

    doagain:
    printf("Enter a positive integer: ");  
    scanf("%d", &num); //Input- 735
    if (num <= 0)
        goto doagain;
	
	printf("The summation is %lld", summation(num));
		
    return 0;
}

// Output-
/*
The summation is 270480
*/
```
#### Pointer and Address Demonstrator - Values

```c
#include <stdio.h>

int main()
{
    int n = 8;
    int *ptr = &n;

    printf("%d\n", n);
    printf("%d\n", &n);
    printf("%d\n", *(&n));
    printf("%d\n", ptr);
    printf("%d\n", *ptr);
    printf("%d\n", *(&ptr));

    return 0;
}

// Output-
/*
8
6422300
8
6422300
8
6422300
*/
```
#### Pointer Arithmetic - Array Printer

```c
#include <stdio.h>

int main()
{
    int ary[5];
    int *ptr = ary; // Same as *ptr = &ary[0]

    printf("Enter 5 elements: ");
    for (int i = 0; i < 5; i++)
        scanf("%d", ptr + i);
    for (int i = 0; i < 5; i++)
        printf("%d ", ptr[i]); // Same as ptr + i
    
    return 0;
}

// Output-
/*
Enter 5 elements: 6 4 65 2 -5
6 4 65 2 -5 
*/
```
#### Arrays - Manual Allocation

```c
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n;
    short int i = 0;

    printf("Enter the amount of elements you want: ");
    scanf("%d", &n);

    int *ary = malloc(sizeof(int) * n);
    do
    {
        scanf(" %d", &ary[i++]);
    } while (i < n);

    for (i = 0; i < n; i++)
        printf("%d\n", ary[i]);
		
	free(ary);
    return 0; 
}

// Output-
/*
Enter an integer: 68286
The number is a palindrome
*/
```
#### Multidimensional Arrays - Matrix Multiplication

```c
#include <stdio.h>

int main()
{
    int r1, c1, r2, c2;
    int i, j, k;
    do 
    {
        printf("Enter the rows and columns of matrix 1 respectively: ");
        scanf(" %d %d", &r1, &c1);
        printf("Enter the rows and columns of matrix 2 respectively: ");
        scanf(" %d %d", &r2, &c2);
        if (c1 != r2)
            printf("NOT POSSIBLE, Columns of Matrix 1 do not match Rows of Matrix 2!\n");
    }while (c1 != r2);
    int rc = c1; // Number of Columns of M1 i.e. Rows of M2
    int matrix1[r1][rc], matrix2[rc][c2], prodmatrix[r1][c2];

    printf("Enter the elements of Matrix 1 [%d x %d]: ", r1, rc);
    for (i = 0; i < r1; i++)
        for (j = 0; j < rc; j++)
            scanf(" %d", &matrix1[i][j]);
    printf("Enter the elements of Matrix 2 [%d x %d]: ", rc, c2);
    for (i = 0; i < rc; i++)
        for (j = 0; j < c2; j++)
            scanf(" %d", &matrix2[i][j]);

    for (i = 0; i < r1; i++)
        for (j = 0; j < c2; j++)
        {
            prodmatrix[i][j] = 0;
            for (k = 0; k < rc; k++)
                prodmatrix[i][j] += matrix1[i][k] * matrix2[k][j];    
        }

    printf("Product Matrix-\n");
    for (i = 0; i < r1; i++)    
    {
        for (j = 0; j < c2; j++)
        {
            printf("%d ", prodmatrix[i][j]);
        }
        printf("\n");
    }
           
    return 0;
}

// Output-
/*
Enter the rows and columns of matrix 1 respectively: 1 2
Enter the rows and columns of matrix 2 respectively: 2 4
Enter the elements of Matrix 1 [1 x 2]: 1 2
Enter the elements of Matrix 2 [2 x 4]: 1 2 3 4 5 6 7 8
Product Matrix-
11 14 17 20 
*/
```
#### String Program - Simple Display and Input 

```c
#include <stdio.h>
#include <string.h>

int main()
{
    char string1[50] = "This is a string";
    char *string2 = "This is a pointer to a string";
    char buffer[4096];
    char string3[50]; // Pointer to string
    printf("Pls Enter Input (below 50 char): ");
    fgets(buffer, sizeof(buffer), stdin);
    strcpy(string3, buffer);    
    
    printf("%s\n", string1);
    printf("%s\n", string2);
    printf("%s\n", string3);
    
    return 0;
}

// Output-
/*
Pls Enter Input (below 50 char pls): do not report me to authority
Hi this is a string
This is a pointer to a string
do not report me to authority
*/
```
#### Array of Pointers to Strings - Simple Display

```c
#include <stdio.h>
#include <string.h>

int main()
{
    char *string[3] = {"Hello World", "Goodbye World", "Example String"};
    // BEST for string literals

    for (int i = 0; i < 3; i++)
        printf("%s\n", string[i]);
    
    return 0;
}

//Output-
/*
Hello World
Goodbye World
Example String
*/
```
#### String Versatile Approach - Array of Pointers to Pointer to Strings

```c
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
    char **strng;
    int n = 1;
    strng = malloc(n * sizeof(char *));

    char ch = 'n';
    char buffer[4096];
    do 
    {
        printf("Enter a string: ");   
        fgets(buffer, sizeof(buffer), stdin);
        buffer[strcspn(buffer, "\n")] = '\0';
        strng[n - 1] = malloc(strlen(buffer) + 1);
        strcpy(strng[n - 1], buffer);
        printf("More? (y/n): ");
        scanf(" %c", &ch);  
        while (getchar() != '\n');
        if (ch =='y' || ch == 'Y')
        { // No NULL check because lazy
            strng = realloc(strng, ++n * sizeof(char *));
        }
    } while(ch == 'y' || ch == 'Y');

    for (int i = 0; i < n; i++)
    {
        printf("%s\n", strng[i]);
        free(strng[i]); 
    }
    free(strng);
    return 0;
}

// Output-
/*
Enter a string: string example
More? (y/n): y
Enter a string: another string
More? (y/n): y   
Enter a string: more strings
More? (y/n): Y
Enter a string: last string we will enter
More? (y/n): n
string example
another string
more strings
last string we will enter
*/
```
#### Multidimensional Strings - Skeleton Syntax

```c
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
    char string[3][10][50] = 
    {
        {"Hello World!", "Goodbye World!"/*,... 7 more*/},
        {/*10 strings*/},
        {/*10 strings*/}
    };
	// This variable has the capacity to hold 3 sets of 10 strings of at most 50 characters each (including NULL)
    // So 3 x 10 x 50 = 1500 characters (ignoring NULL this time as it's negligible for this example)
}
```
#### File IO - Reading Number of Vowels

```c
#include <stdio.h>```

int vowelChecker(char ch)
{
    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
        return 1;
    else if (ch == EOF)
        return 0;
    else
        return 0;
}

int main()
{
    FILE* fp = fopen("file1.txt", "r");
    if (fp == NULL) 
	{
        printf("Error during File Open");
        return 1;
    }
    int vowelNum = 0;
    char ch;

    while((ch = fgetc(fp)) != EOF)
        if (vowelChecker(ch))
            vowelNum++;
    
    printf("Total Vowels found is %d", vowelNum);

    return 0;
}

// File
// Hello_World

//Output
// 3
```
#### File IO - Writing to file from console

```c
#include <stdio.h>

int main()
{
	FILE *fp = fopen("file1.txt", "w");
	if (fp == NULL) 
	{
        printf("Error during File Open");
        return 1;
    }
	char buffer[4096];
	char ch = 'y';
	do 
	{
		printf("Enter string: ");
		fgets(buffer, sizeof(buffer), stdin);
		fputs(buffer, fp);
		printf("Another? (y/n): ");
		scanf(" %c", &ch);
		while (getchar() != '\n');
	} while (ch == 'y' || ch == 'Y');

    fclose(fp);
    return 0;
}
```
#### File IO - Copying one file to another
```c
#include <stdio.h>

int main()
{
	FILE *fp1 = fopen("file1.txt", "r");
	FILE *fp2 = fopen("file2.txt", "w");
	if (fp1 == NULL || fp2 == NULL)
	{
        printf("Error during File Open");
        return 1;
	}
	
	char buffer[4096];

	while (fgets(buffer, sizeof(buffer), fp1) != NULL)
		fputs(buffer, fp2);
	fclose(fp1);
	fclose(fp2);
    return 0;
}
```
#### File IO - Binary IO

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    FILE *fp = fopen("file1.txt", "r+b");
    if (fp == NULL) 
	{
        printf("Error during File Open");
        return 1;
    }

    char buffer[4096];
    printf("Enter some input: ");
    fgets(buffer, sizeof(buffer), stdin);
    fwrite(buffer, 1, strlen(buffer), fp);
    
    fseek(fp, 0, SEEK_SET);
    char buffer2[4096]; 
    
    fread(buffer2, 1, sizeof(buffer2), fp);
    
    printf("File contents: %s", buffer2);
    
    fclose(fp);
    return 0;
}
```
#### File IO - Low Level IO

```c
#include <stdio.h>
#include <string.h>
#include <sys/stat.h> // not necessary HERE
#include <sys/types.h> // not necessary HERE
#include <fcntl.h>
#include <unistd.h>

int main()
{
	int fd = open("file1.txt", O_WRONLY | O_CREAT | O_TRUNC, 0644);
	// 0644: Standard file permissions (Owner can read/write, others can only read)
	char buffer[4096];
    printf("Enter some input: ");
    fgets(buffer, sizeof(buffer), stdin);
	write(fd, buffer, strlen(buffer));
	close(fd);

	fd = open("file1.txt", O_RDONLY);
	char buffer2[4096];
	read(fd, buffer2, sizeof(buffer2) - 1);

	printf("%s", buffer2);
}
```
#### Bitwise Operators - Check status of a certain bit

```c
#include <stdio.h>
#include <stdlib.h>

int main()
{
	int n;
	int bitPos;
	printf("Enter n (+ve integer): ");
	scanf(" %d", &n);
	printf("Enter bit position to check for (0 = LSB): ");
	scanf("%d", &bitPos);
	
	int mask = 1 << bitPos;
	int result = n & mask;
	if (result)
		printf("SET");
	else
		printf("NOT SET");

	return 0;
}
```
#### Bitwise Operators - Store four `4-bit` integers inside a short int

```c
#include <stdio.h>

int packNumbers(int a, int b, int c, int d)
{
	short int n = 0;
	n = ((a & 15) << 12) | ((b & 15) << 8) | ((c & 15) << 4) | ((d & 15));
	
	return n;
}

void unpackNumbers(int *a, int *b, int *c, int *d, int n)
{
	*a = (n >> 12) & 15;
	*b = (n >> 8) & 15;
	*c = (n >> 4) & 15;
	*d = (n) & 15;
}

int main()
{
	int a, b, c, d, n;
	printf("Enter 4 numbers under 16: ");
	scanf(" %d %d %d %d", &a, &b, &c, &d);
	// Trust user to follow instructions
	n = packNumbers(a, b, c, d);
	printf("Packed: %d", n);
	unpackNumbers(&a, &b, &c, &d, n);
	printf("\nUnpacked: %d %d %d %d", a, b, c, d);
}
```
#### Bit Fields - Color Venn Diagram

```c
#include <stdio.h>

// Total of 8 colors
// Black Red Green Blue Yellow Cyan Magenta White
struct colorWheel
{
	unsigned int red: 1;
	unsigned int green: 1;
	unsigned int blue: 1;
	unsigned int brightness: 3; // 8 levels of brightness
};
// Total 6 bits of data, really 1 byte due to optimization and architecture 

int main()
{
	struct colorWheel v;
	
	v.red = 1;
	v.green = 0;
	v.blue = 1;
	v.brightness = 6;
	
	if (v.red) {
		if (v.green) {
			if (v.blue) printf("White");
			else        printf("Yellow");
		}
		else {
			if (v.blue) printf("Magenta");
			else        printf("Red");
		}
	}
	else {
		if (v.green) {
			if (v.blue) printf("Cyan");
			else        printf("Green");			
		}
		else {
			if (v.blue) printf("Blue");
			else        printf("Black");
		}
	}
	
	switch(v.brightness) {
		case 0: printf("No Brightness"); break;
		case 1: printf("Minimum"); break;
		case 2: printf("Faint"); break;
		case 3: printf("Low"); break;
		case 4: printf("Normal"); break;
		case 5: printf("High"); break;
		case 6: printf("Higher"); break;
		case 7: printf("Maximum"); break;
	}
}

// Output
"Magenta"
"Higher"
```

---
---
## **C Guide** - Getting Started

---

```c
#include <stdio.h>
#include <stdlib.h>
void printHello()
{
	printf("Hello");
	return;
}
int main()
{
	// comment
	/*
		comment
	*/
	int n;
	printf("Enter the value of n: ");
	scanf("%d", &n); // address needs to be scanned
	print("Hello %d Number!", n); // value needs to be displayed
	printHello();
	return 0;
}
```

- Datatypes need to be declared
- `printf`, `scanf` are the main formatted I/O Tools
- `&` used for *address*, `*` used for *value at address*
- Execution begins in `int main()`
> `*(&n)` functionally same as `n`

##### Headers
Header files **`<stdio.h>`** and *`<stdlib.h>`* are required for pretty much everything, so including them is better.
*Equivalent of `imports`*
##### Main Datatypes
- `int %d` & `float %f`
- `char %c` *declared with `''`*
##### IO

Variables in `printf()` are printed respective to their identifier and the order at the end of the string

==Variable types should match identifer to prevent unintended behavior==, but might be useful for niche tasks like obtaining ASCII Value
```c
int a = 5;
int b = 10;
char c = '5';
printf("Value is a is %d, b is %d", a, b);
printf("ASCII Value of c is %d", c);
```
##### Comments
```c
// single-line comment
/*
	comment
*/
```

> [!summary] `NULL` Keyword
> Special Keyword returned and used sometimes, its use can be deduced from context itself so no special section has been dedicated to it

---
## Operators

---
#### Arithmetic/Assignment Operators

| Symbol         | Name/Use                        |
| -------------- | ------------------------------- |
| `+`            | Summation                       |
| `-`            | Difference                      |
| `*`            | Multiplication                  |
| `/`            | Division                        |
| `%`            | Modulus (Remainder of Division) |
| `x++`<br>`++x` | Post Increment<br>Pre Increment |
| `x--`<br>`--x` | Post Decrement<br>Pre Decrement |

| `=` | Assignment | RHS evaluated first to calculate the value to be assigned to LHS |
| --- | ---------- | ---------------------------------------------------------------- |
#### Comparison Operators

| Symbol | Name/Use                 |
| ------ | ------------------------ |
| `>`    | Greater Than             |
| `<`    | Smaller Than             |
| `>=`   | Greater Than or Equal To |
| `<=`   | Smaller Than or Equal To |
| `==`   | Equal To                 |
| `!=`   | Not Equal To             |

#### Logical Operators

| Symbol | Name/Use    | Logic                                    |
| ------ | ----------- | ---------------------------------------- |
| `%%`   | Logical AND | All conditions must be satisfied         |
| \|\|   | Logical OR  | At least one condition must be satisfied |
| `!`    | Logical NOT | Inverts the logic                        |
#### Other Operators

| Symbol     | Name/Use   | Logic                                         |
| ---------- | ---------- | --------------------------------------------- |
| `&`        | Address OF | Provides memory address of variable           |
| `*`        | Address AT | Provides value at memory address              |
| `sizeof()` | Size Of    | Provides byte size of given datatype/variable |
#### Hierarchy and Associativity
*Pipe Symbol `|` not in monospace due to conflict in markdown table syntax*

| Precedence      | Operator(s)                                               | Description                         | Associativity |
| :-------------- | :-------------------------------------------------------- | :---------------------------------- | :------------ |
| **1 (Highest)** | `()`                                                      | Parentheses (grouping)              | L `->` R      |
|                 | `[]`                                                      | Array subscript                     | L `->` R      |
|                 | `.`                                                       | Member selection (direct)           | L `->` R      |
|                 | `->`                                                      | Member selection (indirect/pointer) | L `->` R      |
|                 | `++` (postfix)                                            | Postfix increment                   | L `->` R      |
|                 | `--` (postfix)                                            | Postfix decrement                   | L `->` R      |
| **2**           | `++` (prefix)                                             | Prefix increment                    | *R `->` L*    |
|                 | `--` (prefix)                                             | Prefix decrement                    | *R `->` L*    |
|                 | `+` (unary)                                               | Unary plus                          | *R `->` L*    |
|                 | `-` (unary)                                               | Unary minus                         | *R `->` L*    |
|                 | `!`                                                       | Logical NOT                         | *R `->` L*    |
|                 | `~`                                                       | Bitwise NOT (one's complement)      | *R `->` L*    |
|                 | `*` (dereference)                                         | Pointer Dereference                 | *R `->` L*    |
|                 | `&` (address-of)                                          | Address Of                          | *R `->` L*    |
|                 | `sizeof`                                                  | Size of in bytes                    | *R `->` L*    |
|                 | `(type)`                                                  | Type cast                           | *R `->` L*    |
| **3**           | `*` (multiplication)                                      | Multiplication                      | L `->` R      |
|                 | `/`                                                       | Division                            | L `->` R      |
|                 | `%`                                                       | Modulus                             | L `->` R      |
| **4**           | `+` (addition)                                            | Addition                            | L `->` R      |
|                 | `-` (subtraction)                                         | Subtraction                         | L `->` R      |
| **5**           | `<<`                                                      | Left shift                          | L `->` R      |
|                 | `>>`                                                      | Right shift                         | L `->` R      |
| **6**           | `<`                                                       | Less than                           | L `->` R      |
|                 | `<=`                                                      | Less than or equal to               | L `->` R      |
|                 | `>`                                                       | Greater than                        | L `->` R      |
|                 | `>=`                                                      | Greater than or equal to            | L `->` R      |
| **7**           | `==`                                                      | Equal to                            | L `->` R      |
|                 | `!=`                                                      | Not equal to                        | L `->` R      |
| **8**           | `&` (bitwise AND)                                         | Bitwise AND                         | L `->` R      |
| **9**           | `^`                                                       | Bitwise XOR (exclusive OR)          | L `->` R      |
| **10**          | $\vert\vert$                                              | Bitwise OR (inclusive OR)           | L `->` R      |
| **11**          | `&&`                                                      | Logical AND                         | L `->` R      |
| **12**          | $\vert\vert$                                              | Logical OR                          | L `->` R      |
| **13**          | `?:`                                                      | Ternary conditional                 | *R `->` L*    |
| **14**          | `=`                                                       | Assignment                          | *R `->` L*    |
| **15**          | `+=` `-=` `*=`  `/=`  `%=` `&=` $\vert$= `^=` `<<=` `>>=` | Compound assignment (arithmetic)    | *R `->` L*    |

---
## Control Flow

---

> [!failure] `0` = false

> [!success] `non-zero` = true
### Conditional Statements

```c
if (a > 5 && a < 10)
	printf("{Braces} can be omitted for single line");
else if (a < 5)
{
	printf("But not for multiple lines");
	printf("---");
}
else
	printf("---")
```

#### Ternary Operator

- Can be nested
- Can be used in return statements and conditions
- Can be used for variable assignment

> [!caution] Low Precedence, use `()` when needed

```c
int a = 3;
int b = (a != 3) ? 1 : 2; // b will be 2

return (c > 5) ? true : false; 
```

---
### Loops

```c
while (n < 10)
{
	printf("{Braces} cannot be omitted for multiple lines");
	n++;
}

do
{
	printf("Will print at least once");
} while (n < 10);

for (int i = 0; i <= n; i++) // will loop 10 times as n is 9 now
	printf("{Braces} can be omitted for single line");
```

---
## Memory - Addresses & Pointers

Essential and crucial concept in C as it is lower level than most languages

- `&` - Address Of
- `*` - Value at *address*
- `*x` - Pointer

```c
int b = 5;
int *a;
a = &b;
printf("%d", *a, b); // 5
printf("%d %d %p", a, &b, a); // numeric address of b
printf("%d", *(&b)); // 5
```

Numeric addresses are usually something like `6443232` on GCC on ***MY PC*** 
### Memory Allocation
```c
// For Arrays/Strings
int *ary = malloc(sizeof(int) * 5); // 5 int elements
int *ary2 = calloc(3, sizeof(int) * 7);
// calloc() initializes all 7 elements to 3

int *ary3 = realloc(ary, 10); // make new size 10
free(ary); // then free old ary
```

### Pointer Arithmetic

> [!tldr] Basically `ptr[i]` = `ptr + i`

---
## Functions

---
##### Syntax

```c
int add(int a, int b) {
	return (a + b);
}

// return 3rd (0-indexed) element in array
int* exampleFunc(int* ary, int *s) {
	printf("%d\n", *s); // 5
	return &ary[2];
}

int main() {
	int *ary = calloc(5, sizeof(int)); // 5 elements all initialized to 0
	int s = 5; // size
	printf("%d\n", add(5, 3)); // 8
	printf("%d\n", *(exampleFunc(ary, &s)));
}
```

#### Characteristics of C Functions

1. Prototypes must be declared first if defined after `main()`
2. Only one return value
3. `main()` is executed first
4. Must be defined/declared outside all other functions
5. Addresses/pointers may be passed/returned

> [!check] ### Recursion is allowed
> ```c
> int factorial(n) {
> 	if (n > 0)
> 		return factorial(n - 1) * n;
> 	else
> 		return 1;
> }
> ```

---
## Arrays & Strings

---
### Arrays

> [!check] `0-indexed`

```c
int ary[5]; // still internally a pointer
printf("%d" ary, &ary[0]);
int *ary2 = malloc(sizeof(int) * 5);
int *ary3 = {1, 2, 3, 4}; // initialized on declaration

char *strng; // just an array of chars in C
```

> [!info]  `ary` same as `&ary[0]` 
> In the context of memory, addresses, pointers and passing to functions

#### Multidimensional Arrays

```c
int ary[2][3][4] = 
{
    {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    },
    {
        {13, 14, 15, 16},
        {17, 18, 19, 20},
        {21, 22, 23, 24}
    }
};
```

Memory wise, storing is done as follows
`{1, 2, 3, 4} -> {5, 6, 7, 8} -> ...`
All elements of a dimension *object* are stored before moving on to the next *object* 

> [!help] Object is a metaphorical term here

---
### Strings

```c
char strng[10] = {"Hello"}; // preferred way to initialize strings
char strng2[10] = {'H', 'e', 'l', 'l', 'o'}; // but this is also allowed

char *strng3 = malloc(6);
strng = "Hello";
```

> [!caution] `\0` Character
> One byte is reserved for `\0` character at the end of string.
>  > eg: `char strng[5]` will have 4 bytes for characters, 1 byte for `\0` terminator

#### String IO

```c
fgets(strng, sizeof(strng), stdin); // console input
fputs(strng, stdout) // console output
printf("%s", strng); // formatted console output
puts(strng); // console output with \n at end
```

Explained more in [[#IO Formatting]] 
#### Multidimensional Strings

```c
// 3 strings of 20 characters each
strngs = malloc(3);
for (int i = 0; i < 3; i++)
	strngs[i] = malloc(20);
```

---
## Structures and Unions

---

### Structures

Structures are essentially Classes and Objects in C without OOP Features

```c
struct bookData
{
	char name[50];
	int price;
} book1; // direct declaration of object after class defined
bookData book2; // declaration later

book1.name = ...; // direct access

bookData *bookPtr = book2;
bookPtr->name = ...; // accessing through pointer
```

**Memory is reserved when instances are declared** of the respective structure

##### Copying

```c
// book1 to book2, piece-meal

book2.name = book1.name;
book2.price = book1.name;


// All at one
book2 = book1;
```

#### Arrays of Structures

```c
struct bookData
{
	char name[50];
	short int price;
} book1[4]; // 4 books
bookData book2[5]; // 5 books
```

> [!check] Syntax overlap with Arrays
> Behaves as expected, `0-indexing`, `malloc()`, etc

#### Nesting of Structures

```c
struct bookDetailedData
{
	char author[50];
	char genre[20];
};
struct bookData
{
	char name[50];
	short int price;
	struct bookDetailedData specifications;
};
struct bookData book1;
```

#### Bit Fields

Bit Fields allows for individual bits to be stored in Structures. This is only usable within structures. 
The number of bits to be allocated is preceded by a `:` which precedes the element name.

```c
struct IPv4Header 
{
    unsigned int version : 4;        // 4 bits for IP version (usually 4)
    unsigned int ihl : 4;            // 4 bits for header length
    unsigned int dscp : 6;           // 6 bits for DSCP
    unsigned int ecn : 2;            // 2 bits for ECN
    unsigned int totalLength : 16;   // 16 bits for length of packet
};
struct IPv4Header packet;

packet.version = 4;
packet.ihl = 5;              // 5 × 32-bit words = 20 bytes
packet.dscp = 0x1E;          // arbitrary example value
packet.ecn = 0x3;            // ECN capable
packet.totalLength = 0x003C; // 60 bytes


"0x prefix = hexadecimal number"
```

---
### Unions

Unions allow for **storage of multiple datatypes in the same address**, but only one at the same time.
During Memory Allocation, **byte size of the highest element** is allocated

```c
union u1 // 4 BYTES
{
	int id;
	char name[4];
};
union u2 // 20 BYTES
{
	int id;
	char name[20];
}
```

> [!check] Syntax Similarity and Possibilities
> - **Can be nested** inside structures and themselves. 
> - Structures can also be nested in unions
> - `->` for access when pointers used
> - Arrays of Unions

---
## IO Formatting

---

> [!important] Standard File Pointers/Streams
> `stdin` - Console Input
> `stdout` - Console Output
> `stderr` - Standard Error Output

> [!help] Glossary for Syntax
> - `st` - String
> - `sz` - Size of String
> - `sm` - IO Stream/Std File Pointer used
> - `fm` - Usual `scanf(), printf()` "format syntax"
> - `var` - Variables after `fm` in `scanf(), printf()`

| Name        | Function              | Syntax           | Use                              |
| ----------- | --------------------- | ---------------- | -------------------------------- |
| `gets()`    | Get String            | `(st)`           | !Input String String             |
| `puts()`    | Put String            | `(st)`           | Output String                    |
| `fgets()`   | File Get String       | `(st, sz, sm)`   | Get String from file pointer     |
| `fputs()`   | File Put String       | `(st, sm)`       | Output String from file pointer  |
| `fscanf()`  | File Scan Formatted   | `(sm, fm, &var)` | `scanf()` but with file pointer  |
| `fprintf()` | File Print Formatted  | `(sm, fm, var)`  | `printf()` but with file pointer |
| `sscanf()`  | String Scan Formatted | `(st, fm, &var)` | `fscanf()` but with string       |

> [!danger] Do Not Use `gets()`
> It is **insecure and dangerous** as there is no bounds-checking present in it. `fgets()` is used instead. However `puts()` is completely fine
### Identifiers

| Identifier | Datatype          | Properties                           |
| ---------- | ----------------- | ------------------------------------ |
| `%d`       | `int`             |                                      |
| `%f`       | `float`           |                                      |
| `%lf`      | `double`          |                                      |
| `%c`       | `char`            | Does not skip whitespaces by default |
| `%n`       | *See [[#^percn]]* | *See [[#^percn]]*                    |

| Identifier  | Type                 | Properties                                                        |
| ----------- | -------------------- | ----------------------------------------------------------------- |
| `%s`        | `string`             | Stops reading at whitespace                                       |
| `%x` / `%X` | Hex (lwr/UPR)        |                                                                   |
| `%p`        | Pointer address      |                                                                   |
| `%n`        | `---`                | Stores number of characters read so far and doesn't consume input |
| `%%`        | Literal percent sign | `%`                                                               |

---
### Input Formatting 
| scanf quirks                   | Description                                                        | Examples                                            |
| ------------------------------ | ------------------------------------------------------------------ | --------------------------------------------------- |
| `%[a-z]` and<br>`%[^a-z]`      | Reads only characters within/not within that **ASCII Value Range** | `scanf("%[0-9]", st)`<br>`scanf("%[^0-9]", st)`     |
| `*` before datatype identifier | Suppresses assignment (reads but doesn’t store)                    | `scanf("%*d", &a)`                                  |
| `-` between specifiers         | Expects **actual character of `-` in input**                       | `scanf("%d-%d", &a, &b)` `scanf("%d - %d", &a, &b)` |
| ` ` before `%`                 | Skip whitespaces before scanning                                   | `scanf(" %d", &a)`                                  |
| Number after `%`               | Max length allowed for input<br>Leave space for `\0`               | `scanf("%100s", st)`                                |
| **NOTE**                       | *Most of the above can be combined with each other*                | `scanf(" %100[^a-z]", st)`                          |
1. `scanf()` returns the number of successfully read items
2. `%n` stores the number of characters read so far and doesn't consume input
   > eg: `scanf("%d%n", &a, &count)`

---
### Output Formatting
Properties of `printf()` and `fprintf()` like width, alignment, padding (with `0`) and precision
```c
printf("%5d", 42);   // "   42"
printf("%-5d", 42);  // "42   "

printf("%05d", 42);  // "00042"

printf("%.2f", 3.14159);  // 3.14
printf("%.3s", "hello");  // "hel"
```
> - Width is set by a number before `%`, `-` before the number makes it right-aligned
> - Adding `0` before a number pads with zeroes instead of space
> - `.x` specifies precision of float, `x` being the number of digits after decimal point

| Parameters                   | Description                    | Example                      |
| ---------------------------- | ------------------------------ | ---------------------------- |
| ` ` before `%c`              | Skips any whitespace           | ` %c`                        |
| *number* before `%specifier` | Pads                           | `%4d` `->` `  32`, ` 2048`   |
| `0` along with number        | Pads Zeros                     | `%05d` `->` `00042`, `00353` |
| `.n` before `f`              | First `n` digits after decimal | `%.4f` `->` `3.1415`         |
| `.n` before `s`              | First `n` digits of string     | `%8s` `->` `Hello Wo`        |

---
## File IO

---

> [!important] File Handling Keywords
> 
> **Streams**
> `stdin` - Console Input
> `stdout` - Console Output
> `stderr` - Standard Error Output
> 
> **Macros**
> `EOF` - End of File (MACRO for just after the last character, to denote file has ended)
> 
> **Keywords**


Main concepts in C regarding File I/O are-
- Opening Modes
- Pointer Navigation
- Binary Mode Handling
- Low Level Handling

---
### Opening Modes

Create a file pointer variable using `fopen()`
```c
FILE *fp = fopen("file_name.extension_name", "opening_mode")
```

| Opening Mode | Name                              | File Pointer   | File Created if not found? | Content Overwritten? |
| ------------ | --------------------------------- | -------------- | -------------------------- | -------------------- |
| `r`          | Read Only                         | `0`            | `NO`                       | `NO`                 |
| `w`          | Write Only                        | `0`            | `YES`                      | `YES`                |
| `r+`         | Read & Write                      | `0`            | `NO`                       | `NO`                 |
| `w+`         | Read & Write (truncates content)  | `0`            | `YES`                      | `YES`                |
| `a`          | Append Only                       | `last` char    | `YES`                      | `NO`                 |
| `a+`         | Append new + Read earlier content | `last`<br>char | `YES`                      | `NO`                 |
If file is not found nor created later, `fopen()` will always return `NULL`


> [!caution] Close Files with `fclose()`
> ```c
> ...
> ...
> ...
> fclose(fp);
> ```

---
### Pointer Navigation

`fseek()` function is used to move the file pointer within the file.
`ftell()` function is used to tell the position of file pointer (`0-indexed`)

```c
fseek(filePtr, offset, fromWhere?)

"fromWhere can be: "
SEEK_SET // beginning of file
SEEK_CUR // current position
SEEK_END // ending of file
```

```c
FILE *fp = fopen("file.txt", )

fp = fseek(fp, 6, SEEK_CUR); // move forward by 6 characters
fp = fseek(fp, -3, SEEK_END); // three characters behind of file end
fp = fseek(fp, 5, SEEK_SET); // fifth character in file (0-INDEXED, so 6th)
```

> [!danger] Zero - Indexed
> The integer that `ftell()` returns is `0-indexed`.
> > So `fseek(fp, 5, SEEK_SET)` and `ftell(fp)` will result in the position of sixth character (colloquially ordinal number, not `0-indexed`) being returned

> [!warning] Out of Bounds
> If offset is invalid, `fseek()` will return a `non-zero` value and if successful will return `0`

---
### Binary Mode

Binary Mode is faster than text mode but with a few tradeoffs.
Use `b` as a suffix after either file opening mode character or the `+` icon
> `rb+ r+b, ab, w+b etc`
> But according to convention, `r+b > rb+` 

| Text Mode                                                                                  | Binary Mode                                            |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------ |
| Information stored as characters                                                           | Information stored in binary                           |
| Slower to access                                                                           | Faster to access                                       |
| Stores numbers as `char` strings                                                           | Stores numbers according to their `byte size`          |
| `\n` converted to `\r` before being written.<br>Converted back into `\n` when file is read | These conversions do not take place                    |
| Uses functions like `fprintf(), fscanf(), sscanf(),`<br>`fputs(), fgets(), etc`            | Uses functions `fread()` and `fwrite()` to perform I/O |
```c
fread(I, II, III, IV);
"I = ptr to store in"
"II = size in bytes"
"III = no. of elements to be read (II * III = actual size read)"
"IV = file pointer"

fread(buffer, sizeof(buffer), 1, fp);
```
```c
fwrite(I, II, III, IV);
"I = ptr to write from"
"II = size in bytes"
"III = no. of elements to be written (II * III = actual size written)"
"IV = file pointer"

fwrite(buffer, sizeof(buffer), 1, fp);
```

---
### Low Level

Low Level handling is faster as the functions it uses parallel the methods that the OS uses. Both text and binary mode can be used via Low Level
Own buffer must also be created since *`fgets()` typically has a hidden 4kB buffer*

##### Required Libraries
`<sys/stat.h>`
`<sys/types.h>`
`<fcntl.h>`
`<unistd.h>`

##### Used Functions-
- **`open()`** - `int fd = open("file.txt", *opening mode and behaviors*)`
- **`close()`** - `close(fd)`

- **`read()`** - `write(I, II, III)`
- **`write()`** - `read(I, II, IV)`

`I` = `fd` (file descriptor) - Stream to retrieve/send data from/to
`II` = `buffer` - Source/Destination
`III` - Number of bytes buffer can safely load
`IV` - Number of bytes to put into file from buffer
##### File Opening Modes
1. `O_RDONLY` - Opens file for reading only
2. `O_WRONLY` - Opens file for writing only
3. `O_RDWR` - Opens a file for both reading and writing

##### **Put a `|` between every modifier and after opening mode**

##### File Behavior Modifiers
1. `O_CREAT` - Creates file if doesn't exist. Must pass third argument, `mode`
2. `O_TRUNC` - Truncates file to 0 length if it already exists (removes content/overwrites)
3. `O_APPEND` - All writes go to the end of the file
4. `O_EXCL` - Used with `O_CREAT`, fail if file already exists **(for safe creation)**
5. `O_NONBLOCK` - Open in **non-blocking mode(?)** Useful for sockets, pipes, etc.
6. `O_SYNC` - Writes are synchronized to disk **immediately**
7. `O_DSYNC` - Like `O_SYNC`, but syncs only data, **not metadata**
8. `O_RSYNC` - Synchronize read operations (very rare)
9. `O_NOCTTY` - Mark file to not be the controlling terminal for this process
*Linux specific flags not given here.*
##### Permissions when `O_CREAT`
(Same syntax as modifiers, to be used at very end, like a last modifer)
1. `0644` - Owner can read/write file, others can only read
(much more *not worth it for now* info not noted $\cdots$)

---
### IO Redirection

I/O Redirection allows for redirection of all input/output from/to a file/terminal to another
```
C> .\program > file1.txt 
C> .\program < file1.txt
C> .\program < file1.txt > file2.txt
```
1. Redirects all output to `file1.txt`
2. Redirects all input to be received from `file1.txt`
3. Redirects all input to be received from` file1.txt` and all output to be redirected to `file2.txt`

---
## Advanced Datatype Info & Storage Classes

---

> [!important] `const` Keyword
> `const` keyword does not allow the variable to be altered in any way, it must be defined on declaration mandatorily if initialized. 
> - Used when variable must remain same
> - Highly encouraged for good practice and optimization
> > eg: Unchangable value of $pi$ for a variable
> > ```c
> > const pi = 3.14159;
> > ```
> > eg: Disallowing change of `n` variable in function, even if it's a copy
> > ```c
> > void exampleFunc(const int n, int x, int y)
> > ```

> [!tip] `0x` prefix
> This prefix states to the compiler that the number is a **hexadecimal (`base 16`)**
> Does not affect the variable's operation/behaviour
> ```c
> int a = 0xFFF; // 256
> int b = 0x005; // 5
> int c = 0xA4; // 164
> ```

> [!tip] `0b` prefix
> This prefix states to the compiler that the number is a **binary (`base 2`)**
> Does not affect the variable's operation/behaviour
> ```c
> int a = 0b101; // 5
> int b = 0x11010; // 25
> int c = 0x100; // 4
> ```

---
#### Signed Datatypes

| Name          | Format Specifier | Size (bytes) | Range            | Additional Notes                                                                             |
| :------------ | :--------------- | :----------- | :--------------- | :------------------------------------------------------------------------------------------- |
| char          | `%c`             | 1            | -128 to +127     |                                                                                              |
| short int     | `%hd`            | 2            | -32768 to +32767 |                                                                                              |
| int           | `%d`             | 4            | ±2^31<br>        |                                                                                              |
| long int      | `%ld`            | 4            | ±2^31            | Usually longer, for modern C/C++ essentially same as `int`                                   |
| long long int | `%lld`           | 8            | ±2^63            |                                                                                              |
| float         | `%f`             | 4            | ±3.4e38          | Can be **mantissa (eg: +3.4e38)** <br>But +- signs are mandatory Trades precision with range |
| double        | `%lf`            | 8            | ±1.8 × 10³⁰⁸     | Supports values such as `±0`, `±∞` and `NaN` (not a number)                                  |
| long double   | `%Lf`            | 10           | ±1.18 × 10⁴⁹³²   | Supports values such as `±0`, `±∞` and `NaN` (not a number)                                  |

#### Unsigned Datatypes

More range on positive side, does not support negative

| Name          | Format Specifier | Range (0 up to) |
| ------------- | ---------------- | --------------- |
| unsigned char | `%c` *or* `%hhu` | 255             |
| short int     | `%hu`            | 65535           |
| int           | `%u`             | 2³²             |
| long int      | `%lu`            | 2³²             |
| long long int | `%llu`           | 2⁶⁴             |

---
### Storage Classes

| Name      | Keyword    | Storage       | Initial Value | Scope        | Life End             | Additional Notes                        |
| --------- | ---------- | ------------- | ------------- | ------------ | -------------------- | --------------------------------------- |
| Automatic | `auto`     | RAM           | Garbage       | Local        | Out of Local         | Default Storage Class                   |
| Register  | `register` | CPU Registers | Garbage       | Local        | Out of Local         | If CPU Registers filled, acts as `auto` |
| Static    | `static`   | RAM           | 0             | Local        | Throughout Execution | Retains Value across function calls     |
| Global    | `---`      | RAM           | 0             | Global       | Throughout Execution | Accessible across whole program         |
| Extern    | `extern`   |               | 0             | Across Files | Throughout Execution | Accessible across multiple files        |

> [!important] #### Volatile Modifer
> The `volatile` keyword prefixed to a datatype specifies the compiler to NOT optimize that variable as it may be dealt with by external programs
> > eg: `volatile short int n;` 

---
## Pre Processor Directives

---

### Libraries
Libraries in C are officially called `C Header` files 
##### Important Built-in Libraries
```c
<stdio.h> // scanf(), printf()
<stdlib.h> // malloc(), other essential functions
<math.h> // math functions
<time.h> // time-based functions
<string.h> // string helper functions
```

To include header files, 2 options can be used
`#include <mylib.h>` = Searches for file in specified directories
`#include "mylib.h"` = Also searches in current directory

---
### Macros

Macros are pieces of code `#define`d and are basically behave like inline functions.
```c
#define PI 3.14
#define TRIANGLE_SEMI_PERIMETER(a, b, c) ((a + b + c)/2)

// Multi-Line
#define PRINT_COORDINATES(x, y) \
    do { \
        printf("X-axis: %d\n", x); \
        printf("Y-axis: %d\n", y); \
    } while(0)

...
sp = TRIANGLE_SEMI_PERIMETER(3, 4, 2);
PRINT_COORDINATES(3, 2);
...
```


> [!question] When to use instead of other features?
> - Constants like $\pi$, $e$
> - Quick Reusable Logic
> - When Pre-Processing is needed
> - When [[#Conditional Compilation]] with its own variables is needed

> [!caution] Drawbacks
> - Not type-safe
> - Less debuggable
> - Alternatives are better, unless preprocessing is really needed

---
### Conditional Compilation

Certain bits and pieces of code are only compiled if its specified criteria is met

```c
#include <stdio.h>

int main() 
{
#if defined(_WIN32)
    printf("Running on Windows\n");
#elif defined(__linux__)
    printf("Running on Linux\n");
#else
    printf("Other OS\n");
#endif
    return 0;
}
```

1. `if` - works like `if ()`
2. `ifdef` `macroname` - If `macroname` is defined, evaluates to true
3. `ifndef` `macroname` - If `macroname` is not defined, evaluates to true
4. `elif` - works like `else if ()`
5. `else` - works like `else`
6. `endif` - Denotes end of conditional block
7. `undef` - Undefines a defined name

#### Pragma

`#pragma` is also another branch of conditional compilations
1. `pragma startup` - Statements executed on **program startup**
2. `pragma exit` - Statements executed on **program end**
3. `pragma warn` - Tells the compiler to suppress a specific warning or error. Usually used in niche situations

A `-` sign before exact error code tells the compiler to suppress it while `+` sign tells it to flash it on compilation

```c
#pragma warn -rvl //Return Value
#pragma warn -par //Parameter not used
#pragma warn -rch //Unreachable Code
```

---
## Other

---

### `argc` and `argv` 

If we intend to pass arguments to the program right on execution, we can do that using `argc` and `argv`
```bash
C> cd ???
C> gcc .\code.c
C> .\program file1.txt file2.txt
```

Requires `<stdlib.h>` 

`argc` is the number of arguments passed
`argv` is an array of pointers to strings of the actual arguments
```c
int main(int argc, char *argv[])
{
	*code that copies contents of file1.txt to file2.txt*
}
```

**Recommended to check if `argc` matches the expected number of arguments.**

---

