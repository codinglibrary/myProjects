set /P key=<key.txt
set /P value=<value.txt
setx -m %key% %value% 