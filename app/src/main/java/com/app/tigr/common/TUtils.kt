package com.app.tigr.common

import android.content.Context
import android.util.TypedValue
import android.content.Intent
import android.support.v4.app.Fragment
import android.net.ConnectivityManager
import com.app.tigr.App

/**
 * Various functions for this application
 */
object TUtils {

    /** Calculate dp in the device  */
    fun setDp(num: Float): Int {
        val scale = getContext().resources.displayMetrics.density
        return (num * scale + 0.5f).toInt()
    }

    fun convertDpToPx(dp: Float) = convertUnit(TypedValue.COMPLEX_UNIT_DIP, dp)

    fun convertSpToPx(sp: Float) = convertUnit(TypedValue.COMPLEX_UNIT_SP, sp)

    private fun convertUnit(unit: Int, value: Float): Int {
        return TypedValue.applyDimension(unit, value, getContext()
                .resources.displayMetrics)
                .toInt()
    }

    fun convertDpToSp(dp: Float) = (convertDpToPx(dp) / convertSpToPx(dp).toFloat()).toInt()

    /** Execute exit from a program */
    fun exitProgram(context: Context) {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(a)
    }

    /** Check if an [element] is Fragment*/
    fun checkFragment(element: Any): Fragment {
        if (element is Fragment) {
            return element
        } else throw TypeCastException()
    }

    fun isNetworkAvailable(): Boolean {
        val cm = getContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val netInfo = cm!!.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }

    private fun getContext() = App.appComponent.getContext()
}
