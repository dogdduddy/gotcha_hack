package com.dogdduddy.gotcha_hack.custom

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.Serializable

class MultiTouchView: FrameLayout {

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes)


    override fun onTouchEvent(event: MotionEvent?): Boolean {

        val index = event?.actionIndex ?: 0
        val id = event?.getPointerId(index) ?: 0

        when(event?.actionMasked) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                Log.d("touchTest", "down | x: ${event.x}, y: ${event.x}")
                return true
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                Log.d("touchTest", "up | x: ${event.x}, y: ${event.x}")
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                for (i in 0 until event.pointerCount) {
                    Log.d("touchTest", "move | x: ${event.getX(i)}, y: ${event.getY(i)}")
                }
                return true
            }
            else -> return false
        }
    }

    override fun performClick(): Boolean {
        return super.performClick()
    }

}