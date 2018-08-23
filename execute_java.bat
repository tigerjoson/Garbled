rem chcp 437
chcp 936
pause
javac -encoding utf-8 -d . myjava.java 
javac -encoding utf-8 -Xlint:unchecked -d . file_RW.java 
javac  -encoding  utf-8 -d . work.java 

pause
java  Read_Write_file.work
pause