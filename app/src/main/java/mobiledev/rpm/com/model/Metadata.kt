package mobiledev.rpm.com.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

/**
 * Created by RenzManacmol
 */

data class Metadata(@Expose @SerializedName("product_count") val productCount: Int,
                    @Expose @SerializedName("results") val resultsArrayList: ArrayList<Results>
)
