package com.example.frontend;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NotificationsAdapter adapter;
    private List<Notification> notificationList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notifications);
        // Thiết lập Toolbar
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Thiết lập RecyclerView
        recyclerView = findViewById(R.id.recycler_view_notifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo danh sách thông báo và adapter
        notificationList = new ArrayList<>();
        adapter = new NotificationsAdapter(notificationList);
        recyclerView.setAdapter(adapter);

        // Nạp dữ liệu giả
        loadNotifications();
    }
    private void loadNotifications() {
        // Thêm dữ liệu giả cho danh sách thông báo
        notificationList.add(new Notification("Thông báo 1", "Nội dung thông báo 1", "2023-01-01 10:00"));
        notificationList.add(new Notification("Thông báo 2", "Nội dung thông báo 2", "2023-01-02 11:00"));
        notificationList.add(new Notification("Thông báo 3", "Nội dung thông báo 3", "2023-01-03 12:00"));
        adapter.notifyDataSetChanged();
    }
}