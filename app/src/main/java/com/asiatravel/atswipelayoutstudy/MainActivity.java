package com.asiatravel.atswipelayoutstudy;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SwipeRefreshLayout mSwipeLayout;
    private Handler mHandler = new Handler();
    private TextView mIndexView;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        mIndexView = (TextView) findViewById(R.id.index_textView);

        initSwipeLayout();
    }

    private void initSwipeLayout() {
        mSwipeLayout.setSize(SwipeRefreshLayout.DEFAULT);
        mSwipeLayout.setColorSchemeColors(getResourceColor(R.color.colorAccent),
                getResourceColor(R.color.colorGreen),
                getResourceColor(R.color.colorGray));
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                i++;
                Log.d(TAG, "onRefresh: did-->" + i);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mIndexView.setText("第 " + i + " 次刷新");
                                mSwipeLayout.setRefreshing(false);
                            }
                        });

                    }
                }).start();
            }
        });
    }

    private int getResourceColor(int resourceId) {
        return getResources().getColor(resourceId);
    }
}
