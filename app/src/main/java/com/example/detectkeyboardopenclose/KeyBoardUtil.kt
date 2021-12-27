package com.example.detectkeyboardopenclose

import android.graphics.Rect
import android.view.View
import android.view.ViewTreeObserver

fun View.observeSoftKeyBoardHideAndShow(show: () -> Unit, hide: () -> Unit) : ViewTreeObserver.OnGlobalLayoutListener {
    var lastKeyboardState = KeyboardState.HIDE
    val globalListener = ViewTreeObserver.OnGlobalLayoutListener {
        val keyboardState = getKeyboardState()
        // 대략 키보드 비율 0.15
        if (keyboardState == lastKeyboardState)
            return@OnGlobalLayoutListener
        lastKeyboardState = if(keyboardState == KeyboardState.SHOW){
            show()
            KeyboardState.SHOW
        } else{
            hide()
            KeyboardState.HIDE
        }

    }
    viewTreeObserver.addOnGlobalLayoutListener(globalListener)
    return globalListener
}

fun View.getKeyboardState(): KeyboardState {
    val rect = Rect()
    getWindowVisibleDisplayFrame(rect)
    val screenHeight = rootView.height
    val keypadHeight = screenHeight - rect.bottom
    return if (keypadHeight > screenHeight * 0.15) KeyboardState.SHOW else KeyboardState.HIDE
}

enum class KeyboardState{
    SHOW,HIDE
}