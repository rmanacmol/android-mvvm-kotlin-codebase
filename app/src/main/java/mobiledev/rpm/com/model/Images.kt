package mobiledev.rpm.com.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by RenzManacmol
 */

data class Images(@Expose @SerializedName("url") val url: String)
