package dev.sai.oceanxdesingdemo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var rvOrders: RecyclerView
    private lateinit var orderAdapter: OrderAdapter
    private var orderList = mutableListOf<Order>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Setup RecyclerView
        rvOrders = findViewById(R.id.rvOrders)
        rvOrders.layoutManager = LinearLayoutManager(this)

        // 2. Load dummy data
        loadDummyOrders()
        orderAdapter = OrderAdapter(orderList)
        rvOrders.adapter = orderAdapter

        // 3. Setup click listeners
        setupClickListeners()

        // 4. Set default selection
        findViewById<BottomNavigationView>(R.id.bottomNavigation).selectedItemId = R.id.nav_orders
    }

    private fun loadDummyOrders() {
        orderList.add(
            Order(
                id = "#ORD12345",
                vehicleType = "Four Wheeler",
                date = "05 Feb, 4:46 PM",
                pickup = "741, Gumanwara",
                drop = "00, Main Rd, Shivaji Nagar, Jhansi, Uttar Pradesh 284001, India",
                price = 229.0,
                status = "CANCELLED"
            )
        )
        orderList.add(
            Order(
                id = "#ORD12346",
                vehicleType = "Truck",
                date = "04 Feb, 2:15 PM",
                pickup = "12, MG Road, Bangalore",
                drop = "45, Brigade Road, Bangalore, Karnataka 560001",
                price = 1250.0,
                status = "COMPLETED"
            )
        )
        orderList.add(
            Order(
                id = "#ORD12347",
                vehicleType = "Mini Truck",
                date = "03 Feb, 11:30 AM",
                pickup = "Plot 5, Sector 18, Noida",
                drop = "Tower B, Cyber City, Gurgaon, Haryana 122002",
                price = 650.0,
                status = "COMPLETED"
            )
        )
        orderList.add(
            Order(
                id = "#ORD12348",
                vehicleType = "Four Wheeler",
                date = "02 Feb, 6:00 PM",
                pickup = "Near City Mall, Mumbai",
                drop = "Airport T2, Mumbai, Maharashtra 400099",
                price = 450.0,
                status = "CANCELLED"
            )
        )
    }

    private fun setupClickListeners() {
        // Info banner close
        findViewById<View>(R.id.ivCloseBanner).setOnClickListener {
            findViewById<View>(R.id.infoBanner).visibility = View.GONE
        }

        // Filter button
        findViewById<MaterialButton>(R.id.btnFilter).setOnClickListener {
            Toast.makeText(this,
                "Filter clicked", Toast.LENGTH_SHORT).show()
        }

        // Sort button
        findViewById<MaterialButton>(R.id.btnSort).setOnClickListener {
            Toast.makeText(this,
                "Sort clicked", Toast.LENGTH_SHORT).show()
        }

        // FAB Help
        findViewById<FloatingActionButton>(R.id.fabHelp).setOnClickListener {
            Toast.makeText(this,
                "Help clicked", Toast.LENGTH_SHORT).show()
        }

        // Bottom Navigation
        findViewById<BottomNavigationView>(R.id.bottomNavigation).setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> Toast.makeText(this,
                        "Home", Toast.LENGTH_SHORT).show()
                R.id.nav_orders -> Toast.makeText(this,
                    "Orders", Toast.LENGTH_SHORT).show()
                R.id.nav_payments -> Toast.makeText(this,
                    "Payments", Toast.LENGTH_SHORT).show()
                R.id.nav_account -> Toast.makeText(this,
                    "Account", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}