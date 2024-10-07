package com.example.kuit4androidprivate.home

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalSpacingItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.right = space
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = space
        }
    }
}
