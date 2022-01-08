dim batFile
batFile="open.bat" 
Dim oShell,exeRs
Set oShell = CreateObject("WSCript.shell")
ret = oShell.run(batFile, 0, true)
