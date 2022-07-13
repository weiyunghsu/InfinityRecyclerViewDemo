package com.jastzeonic.infinityrecyclerviewdemo

import android.content.res.Resources

fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
