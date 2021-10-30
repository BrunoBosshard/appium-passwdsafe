# appium-passwdsafe
An example Appium mobile test automation project for Google Android

## About

The Android app "PasswdSafe" is a port of the popular free and open source password manager program "Password Safe" to Android. PasswdSafe allows you to safely and easily create a secured and encrypted user name/password list. With PasswdSafe all you have to do is to create and remember a single "Master Password" of your choice in order to unlock and access your entire user name/password list.

PasswdSafe supports viewing and editing of Password Safe data files. You can therefore exchange your data files between your Personal Computer and your Android device.

The PasswdSafe app can be installed on your Android device from the Google Play store.

The app and the source code can also be downloaded from: https://sourceforge.net/projects/passwdsafe/


## What the PasswdSafe example does

The PasswdSafe example project first creates an empty password file and then deletes the newly create file.


## Using the PasswdSafe example

The example already includes the PasswdSafe app itself (the APK package), as well as the corresponding full source code. Both are located in the "apps" folder.

The PasswdSafe app gets automatically deployed on the (real or virtual) device.

Please note that you will have to change the "device" and "udid" settings in the "AndroidSetup.java" file to match your setup.

You can run the example from command line:

    mvn clean verify
