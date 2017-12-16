package mobiledev.rpm.com.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by RenzManacmol
 */

data class Session(@Expose @SerializedName("id") val id: String,
                   @Expose @SerializedName("expire") val expire: String,
                   @Expose @SerializedName("YII_CSRF_TOKEN") val token: String)
