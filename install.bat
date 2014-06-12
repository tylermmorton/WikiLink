@ECHO OFF
title Press any key to compile mod from sources...
echo  ================================
echo  CONFIGURES ECLIPSE PROJECT FILES
echo  ================================
pause
title Building Mod From Sources...
gradlew cleanCache --refresh-dependencies setupDecompWorkspace setupDevWorkspace eclipse build
pause