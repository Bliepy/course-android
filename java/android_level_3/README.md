# Student portal (portfolio)

## Level 3 Questions

### What is the difference between implicit and explicit intents?

* Explicit intents specify which application will satisfy the intent, by supplying either the target app's package name or a fully-qualified component class name. You'll typically use an explicit intent to start a component in your own app, because you know the class name of the activity or service you want to start. For example, you might start a new activity within your app in response to a user action, or start a service to download a file in the background.
* Implicit intents do not name a specific component, but instead declare a general action to perform, which allows a component from another app to handle it. For example, if you want to show the user a location on a map, you can use an implicit intent to request that another capable app show a specified location on a map.

### What is the difference between Parcelables and Serializables?

* The differce is in the implemenations and performance, Serializables is faster to implement but is slower.
* https://stackoverflow.com/questions/3323074/android-difference-between-parcelable-and-serializable

### What is the purpose of the analyzer?

* Analyser is use to get insight into the composition of the APK.
* https://developer.android.com/studio/build/apk-analyzer