#!/bin/bash

while true; do
  clear
  echo "<------------BASH SHELL COMMAND GUIDE------------>"
  echo "  0) PROLOGUE    - Know abit about BASHell and stuff"
	echo ""
  echo " [FILE & DIRECTORY]"	
  echo "  1) pwd         - Print Working Directory"
  echo "  2) ls          - List Files & Directories"
  echo "  3) cd          - Change Directory"
  echo "  4) touch       - Create File"
  echo "  5) mkdir       - Make Directory"
  echo "  6) rm          - Remove File or Directory"
  echo "  7) rmdir       - Remove Empty Directory"
  echo "  8) cp          - Copy Files/Directories"
  echo "  9) mv          - Move / Rename Files"
  echo " 10) chmod       - Change File Permissions"
  echo " 11) zip         - File Compression"
  echo " 12) unzip       - File Decompression"
  echo " 13) tar         - File Archiving"
  echo ""
  echo " [TEXT DISPLAY]"
  echo " 14) echo        - Print Text to Terminal"
  echo " 15) cat/tac     - Concatenate & Reverse Display"
  echo " 16) less        - Interactive Page Viewer"
  echo " 17) head/tail   - Preview First/Last Lines"
  echo ""
  echo " [TEXT FILTERING]"
  echo " 18) grep        - Global Regular Expression Print"
  echo " 19) cut         - Column Extractor"
  echo " 20) sort        - Sort Text Lines"
  echo " 21) uniq        - Filter Duplicate Adjacent Lines"
  echo " 22) wc          - Word, Line & Character Counter"
	echo ""
  echo " [COMMAND HANDLING]"
	echo " 23) Command Redirection"
	echo " 24) Command Chaining"
	echo " 25) Command Precedence and Subshells"
	echo ""
	echo " [SCRIPTING]"
	echo " 26) PROLOGUE - SCRIPTING"
	echo " 27) Variables"
	echo " 28) Comparison"
	echo " 29) Conditionals"
	echo " 30) Loops"
	echo " 31) Script Arguments"
	echo " 32) Background Execution"

  read -r -p "Enter your choice (0-32): " choice

  case "$choice" in
		0)
			clear
			cat << 'EOF'
Shell is the command line tool that acts as the main terminal/interface Unix systems like Linux. This is a guide on how to use the the shell.

BASH Shell (Bourne Again Shell) will be used for this guide, as it is the most popular shell. Although most if not all commands listed here run on most UNIX shells like `Zsh`.

Even Powershell can often run many of the commands listed down below

TIPS
- Case Sensitive
-  Most commands itself are lowercase
- "quotes" are required if spaces are present in directory/file names. although it is generally discouraged in Linux, _ or - are recommended instead (snake or kebab case)
- # are used for comments in scripts as well as terminals
- . is used to represent current directory
- cmd [flags] arguments
- No Dedicated Multi-Line Comment Syntax like /*cmnt*/

COMMAND SUMMARY

- pwd - Print Working Directory
- ls - List content of directory
- ls -la - List everything, hidden, permissions, timestamps, etc
- echo - Display/Write provided parameters
- cd - Change Directory
- touch - Make File, update timestamp if present
- mkdir - Make folder
- rm - Remove file
- rmdir - Remove Folder
- cp - Copy material
- mv - Move material
- cat - View file content
- vi - Open VI text editor (Linux default)

FLAGS/OPTIONS
In-built-command-Flags in Linux are preceded by a - (hyphen) (convention wise) and come after the command and before the arguments.
Long versions of flags are preceded by -- (double hyphen)
eg: -v --version` `-h --help

They are case insensitive EXCEPT for -r and -R in the ls command

HYPHEN CONVENTION
Putting - for short options and -- for long options is mere recommended development convention for commands. It may not always be the case

[-f] AND [-flags]
[-f] in this guide  for the general syntax example part is a placeholder for flags/options, not the -f flag unless specifically mentioned

**FLAG COMBINATION**
Flags can be clustered like -abc as well as individuallly like -a -b -c
**Flag order and clustering matters usually when flags themselves also take arguments**

**MAJOR FLAGS**
- -r : Recursive Flag, used most often for dealing with directories
- -la : List every detail with ls

Flags can be combined, for example
```shell
ls -l -a 
ls -la
ls -al
``` 
SHORTCUTS

