package mobiledev.rpm.com.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

/**
 * Created by RenzManacmol
 */

class Messages(@Expose @SerializedName("success") val success: ArrayList<String>)
