# Number trivia


## Level 6 Questions

### Explain what a Fragment is in Android, and why a fragment is useful to include in the design of your app.

* A fragment is usually used as part of an activity's user interface and contributes its own layout to the activity.
* https://developer.android.com/guide/components/fragments

### Explain what a tabbed activity is in Android, and how a fragment is used in a tabbed activity.


A tabed activity is a activity that uses a tab navigations to switch between fragments.

###  Why don’t you need to declare a fragment inside your Manifest?

Because the fragment is not used directly but always via a activity.

### What Java class needs to be extended, in order to create a fragment?

```java
import android.support.v4.app.Fragment;

public class MyFragment extends Fragment {
}

```

###  How do you communicate from one fragment to another fragment?


```
MyFragment fragment = (MyFragment) getSupportFragmentManager()
						.findFragmentById(R.id.myfragment_fragment);
						
fragment.updateText(text);
```

###  In the lifecycle of a fragment, what method is called as soon as the view is visible?

```
onCreateView();

```


###  Is it possible to access a fragment, even if the lifecycle of its host activity has ended? Explain why.

* No fragments are managed by the host activity.


###  A record of all Fragment transactions is kept for each Activity by the FragmentManager. Why can this be useful?

* If you need to return a few steps.