1. CTRL + C - Interrupt Command
2. CTRL + L or clear - Clear screen
3. Tab - Autocomplete Command
4. CTRL + Z - Suspend Task
EOF
		;;
    1)
      clear
      cat << 'EOF'
			
[pwd] Print Working Directory
------------------------------------------------
Prints the current directory in /tmp/user/home format.
EOF
    ;; # basically break; for switch case but for bash
    2)
      clear
      cat << 'EOF' # print everything until EOF is seen, basically multiple kinda string, called as "heredoc"
[ls] List Files
------------------------------------------------
Lists the current files in directory. Features a wide variety of flags which increase the utility of this command by alot.

COLOR CODING:
- Directories: Blue
- Shell Scripts w/ execution perms: Green
- Compressed/Archived Files (.zip): Red

COMMON FLAGS:
- -l : List all permissions, backlinks, owner, group, size, timestamp
- -a : Lists all hidden files as well
- -m : Comma separate the directories
- -A : Like -a but excludes current (.) and parent (..) directory entries

This is the only place where flags r case sensitive (at least on unmodded vanilla BASH commands)
- -r : Reverse order
- -R : Recursive listing of all subfolders
EOF
    ;;
    3)
      clear
      cat << 'EOF'
[cd] Change Directory
------------------------------------------------
Changes current directory based on provided path.
It is assumed that cd will be from the current directory

SHORTCUTS:
- cd ~ or cd   : Return to home directory
- cd ..        : Move up a directory level
- cd -         : Return to previous directory
- cd .         : Right here (current directory)
- cd f-a/f-b   : Go into f-b which is inside f-a which is inside current directory

EXAMPLES:
  cd "folder one/folder two"
  cd ../.. 
  cd "../A 1/B 2/../G 3"
  cd ~/some-folder
EOF
    ;;
    4)
      clear
      cat << 'EOF'
[touch] Create File
------------------------------------------------
Touch command is primarily used to create new files.
Although it can also be used to update the last modified timestamp of already existing files.

EXAMPLES:
  touch file.txt
  touch code.cpp
EOF
    ;;
    5)
      clear
      cat << 'EOF'
[mkdir] Make Directory
------------------------------------------------
Makes, a directory

SYNTAX: mkdir dir-name
EOF
    ;;
    6)
      clear
      cat << 'EOF'
[rm] Remove File Or Directory
------------------------------------------------
Removes files or directories. 
rm -r is used to delete non-empty directories

FLAGS:
- -r : Recursively delete even non-empty directories
- -f : Force deletion even if write-protected

EXAMPLES:
  rm fl.txt
  rm -r non_empty-dir-name
  rm -f nuke-this-file.txt
  rm -rf nuke-this-directory
EOF
    ;;
    7)
      clear
      cat << 'EOF'
[rmdir] Remove Empty Directory
------------------------------------------------
Removes an empty directory. Use rm -r for non-empty ones.

SYNTAX: rmdir empty-dir-name
EOF
    ;;
    8)
      clear
      cat << 'EOF'
[cp] Copy Files/Directories
------------------------------------------------
Copies contents someplace else. Source comes before Destination.
-r flag required for folders.

When Copying Directories...
The final name is the new name of the directory that is copied
For files, name is the same unless specified at end

FLAGS:
- -i : Interactive Mode (asks for confirmation before overwriting)
- -v : Verbose (prints files being copied)
- -ar: Archive flag for directory (preserves timestamps, file perms, backlinks etc)

EXAMPLES:
  cp code.cpp coding/cpp/backups
  cp -r secret-files backup
  cp f-a.txt f-b.txt f-c.txt ../sibling
  cp fl.txt /one-folder-in/fl-fl.txt
	cp -r assets/ ../backups # Copies assets into a sibling directory backups, which now has a child called assets. If assets existed it will be merged with the new assets (i.e. files with same name are overwritten, old ones with no new replacement remain)
EOF
    ;;
    9)
      clear
      cat << 'EOF'
[mv] Move or Rename
------------------------------------------------
Moves the contents of a file/directory someplace else. Source comes before Destination in arguments. -r flag is unnecessary here as it simply updates the path data.

It is also used to rename files by providing only a single argument.

FLAGS:
- -i : Interactive Mode
- -v : Verbose

EXAMPLES:
mv folder-a folder-b/folder-c/ # moves a 2 levels down into c
mv file-a.txt file-b.txt       # renames file-a.txt as file-b.txt
mv f-a.txt f-b.txt folder-d/   # moves f-a.txt and f-b.txt into folder-d
mv exampl-dir code.py testing/ # moves exampl-dir and code.py into testing
EOF
    ;;
    10)
      clear
      cat << 'EOF'
