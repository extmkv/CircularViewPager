# CircularViewPager
A circular ViewPager example using the new `ViewPager2` 

![StackOverflow Question](https://stackoverflow.com/questions/7546224/viewpager-as-a-circular-queue-wrapping)

In this example, will be building a single activity app with `ViewPager2` and a `FragmentPagerAdapter` supporting circular navigation between 3 pages or more. 

I'm using an alpha version of the library `androidx.viewpager2:viewpager2`, but the version `1.0.0-alpha06` is the last one planned before google freezing the API and moving to beta.

![Circular ViewPager](art/circular_viewpager.gif)

**1. Add the `ViewPager2` library to the dependencies in your build.gradle**
```groovy
dependencies {
    implementation 'androidx.viewpager2:viewpager2:1.0.0-alpha06'
}
```

**2. Add the `ViewPager2` view to your project:**
```xml
<androidx.viewpager2.widget.ViewPager2 xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/vwpHome"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```


**3. Create the `FragmentStateAdapter` adapter:**

`getItemCount()` needs to returns a huuuuge number. (2147483647)

`getCenterPage()` returns the central page based on the huuuuge number.
This method is used to get the position of the initial page to set in the `ViewPager2`, in this case the user needs to swipe ˜1073741823 time to reach the end of the `ViewPager2`.

```kotlin
class CircularPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = Integer.MAX_VALUE

    /**
     * Create the fragment based on the position
     */
    override fun createFragment(position: Int) = HomePagerScreens.values()[position % HomePagerScreens.values().size].fragment.java.newInstance()

    /**
     * Returns the same id for the same Fragment.
     */
    override fun getItemId(position: Int): Long = (position % HomePagerScreens.values().size).toLong()

    fun getCenterPage(position: Int = 0) = Integer.MAX_VALUE / 2 + position
}
````
**4. Set the adapter to the ViewPager**
```kotlin
val circularAdapter = CircularPagerAdapter(supportFragmentManager, lifecycle)
vwpHome.apply {
    adapter = circularAdapter
    setCurrentItem(circularAdapter.getCenterPage(), false)
}
```
