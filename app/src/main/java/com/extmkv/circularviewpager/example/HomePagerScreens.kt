package com.extmkv.circularviewpager.example

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

/**
 * Home screens
 * Use this enum to add and remove pages in the base navigation.
 *
 * @param title The string resource of screen's title.
 * @param fragment The fragment's class associated to the page.
 */
enum class HomePagerScreens(@StringRes val title: Int,
                            val fragment: KClass<out Fragment>) {

    HOME_1(R.string.home_1, FragmentHome::class),
    HOME_2(R.string.home_2, FragmentHome::class),
    HOME_3(R.string.home_3, FragmentHome::class)
}