[chmod] Change Mode
------------------------------------------------
Used to change file permissions of read, write and execute for users, group and others
2 syntaxes can be used to modify permissions.

SYMBOLIC MODE:
- Users: u (user), g (group), o (others), a (all)
- Perms: r (read), w (write), x (execute)
  Example: chmod u+rw file.txt | chmod og-x script.sh

OCTAL MODE:
  r=4, w=2, x=1
	These numbers are added in the combination of permissions for users, groups and others respectively as all will result in a unique combination thanks to the laws of the number system.
  Example: chmod 755 a.txt (user all, group and others read and execute)
           chmod 460 b.txt (user read, group read and write, others no perms)
EOF
    ;;
    11)
      clear # code is property of bunnerman
      cat << 'EOF'
[zip] File Compression
------------------------------------------------
Used to compress files/directories into `.zip` files
It also copies the redundant file paths one types when unzipped, so `cd` into directory to avoid hassle

FLAGS:
- -r : Required for compressing directories
- -d flag changes the entire command's purpose to allow for deletion of a specific file without unzipping the whole thing

EXAMPLES:
  zip -r backup.zip my-project
  zip -d backup.zip unwanted-file.txt
EOF
    ;;
    12)
      clear
      cat << 'EOF'
[unzip] File Decompression
------------------------------------------------
Decompresses/extracts .zip files. Use -d to specify a target folder apart from current directory.

EXAMPLES:
  unzip extract-right-here.zip
  unzip backups.zip /dir-a/dir-b/dir-c/
EOF
    ;;
    13)
      clear
      cat << 'EOF'
[tar] File Archiving
------------------------------------------------
Used to archive entire directories and its subdirectories into a `.tar` archive file. This does not compress them.

FLAGS:
-f must be last when clustering flags like -cvf. Filename comes directory after -f

- -c : Create new archive
- -x : Unpack archive
- -f : Filename (practically necessary)
- -z : Compress using gzip (.tar.gz)
- -v : Verbose

EXAMPLE:
  tar -cf folder/to/archive/into/newArchiveName.tar folder/to/archive
EOF
    ;;
    14)
      clear
      cat << 'EOF'
[echo] Print Text
------------------------------------------------
A basic command which simply prints to terminal whatever was provided to it with a automatic new line at the end.

FLAGS:
- -n : Removes newline at end
- -e : Enables use of escape sequences like \n \t

EXAMPLE:
  echo -en "Hello\nWorld"
EOF
    ;;
    15)
      clear
      cat << 'EOF'
[cat] Concatenate
------------------------------------------------
Reads files and writes to terminal screen. Can also concatenate content to/from files/streams.

FLAGS:
- -n : Print line numbers as well

EXAMPLES:
  cat file.txt file-2.txt
  cat -n file.txt

tac prints in reverse order (mirror of cat, same convention is followed in alot of places in shell, like fi and esac for if and case)
EOF
    ;;
    16)
      clear
      cat << 'EOF'
[less] Interactive Page Viewer
------------------------------------------------
Loads files page-by-page for larger files. more is the older less capable predecessor command

NAVIGATION:
- f PgDn Space      : Next Page
- b PgUp            : Previous Page
- g Home            : Beginning of File
- G End             : End of File
- / + txt + enter   : Search forwards (n for next, N for previous)
- ? + txt + enter   : Search backwards

TOGGLES & EXIT:
- N : Toggle Line Numbers
- q, ZZ : Quit less
EOF
    ;;
    17)
      clear
      cat << 'EOF'
[head] [tail] Previews
------------------------------------------------
Prints first/last n lines of file. Default is 10

COMMON FLAGS:
- -n ??    : First/Last ?? lines
- -c ??    : First/Last ?? bytes
- -q       : Quiet mode (hides file headers)
- -v       : Verbose mode (always shows file headers)

TAIL SPECIFIC:
- -f       : Follow flag (updates live as new lines are written, CTRL+C to exit)
- -n + ??  : Starts at line ?? and prints until end

EXAMPLES:
  head data.csv
  tail -n 20 testingV4/data/d2.csv
  tail -f errors.log
  head -n 20 fl.txt | tail -n 11
EOF
    ;;
    18)
      clear
      cat << 'EOF'
