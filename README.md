
The application file has two parts, one is the source code of the Ardinuo and the other is the android application source code.
The datatocloud-master directory contains the source code of hardware programs and the programs to upload data to cloud.
The android application will work only when the internet and GPS is working. Since we have encountered problems with Github the java class files are stored in a separate folder with the name javafiles. Copy the java files into the currentplacedetailsonmap directory to obtain the correct file structure.


Google Maps Android API Sample: Current Place Details
=====================================================

Prerequisites
--------------

- Android SDK v24
- Latest Android Build Tools
- Android Support Repository

Getting started
---------------

This sample uses the Gradle build system.

1. Download the samples by cloning this repository or downloading an archived
  snapshot. (See the options at the top of the page.)
1. In Android Studio, create a new project and choose the "Import non-Android Studio project" or
  "Import Project" option.
1. Select the `CurrentPlaceDetailsOnMap` directory that you downloaded with this repository.
1. If prompted for a gradle configuration, accept the default settings.
  Alternatively use the "gradlew build" command to build the project directly.
1. Add your API key to your app's `gradle.properties` file.
  (For information on getting an API key, see the
  [documentation](https://developers.google.com/maps/documentation/android-api/signup).)

Support
-------

- Stack Overflow: https://stackoverflow.com/questions/tagged/android+google-maps

If you have discovered an issue with the Google Maps Android API v2, please see
the resources here: https://developers.google.com/maps/documentation/android-api/support

If you've found an error in these samples, please file an issue:
https://github.com/googlemaps/android-samples/issues

![Analytics](https://ga-beacon.appspot.com/UA-12846745-20/android-samples-apidemos/readme?pixel)

License
-------

Please refer to the [LICENSE](https://github.com/googlemaps/android-samples/blob/master/LICENSE) at the root of this repo.
