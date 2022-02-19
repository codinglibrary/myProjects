dim key,value
dim fs,ts
dim batFile
Dim oShell,exeRs

set fs=CreateObject("Scripting.FileSystemObject")
set ts = fs.OpenTextFile("value.txt",1,true)
value = ts.ReadLine
set ts = fs. OpenTextFile("key.txt",1,true)
key = ts.ReadLine
ts.close

MsgBox "The follow variable is be set: "& vbcrlf&"=========="&vbcrlf & key &" = " & value


batFile = "ps.bat"

Set oShell = CreateObject("WSCript.shell")
ret = oShell.run(batFile, 0, true)