[grep] Global Regular Expression Print
------------------------------------------------
Searches text using Regex Patterns and prints matching to STDOUT
If argument not provided STDIN is used

MATCHING & SENSITIVITY:
- -i : Ignore Case
- -v : Invert Match (Opposite Behavior)
- -w : Word Match
- -x : Exact Line Match

OUTPUT & CONTEXT:
- -n                     : Prefix with line number
- -c                     : Output occurrence count only
- -o                     : Print exact matched expression only
- -B [n], -A [n], -C [n] : Print n lines before, after, or around match

MISC:
- -r : Recursive search
- -E : Enable Extended Regular Expressions
- -p : Perl Compatible Regex, enables use of PCRE engine for more advanced stuff
EOF
    ;;
    19)
      clear
      cat << 'EOF'
[cut] Column Extractor
------------------------------------------------
Used for extracting certain columns from structured text like for example .csv or .json
Supports multiple files at once

FLAGS:
- -d     : Delimiter (specifies column separating character)
- -f     : Fields (specifies 1-indexed column numbers to extract)
- -c     : Characters (cuts by character position)
- -c M-N : Extracts characters from m to n instead, altered behavior

LIMITATION: Cannot handle variable whitespaces nicely, bad for human readable file formats wit padding and stuff

EXAMPLES:
  cut -d ',' -f 1,3 /archives/data.csv
  cut -c 1-4 /archives/data.csv
EOF
    ;;
    20)
      clear
      cat << 'EOF'
[sort] Sorting
------------------------------------------------
Reorders text lines alphabetically, numerically, etc.

FLAGS:
- -r             : Reverse order
- -n             : Numeric sort (so 10 after 2 issue not present from alphabetical)
- -u             : Remove duplicate lines
- -k [field]     : Sort based on specific column
- -t [delimiter] : Define column separator when spaces/tabs isn't the separation

EXAMPLES:
  sort -r -n fl.txt
  sort -k petal_length -t ','
EOF
    ;;
    21)
      clear
      cat << 'EOF'
[uniq] Unduplicate
------------------------------------------------
Filters out duplicate adjacent lines. Chain with sort to get dupes next to each other.

FLAGS:
- -c : Prefix with count of occurrences

EXAMPLE:
  cat fl.txt | sort | uniq -c
EOF
    ;;
    22)
      clear
      cat << 'EOF'
[wc] Word and Line Counter
------------------------------------------------
Counts words, lines, characters, and bytes.

FLAGS:
- -w : Words
- -l : Lines
- -m : Characters
- -c : Bytes

EXAMPLE:
  cat fl.txt | wc -w # number of characters
EOF
    ;;
		23)
			clear
			cat << 'EOF'
[COMMAND HANDLING] Redirection
------------------------------------------------
STDOUT STDIN STDERR here may not necessarily be from terminal, as they can redirect from output, input and error streams returned from the left side which r not technically STDOUT as they are not from terminal itself but from left hand side command
>  Truncate       : Truncates content of STDOUT (overwrites existing completely).
>> Append         : Appends content of STDOUT
<  Input Redirect : Redirects commands which usually require `STDIN` to instead get its input from provided file.
2> Error Redirect : Redirects STDERR
&> All Redirect   : Redirects both STDOUT and STDERR

EXAMPLES:
echo Hello > fl.txt
echo " World" >> fl.txt
sort < unsorted.txt
CMD 2> error-log.txt
CMD &> all-output.txt
EOF
		;;
		24)
			clear
			cat << 'EOF'
[COMMAND HANDLING] Command Chaining
------------------------------------------------
STDOUT STDIN STDERR here may not necessarily be from terminal, as they can redirect from output, input and error streams returned from the left side which r not technically STDOUT as they are not from terminal itself but from left hand side command
|  Pipeline             : Chains STDOUT of LHS command and passes it as STDIN of command on RHS. Can be chained multiple times
;  Sequential Execution : Runs next command(s) after previous ones regardless of they were successful or not
&& Conditional AND      : Runs next command(s) if previous ones were successful
|| Conditional OR       : Runs next command if previous one threw an error
EOF
		;;
		25)
			clear
			cat << 'EOF'
[COMMAND CHAINING] Command Precedence and Subshells
------------------------------------------------
{ ;} are used for command precedence, basically like parentheses for equation evaluation. These can be nested

- Any changes like cd made in here WILL affect main shell/terminal
- They require a space after opening brace and a ; (semicolon) before closing brace.
EXAMPLE: { rmdir dir-a && echo "Empty";} || { rm -r dir-a && echo "Not Empty";}

