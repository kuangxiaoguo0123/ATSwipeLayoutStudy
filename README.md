# ATSwipeLayoutStudy
Android中SwipeRefreshLayout的使用

# ScreenShots
![](https://github.com/kuangxiaoguo0123/ATSwipeLayoutStudy/blob/master/screenshots/refresh.gif)

# xml使用
````
<android.support.v4.widget.SwipeRefreshLayout
        android:id="@+id/swipeLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <TextView
            android:id="@+id/index_textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:text="0"
            android:textSize="18sp" />
</android.support.v4.widget.SwipeRefreshLayout>
````
