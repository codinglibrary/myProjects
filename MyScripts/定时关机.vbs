Dim time,hour,min,sec
sec=InputBox("How many seconds before the shutdown?")
time = calculate(0,0,sec)
IF time=0 Then 
	MsgBox("The time must much than 0,   and will be exit.")
	
Else 
	MsgBox("Shutdown after " & time & " seconds")
	commandLine="shutdown -s -t " & sec
	Dim oShell
	Set oShell=CreateObject("WSCript.shell")
	oShell.run(commandLine)
End IF
Function calculate(arg1,arg2,arg3)
	dim res
	res=arg1*60*60 + arg2*60 + arg3
	calculate=res
End Function