Precedence Rules (Highest to Lowest)

() { ;} Subshells and Command Precedence Braces
> >> < 2> &> Redirections
| |& Pipelines
&& || Logical AND OR
; & Semicolon and Background Execute

[SUBSHELLS]
Subshells are child instances of the shell. They execute a command or group of commands when wrapped with in parentheses.

- Subshells have a copy of current environment of parent shell on creation
- But changes like cd and child variables are discarded after returning to main shell

EXAMPLE:
pwd # prints dir-a
x="hello" 
( x="world"; echo "Inside: $x"; cd dir-b )
echo "Outside: $x" # world hello
pwd # still prints dir-a
EOF
		;;
		26)
			clear
			cat << 'EOF'
[SCRIPTING PROLOGUE AND INFORMATION]
------------------------------------------------
BASH may not seem like it has the features of a general programming language but has the ability to support scripts which may be available to achieve that basic behavior.
These have the extension .sh and are executed using ./name.sh

Shells have a identifying line at the very top of the file called as a shebang #! which specifies parameters. To run using bash use #!/bin/bash at the very start to specify the shell to directly as Bash, as that its path

To run an executable file, it must have execution permissions using chmod
Use ./flName.exe to run it (./ at the start)

#!/bin/bash
var_name="Hello World"
echo ${var_name}

FEATURES OF SHELL SCRIPTS
- Variables
- Comparison Operators (basic)
- Conditionals
- Loops
- Script Arguments
EOF
		;;
		27)
			clear
			cat << 'EOF'
[SCRIPTING] Variables
------------------------------------------------
Variables are declared normally using following syntax: var_name=var_value
Everything by default is treated like a string, but arrays and key-maps can be used too.
Arithmetic operations are done by using $(()) or declare

EXAMPLE:
var_a="hello world"
var_b=5
var_c=5
echo $var_a
echo $((var_b + var_c)) # will output 10
EOF
		;;
		28)
			clear
			cat << 'EOF'
[SCRIPTING] Comparison
------------------------------------------------
[] are often used for comparison evaluation
They return booleans

ARITHMETIC
[ $a -eq $b ]   # == Equal 
[ $a -ne $b ]   # != Not Equal
[ $a -gt $b ]   # >  Greater Than
[ $a -lt $b ]   # <  Less Than
[ $a -ge $b ]   # >= Greater Than or Equal To
[ $a -le $b ]   # <= Less Than or Equal To

STRINGS
[ "$a" = "$b" ]   # Equal
[ "$a" != "$b" ]  # Not Equal
[ -z "$a" ]       # If string is empty
[ -n "$a" ]       # If string isn't empty

OTHER
[ -f "file.txt" ]    # If exists and is regular file
[ -d "directory" ]   # If exists and is directory
[ -e "path/to/it" ]  # If exists
[ -s "file.txt" ]    # If exists and isn't empty
EOF
		;;
		29)
			clear
			cat << 'EOF'
[SCRIPTING] Conditionals
------------------------------------------------
if [ "$my_var" = "hello" ]; then
    echo "Match found"
elif [ "$my_var" = "world" ]; then
    echo "Alternative match"
else
    echo "No match"
fi

- if fi : If
- elif : Else If
- else : Else

fi is used to denote end of an if block or its conditional chain
EOF	
		;;
		30)
			clear
			cat << 'EOF'
[SCRIPTING] Loops
------------------------------------------------
for fl in *.txt; do
	echo "Txt File: $fl"
done

- for : For Loop
- in : Container-ish
- do : Execute next commands
- done : Closing of Loop
EOF
		;;
		31)
			clear
			cat << 'EOF'
[SCRIPTING] Script Arguments
------------------------------------------------
$1 $2.. : Position Arguments passed to script
$# : Total Number of Arguments
$@ : All arguments as list
$0 : Name of script
EOF
		;;
		32)
			clear
			cat << 'EOF'
[SCRIPTING] Background Tasks
& Background Execute Operator runs command in background, thus freeing terminal up for new commands

EXAMPLE:
python code.py & (training ML Model)
------------------------------------------------		
EOF
			;;
    *) # * = anythin else, basically default
      echo -e "\nbad number, insert valid range"
      ;;
  esac # mirror of case

  echo -e "\n------------------------------------------------"
  read -r -p "ENTER to return to menu"
done
