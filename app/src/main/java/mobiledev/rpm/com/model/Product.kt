package mobiledev.rpm.com.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by RenzManacmol
 */

data class Product(@Expose @SerializedName("success") val isSuccess: Boolean,
                   @Expose @SerializedName("messages") val messages: Messages,
                   @Expose @SerializedName("session") val session: Session,
                   @Expose @SerializedName("metadata") val metadata: Metadata
                )
