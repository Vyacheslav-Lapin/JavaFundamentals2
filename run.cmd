@echo off

if not "%COMPILE_TARGET%" == "" goto gotCompileTarget
set COMPILE_TARGET=out

:gotCompileTarget
if not "%MAIN_CLASS%" == "" goto gotMainClass
set MAIN_CLASS=javase01.t01.main.Test1

:gotMainClass
java -cp %COMPILE_TARGET% %MAIN_CLASS%
