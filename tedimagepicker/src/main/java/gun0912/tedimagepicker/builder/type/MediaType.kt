package gun0912.tedimagepicker.builder.type

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class MediaType : Parcelable {
    IMAGE,
    VIDEO;
}