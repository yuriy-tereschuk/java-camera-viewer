# Define the path to your JAR file
$jarFilePath = "C:\Users\astro\Projects\java-camera-viewer\app\build\libs\app-1.0.0-all.jar"

# Define any arguments you need to pass to the Java application
$javaArguments = "ua.myhome.camera.viewer.App" # Optional

# Construct the full command
$command = "--enable-native-access=ALL-UNNAMED -jar `"$jarFilePath`" $javaArguments"

# Execute the command
# Invoke-Expression $command
Start-Process -FilePath "java.exe" -ArgumentList $command -NoNewWindow
