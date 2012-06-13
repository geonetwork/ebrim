@echo off
setlocal
set home=%~dp0
if exist "%home%setenv.bat" call "%home%setenv.bat"
set cp="%home%\resources"
for %%a in ("%home%\dist"\*.jar) do call :addtocp "%%~fa"
for %%a in ("%home%\lib"\*.jar) do call :addtocp "%%~fa"
set java="%JAVA_HOME%\bin\java.exe"
if not exist %java% set java=java
%java% -cp %cp% com.occamlab.te.Test -cmd=%0 %*
endlocal
goto:eof


:addtocp
set cp=%cp%;%1