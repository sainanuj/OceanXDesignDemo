package dev.sai.oceanxdesingdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip

class OrderAdapter(private val orders: List<Order>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    // 1. ViewHolder class - holds references to your item_order.xml views
    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivVehicle: ImageView = itemView.findViewById(R.id.ivVehicle)
        val tvVehicleName: TextView = itemView.findViewById(R.id.tvVehicleName)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvDateOrderId: TextView = itemView.findViewById(R.id.tvDateOrderId)
        val tvPickup: TextView = itemView.findViewById(R.id.tvPickup)
        val tvDrop: TextView = itemView.findViewById(R.id.tvDrop)
        val chipStatus: Chip = itemView.findViewById(R.id.chipStatus)
        val btnInvoice: MaterialButton = itemView.findViewById(R.id.btnInvoice)
        val btnBookAgain: MaterialButton = itemView.findViewById(R.id.btnBookAgain)
        val ivMore: ImageView = itemView.findViewById(R.id.ivMore)
    }

    // 2. Creates new views - called by RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    // 3. Binds data to views - called for each item
    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]

        // Set text data
        holder.tvVehicleName.text = order.vehicleType
        holder.tvPrice.text = "₹ ${order.price}"
        holder.tvDateOrderId.text = "${order.date} | Order ID: ${order.id}"
        holder.tvPickup.text = order.pickup
        holder.tvDrop.text = order.drop
        holder.chipStatus.text = order.status

        // Set status chip colors
        if (order.status == "CANCELLED") {
            holder.chipStatus.setChipBackgroundColorResource(R.color.red_50)
            holder.chipStatus.setTextColor(
                ContextCompat.getColor(holder.itemView.context, R.color.red_700)
            )
        } else {
            holder.chipStatus.setChipBackgroundColorResource(R.color.green_50)
            holder.chipStatus.setTextColor(
                ContextCompat.getColor(holder.itemView.context, R.color.green_500)
            )
        }

        // Click listeners for OceanX requirements
        holder.btnInvoice.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Downloading Invoice for ${order.id}",
                Toast.LENGTH_SHORT
            ).show()
        }

        holder.btnBookAgain.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Booking ${order.id} again",
                Toast.LENGTH_SHORT
            ).show()
        }

        holder.ivMore.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "More options for ${order.id}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    // 4. Returns total number of items
    override fun getItemCount(): Int = orders.size
}