package mobiledev.rpm.com.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by RenzManacmol
 */

data class Data(@Expose @SerializedName("name") val name: String,
                @Expose @SerializedName("price") val price: String,
                @Expose @SerializedName("brand") val brand: String)
