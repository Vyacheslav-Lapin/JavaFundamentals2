@echo off

if not "%COMPILE_TARGET%" == "" goto gotCompileTarget
set COMPILE_TARGET=out

:gotCompileTarget
if not "%SRC_ROOT%" == "" goto gotSrcRoot
set SRC_ROOT=test

:gotSrcRoot
if not "%MAIN_CLASS_PATH%" == "" goto gotMainClass
set MAIN_CLASS_PATH=%SRC_ROOT%\javase01\t01\main\Test1.java

:gotMainClass
javac -d %COMPILE_TARGET% -cp src %MAIN_CLASS_PATH%
