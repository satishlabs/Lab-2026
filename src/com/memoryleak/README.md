# Java Memory Leak Demos

Package: `com.memoryleak`  
Path: `E:\Dev\Lab-2026\src\com\memoryleak`

## Run in IntelliJ

1. Open class `com.memoryleak.LeakDemo`
2. Run `main`
3. Enter `1`–`6`, or add program argument `1`

VM option (recommended): `-Xmx256m`

## Run from terminal

```powershell
cd E:\Dev\Lab-2026
javac -d out\production\Lab-2026 src\com\memoryleak\*.java
java -Xmx256m -cp out\production\Lab-2026 com.memoryleak.LeakDemo 1
```

## Validate

Watch console `used=… MB` climb after `System.gc()`. Optional:

```powershell
jps -l
jcmd <pid> GC.class_histogram | Select-String "memoryleak|Leaky|Dashboard|ClientSession"
```
