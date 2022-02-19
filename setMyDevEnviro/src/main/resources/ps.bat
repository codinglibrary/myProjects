%%echooff
set /P key=<.\src\main\resources\key.txt
set /P value=<.\src\main\resources\value.txt
setx -m %key% %value% 