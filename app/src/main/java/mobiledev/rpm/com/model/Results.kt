package mobiledev.rpm.com.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

/**
 * Created by RenzManacmol
 */

data class Results(@Expose @SerializedName("id") val id: Int,
                   @Expose @SerializedName("data") val data: Data,
                   @Expose @SerializedName("images") val images: ArrayList<Images>)
